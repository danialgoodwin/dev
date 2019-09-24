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


## Snippets

    import subprocess
    subprocess.run(['sed', '-ie', 's/{}/{}/g'.format(icon[0], icon[1]), file_path])

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
    with open(filename, 'r') as csvfile:
        reader = csv.reader(csvfile, delimiter=',')
        for row in reader:
            output.append(tuple(row))


### How to make a Python file executable
Add this to the top of the .py file:

    #!/usr/bin/env python3

Make the actual file executable:

    chmod +x my-file.py

Run the script: `./my-file.py`

