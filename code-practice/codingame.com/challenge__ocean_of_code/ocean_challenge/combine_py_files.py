import os.path
from pathlib import Path


class burn_after_reading:
    """Return an empty list if already calculated."""

    def __init__(self, f):
        self.memo = set()
        self.f = f

    def __call__(self, *arg):
        if arg in self.memo:
            return []
        else:
            self.memo.add(arg)  # Do this here to avoid infinite loops
            val = self.f(*arg)
            return val


#################
# Code snippets #
#################

fake_module_preamble_str = \
    """\
    import sys
    from types import ModuleType
    
    class MockModule(ModuleType):
        def __init__(self, module_name, module_doc=None):
            ModuleType.__init__(self, module_name, module_doc)
            if '.' in module_name:
                package, module = module_name.rsplit('.', 1)
                get_mock_module(package).__path__ = []
                setattr(get_mock_module(package), module, self)
    
        def _initialize_(self, module_code):
            self.__dict__.update(module_code(self.__name__))
            self.__doc__ = module_code.__doc__
    
    def get_mock_module(module_name):
        if module_name not in sys.modules:
            sys.modules[module_name] = MockModule(module_name)
        return sys.modules[module_name]
    
    def modulize(module_name, dependencies=[]):
        for d in dependencies: get_mock_module(d)
        return get_mock_module(module_name)._initialize_
    
    ##===========================================================================##
    """

main_section_str = \
    """\n
    def {short_name}():
        ##----- Begin {file} {padded_dashes_0}##
    {text}
        ##----- End {file} {padded_dashes_1}##
    
    {short_name}()
    """

package_section_str = \
    """
    @modulize('{name}'{dependencies})
    def _{short_name}(__name__):
        ##----- Begin {file} {padded_dashes_0}##
    {text}
        ##----- End {file} {padded_dashes_1}##
        return locals()
    """

module_section_str = \
    """
    @modulize('{name}'{dependencies})
    def _{short_name}(__name__):
        ##----- Begin {file} {padded_dashes_0}##
    {text}
        ##----- End {file} {padded_dashes_1}##
        return locals()
    """


def get_modules_from_import_line(line):
    line = line.strip()
    if line.startswith('import'):
        # import module1 as x, module2 as y, ...
        line = line[7:]  # remove "import "
        for import_str in line.split(","):
            module = import_str.split()[0].strip()
            yield module

    elif line.startswith('from'):
        line = line[5:]  # remove "from "
        module, names = [s.strip() for s in line.split(" import ")]
        yield module
        for name in [n.strip() for n in names.split(",")]:
            yield module + '.' + name  # name is likely not a module, but it could be

    # else: # not an import statement


@burn_after_reading
def parse_import_structure(package_dir, file='__main__.py'):
    print(f'parse_import_structure({package_dir})')
    module_list = []
    dependencies = set()
    with open(package_dir + file, 'r') as f:
        for line in f:
            for module in get_modules_from_import_line(line):
                module_prefix = []
                if module[0] == '.' and module[1] != '.':
                    module = module[1:]
                for m in module.split('.'):
                    module_prefix += [m]
                    path_prefix = "/".join(module_prefix)
                    print(f'path_prefix={path_prefix}')
                    if os.path.isfile(package_dir + path_prefix + '.py'):
                        module_list += parse_import_structure(package_dir, path_prefix + '.py')
                        dependencies.add(".".join(module_prefix))

                    elif os.path.isfile(package_dir + path_prefix + '/__init__.py'):
                        module_list += parse_import_structure(package_dir, path_prefix + '/__init__.py')
                        dependencies.add(".".join(module_prefix))
                    # elif Path(f'').is_file()

    return module_list + [(file, dependencies)]


def file_to_module(file, main_file='__main__.py'):
    if file == main_file:
        module_type = 'main'
        name = file.replace('.py', '').replace('/', '.')
    elif file.endswith('__init__.py'):
        module_type = 'package'
        name = file.replace('/__init__.py', '').replace('/', '.')
    else:
        module_type = 'module'
        name = file.replace('.py', '').replace('/', '.')

    return module_type, name


def block(file, module_type, module_name, text_block, dependencies):
    short_name = module_name.split('.')[-1]
    text = "    " + "\n    ".join(text_block.split('\n'))
    if module_type == 'main':
        return (main_section_str.format(short_name=short_name,
                                        text=text,
                                        file=file,
                                        padded_dashes_0='-' * (63 - len(file)),
                                        padded_dashes_1='-' * (65 - len(file))))

    elif module_type in ('module', 'package'):
        if dependencies:
            dependency_text = ", dependencies=" + str(list(sorted(dependencies)))
        else:
            dependency_text = ''
        return (module_section_str.format(short_name=short_name,
                                          name=module_name,
                                          file=file,
                                          text=text,
                                          dependencies=dependency_text,
                                          padded_dashes_0='-' * (63 - len(file)),
                                          padded_dashes_1='-' * (65 - len(file))))


def combine_into_one_file(package_dir, main_file='__main__.py', out='_combined.py', verbose=True):
    module_list = parse_import_structure(package_dir, main_file)
    visited = set()

    with open(out, 'w') as combined:
        combined.write(fake_module_preamble_str)

        for file_name, dependencies in module_list:
            if verbose:
                print("...", file_name)

            module_type, module_name = file_to_module(file_name)
            visited.add(module_name)
            remaining_dependencies = dependencies - visited

            with open(package_dir + file_name, 'r') as f:
                b = block(file_name, module_type, module_name, f.read(), remaining_dependencies)
                combined.write(b)


if __name__ == '__main__':
    import sys  # replace with argparser

    input_path = sys.argv[1]  # entry file or directory
    output_file = sys.argv[2]

    if os.path.isfile(input_path):
        start_dir, start_file = os.path.split(input_path)
        combine_into_one_file(start_dir, start_file, out=output_file)
    elif os.path.isdir(input_path):
        start_dir = os.path.join(input_path, '')  # puts in proper form with slash at end
        combine_into_one_file(start_dir, out=output_file)  # my_file = '__main__.py'
    else:
        print("Improper input file/dir.")
        sys.exit(2)

    print("Successfully combined files.")
