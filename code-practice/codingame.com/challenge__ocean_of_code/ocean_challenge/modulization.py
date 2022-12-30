import sys
from types import ModuleType

class MockModule(ModuleType):
    def __init__(self, module_name, module_doc=None):
        ModuleType.__init__(self, module_name, module_doc)
        if '.' in module_name:
            package, module = module_name.rsplit('.', 1)
            get_mock_module(package).__path__ = []
            setattr(get_mock_module(package), module, self)

    def _set_class_(self, cls):
        self._cls_ = cls
        self.__doc__ = cls.__doc__

    def __getattr__(self, name):
        return getattr(self._cls_, name)

def get_mock_module(module_name):
    if module_name not in sys.modules:
        sys.modules[module_name] = MockModule(module_name)
    return sys.modules[module_name]

def modulize(module_name, dependencies=[]):
    for d in dependencies: get_mock_module(d)
    global __name__; stored_name, __name__ = __name__, module_name
    def wrapper(cls):
        get_mock_module(module_name)._set_class_(cls)
        global __name__; __name__ = stored_name
    return wrapper
