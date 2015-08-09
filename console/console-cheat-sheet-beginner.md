# Console Cheat Sheet: Beginner #


## Basic Commands ##

    ls [OPTION] [DIRECTORY]     list files
        -l                          long form
        -a                          show all files, including hidden files
    clear                       clear the screen
    cd [DIRECTORY]              change directory
    pwd                         print working directory
    man PROGRAMNAME             show the manual (help information) for a command, ex: `man man` or `man cd`.
    less [FILE]                 view file (can scroll with arrow, page down with space, `q` to quit/exit)
    more [FILE]                 view file one page at a time (not as good as `less`)
    cat [FILE]                  print the contents of one or more files (concatenate)
    touch FILE                  update the "last modified" timestamp on a file to time now. Also, creates an empty file if the filename doesn't exist
    nano [FILE]                 open a simple text editor (can more around normally with arrows, shows hotkeys at bottom, ctrl+x to exit)
    vim [FILE]                  open an advanced text editor (start in command mode, `i` for insert mode, `q` to exit, `w` to save, `wq` to save and exit)
    mv [FILE] [FILE]            move file/directory from to, can be used for renaming
    cp [OPTION] [FILE] [FILE]   copy a file/directory and leaved the original alone
        -r                          recursively copy all files/directories in a directory
    rm [OPTION] [FILE]          remove/delete a file/directory, which can be dangerous because no confirmation
        -r                          recursively remove all files/directories in a directory
    mkdir [OPTION] [DIRECTORY]  make directory
        -p                          make nested directories
    echo                        show the arguments
    grep [OPTION] PATTERN [FILE]    search for a pattern, returns any lines that contain the pattern (Global Regular Expression Print), ex: `grep "lol" hello.txt`.
        -n                              show the line number in result
        -i                              perform a case-insensitive search
        -v                              show lines without the pattern
        -r                              recurse, search all files in directories
    find [DIRECTORY] [EXPRESSION]   search for files, ex: `find . -name "hello"`
    sort                            sort the lines of standard input and send it to standard output

### Sample Examples and Simple Explanations ###

Example:

    $ ls -l
    total 1
    drwxrwxr-x+ 1 Danial None  0 Jan 10 22:47 test
    -rw-rw-r--  1 Danial None 23 Jan 10 22:48 hello.txt

Explanation:
- `total 1` is the number of files.
- `drwxrwxr-x` has a `d` for directory, then there are three groups of `rwx`, which stands for read, write, and execute permissions for user, group, and public respectively.

Example:

    $ cd ~
    $ cd /
    $ cd ..

Explanation:
- Change directory to home directory (the tilde `~`).
- Change directory to root directory (the slash `/`).
- Change directory to parent directory (the double-dot `..`).


## Intermediate Commands ##

    bash                        open a new session
    exit                        end a session
    which PROGRAMNAME           show the location of the program

### Pipes and Redirection ###

    somecommand < inputfile             run somecommand with input from inputfile, instead of the keyboard
    somecommand > outputfile            run somecommand with output to outputfile, instead of the console screen (overwrites file if it already exists)
    somecommand >> outputfile           run somecommand with output to outputfile, instead of the console screen (appends to file if it already exists)
    somecommand 2> outputfile           run somecommand and redirect the standard error stream to outputfile, ex: `find / -name "sudoers" 2> error_log.txt`.
    command1 | command2                 pipe/send the output from command1 to the input of command 2

- If you don't care about the output, then redirect it to `/dev/null`. Anything sent to it will be deleted/ignored, ex: `find / -name "sudoers" 2> /dev/null`.


## User Management Commands ##

    whoami              print which user you are
    adduser [USER]      interactive tool for creating users (requires sudo)
    su [USER]           switch user
    sudo                run a command as the super user
    exit                end a session
    chmod MODE FILE     change permissions (mode) of a file/directory. Mode is a combination of user+operator+permission, or symbolically as `[ugoa...][[+-=][perms...]]`. `u` for user/owner, `g` for group, `o` for other/public, `a` for all. `+` to add the permissions, `-` to remove the permissions, `=` to set equal to stated permissions. Permissions include rwxXst or one of ugo (the permissions for that user/group/other). `r` for read, `w` for write, `x` for execute. Or, use OCTAL-MODE, ex: `chmod 777 hi.txt`, where the digits represent the user/owner, group, and other/public. read is 4, write is 2, execute is 1, and add them to have multiple permissions.
        -R                              recursively change the permissions in a directory
    chown [OWNER][:[GROUP]] FILE    change the owner of a file/directory (requires sudo)


## Processes ##
Basically, a process is an instance of a program.

- Use `ctrl+z` to stop/pause a process.
- Use `ctrl+c` to terminate/exit a process.
- Use `&` at the end of a command to send process to background immediately.

    top [OPTION]                show active processes (tip: Press `?` to show help)
    ps [OPTION]                 show process statuses
        aux                         show more good info for All Users (note: Doesn't include `-` because of historical and compatibility issues. This may be the best way to use)
    jobs                        list jobs for your session (basically, a job is just a process)
    fg [ID}                     bring a job to the foreground
    kill [SIGNAL] [ID]          send a signal to a process (default is TERM=Terminate, which is like `ctrl+c`)
        -STOP                       stop a process, like `ctrl+z`
        -KILL                       immediately shutdown a process


## Environment Variables ##
- To use variable, put a dollar sign (`$`) in front of it, ex: `echo $HOME`.
- In POSIX environment, `PS1` determines how the console will display the prompt, ex: `PS1="\u \w $"` or `PS1="%n@%m:%~%#"`.
- The PATH can changed for sessions by adding the set command to `.bashrc` (or another startup file depending on the console).

    env                         show environment variables
    VARIABLE=value              set a local environment variable, ex: `MESSAGE="Hello, World!"` and use by `$MESSAGE`.
    export VARIABLE=value       set an environment variable that will be visible to child processes


## Installing Programs ##

    apt-get update              update local catalog/database of available programs (requires sudo)
    apt-cache search PATTERN    search local catalog of available programs
    apt-get install PACKAGE     install a package
    apt-get remove PACKAGE      remove/uninstall package from computer

- Note: `apt-get` is available on Ubuntu (Debian), other console/OS may have a different package manager.
- APT stands for Advanced Packaging

### Building from Source Code ###

    curl -O URL                 download the file at the URL
    tar -xvf FILENAME.tar.gz    decompress the tar.gz file to the current directory (`x` for ,`v` for verbose, `f` for file)
    ./configure                 run the configure script that comes with the source code, this creates a Makefile
    make                        run the build specified in the Makefile
    sudo make install                run the install script from the Makefile, this installs the program

- Use `apt-get install build-essential` to install the tools needed to build software from source code.


## Tips ##

- After executing a command, you can press the up key to show previous executed commands.
- If there is a yes/no question (usually has `y/n` at the end of it) and either the `y` or `n` is captitalized, then that will be the default option is nothing is entered.
- Use the `!!` command to run the previous command. Use `sudo !!` to run the previous command as the super user.
