# Bash Cheat Sheet



## Awesome commands

### Count lines of Java
    find . -name '*.java' | xargs wc -l

### Show CSV
    cat data.csv | column -t -s ','

### More

Change to previous directory: `cd -`

Search history: `ctrl + r`

Easily run sudo on last command: `sudo !!`

Get the last argument in the last command: `!$`

Magic braces:

    mv my-file.{txt,md}
    mv my-file.txt my-file.md
    
    {1..3}
    1 2 3

In-line evaluation:

    touch my-file-$(date -I).txt # Creates 'my-file-2020-02-25.txt'



## Navigation

- Start of line: `ctrl + a`
- End of line: `ctrl + e`
- clear screen: `ctrl + l`



## Control logic

Loops:

    for i in *.txt
    do
        cat $1
    done



## Resources
