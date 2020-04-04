# Python Cheat Sheet

- [Basics](#basics)
    - [Logging](#logging)
    - [Testing](#testing)
- [Advanced](#advanced)
- [Snippets](#snippets)
    - [How to list contents of a directory](#how-to-list-contents-of-a-directory)
    - [How to create a list of tuples from a file](#how-to-create-a-list-of-tuples-from-a-file)
    - [How to make a Python file executable](#how-to-make-a-python-file-executable)
    - [How to unzip a file in Python 3](#how-to-unzip-a-file-in-python-3)
    - [How to use git in Python 3](#how-to-use-git-in-python-3)
- [PIP](#pip)
- [Resources](#resources)



## Basics

Files:

    with open('my-file.txt', 'r') as f:
        for line in f:
            print(line)
    
    with open('my-file.txt', 'w') as f:
        f.write('asdf\n')

String interpolation:

    'a is {} and b is {}'.format(a, b)

User input:

    num = input('Enter a number: ')

User input via argparse (optparse is deprecated):

    import argparse
    parser = argparse.ArgumentParser(description='Provide script options.')
    parser.add_argument('--mode', choices=['choose', 'create'], required=False)
    args = parser.parse_args()
    
    if not args.mode:
        user_input = input('Select a mode (choose, create): ')
        args = parser.parse_args(['--mode', user_input])

    if args.mode == 'choose':
        choose_word_cloud()
    elif args.mode == 'create':
        create_word_cloud()
    
### Logging

    import logging
    logging.basicConfig(level=logging.DEBUG, filename='myScript.log')
    logging.debug('My debug message')

### Testing

    import unittest
    class MyTestClass(unittest.TestCase):
        def setUp(self):
            self.my_widget = MyWidget('My widget')
        
        def test_my_method(self):
            self.assertEqual('foo'.upper(), 'FOO')
            self.assertTrue('FOO'.isupper())
            
        def test_my_error(self):
            s = 'hello world'
            self.assertEqual(s.split(), ['hello', 'world'])
            # check that s.split fails when the separator is not a string
            with self.assertRaises(TypeError):
                s.split(2)
     
    if __name__ == '__main__':
        unittest.main()



## Advanced

    import itertools
    
    # itertools.accumulate(...)
    
    grouped = {}
    key = lambda x: x[0]  # Return first character/element
    for k, names in itertools.groupby('Thing 1', 'Thing 2', 'Stuff 1', 'foo1', 'foo2'):
        grouped[k] = list(names)
    # Output: grouped = {'T': ['Thing 1', 'Thing 2'], 'S': ['Stuff 1'], 'f': ['foo1', 'foo2']}
    
    my_coins = [1, 5, 10, 25]
    for coin_combos in itertools.combinations(my_coins, 2):
        print(sum(coin_combosx))  # Output: 6, 11, 25, 15, 30, 35
    
    for name in itertools.product(['dan-'], ['a', 'b', 'c'], ['1', '2']):
        print(''.join(name))  # Output: dan-a1, dan-a2, dan-b1, dan-b2, dan-c1, dan-c2
    
    list(itertools.combinations([1, 2], 2))
    # [(1, 2)]
    
    list(itertools.permutations([1, 2], 2))
    # [(1, 2), (2, 1)]
    
    list(zip(['a', 'b', 'c'], [1, 2, 3]))
    # [('a', 1), ('b', 2), ('c', 3)]
    
    list(map(lambda x,y: x * y, [1, 2, 3], [4, 5, 6]))
    # [4, 10, 18]
    
    def sample_generator(n):
        while(1):
            yield n
            n = n + 1
    gen = sample_generator(1)
    for i in range(5):
        print(next(gen))  # 1, 2, 3, 4, 5
    
    import difflib
    check = difflib.SequenceMatcher(None, 'chinna', 'china')
    print(check.ratio())  # 0.909090909090909
    print(get_close_matches("chinna", ['china','france','india','usa']))  # ['china']
    
    
    

## Snippets

    import subprocess
    subprocess.run(['sed', '-ie', 's/{}/{}/g'.format(icon[0], icon[1]), file_path])

### How to list contents of a directory

Since Python v3.4 ([pathlib](https://docs.python.org/3/library/pathlib.html)):

    from pathlib import Path
    print(*Path('/home/username/www/').iterdir(), sep='\n')
    
    for path in Path('.').iterdir():
        print(path)
    
    # Recursive, and don't list hidden files
    Path('res').rglob('*.txt')

Old:

    import os
    os.listdir('/home/username/www/'

### How to create a list of tuples from a file
Example file:

    1, one fish
    2, two fish
    3, red fish
    4, blue fish

Option 1 - via 'import csv'

    import csv
    filename = 'my-file.csv'
    output = []
    with open(filename, 'r', newline='') as csvfile:
        reader = csv.reader(csvfile, delimiter=',')
        for row in reader:
            output.append(tuple(row))

More info: https://docs.python.org/3.4/library/csv.html#csv.reader

### How to make a Python file executable
Add this to the top of the .py file:

    #!/usr/bin/env python3

Make the actual file executable:

    chmod +x my-file.py

Run the script: `./my-file.py`

### How to unzip a file in Python 3

    from zipfile import ZipFile
    myZip = Path('./dir/my-zip.zip')
    outputPath = Path(f'{myZip}.bak')
    with ZipFile(myZip) as f:
        f.extractall(path=outputPath)

### How to use git in Python 3

    import subprocess
    subprocess.check_output(['git', 'add', 'my-file.txt'])

Alternatively, use the [GitPython package](https://github.com/gitpython-developers/GitPython)



## PIP

    py -m pip install <package>



## Resources

