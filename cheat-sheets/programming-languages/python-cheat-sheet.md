# Python Cheat Sheet


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



# PIP

    py -m pip install <package>



# Resources

