# Vim Cheat Sheet #
From first-time users to astronauts.

# Commands I learned, in order #

    `i` to enter 'insert' mode, which allows for regular typing/editing
    `esc` to enter 'command' mode (leaves 'insert' mode)
    `:wq` to save (:w) and quit (:q)

    `x` to cut current letter
    `cw` to replace text from current position to end of word
    `u` to undo

    `v` to enter 'visual' mode, great for making selections
    `y` to 'yank', aka copy current selection
    `yiw` to yank inner word (copy current word under cursor)
    `d` to delete current selection
    `dd` to delete (and copy) current line (aka, cut current line)

    `a` to enter 'insert' mode, start append after cursor
    `o` to enter 'insert' mode, enter newline below
    `O` to enter 'insert' mode, enter newline above

    `^` jump to first non-blank character of current line
    `$` jump to end of current line
    `w` jump forward to start of word
    `e` jump forward to end of word
    `b` jump backward to start of word

    `r` to replace single character without entering insert mode
    `yyp` to duplicate current line (yy to copy and p to paste)
    `viwp` to paste over current word (v to visual mode, iw to select current word, p to paste)
    `ciw` to swap current word with word in clipboard



## Getting started ##

### [Learn Vim Progressively](http://yannesposito.com/Scratch/en/blog/Learn-Vim-Progressively/) ###
1. Survive.

    1. You are in something called 'normal' mode when you first enter Vim. In this mode, you run commands, not typing. To type, you need to be in 'insert' mode.
    2. You need to know just five commands:

            `i` to enter 'insert' mode (use `esc` to get back to 'normal' mode)
            `x` to delete the char under the cursor
            `:wq` to save and quit (`:w` to save, `:q` to quit)
            `dd` to delete (and copy) the current line
            `p` to paste

            Recommended:
            `hjkl` as arrow keys so you don't have to move hand from home row (left, down, up, right), hint: the `j` looks like a down arrow
            `:help` or `:help <command>` to show general help or information about a command.

    3. Commands that start with colon `:` need `enter` to be pressed for the command.
    4. Just get comfortable with these commands before moving on.
    5. In normal mode, it's like the `ctrl` key is always being pressed for you.

2. Feel comfortable.

    1. Insert mode variants:

            `o` to insert newline after current one
            `O` to insert newline before current one
            `cw` to replace from the cursor to end of the word

    2. More shortcuts to know: (not all from source are listed here)

            `u` to undo
            `ctrl+r` to redo
            `:e <path/to/file>` to open file
            `:saveas <path/to/file>` to save file to another path
            `:q!` to quit without saving
            `:bn` and `:bp` to show next and previous file (buffer)

3. Feel better, stronger, faster. (The more interesting stuff)

            `.` to repeat the last command
            `#<command>` to report the command # times
            `#G` go to line #
            `gg` as shortcut for `1G` go to start of file
            `G` go to last line
            `w` go to start of the following word
            `e` go to end of current word
            `%` go to corresponding `(`, `{`, `[`
            `*` and `#` go to next and previous occurrence of current word

4. Use superpowers of vim. (I leave this to the source website, lots of great descriptions)



- [A Vim Tutorial and Primer](https://danielmiessler.com/study/vim/): Offers advice for config file and more.






## Further Resources ##
- [How to learn Emacs](http://sachachua.com/blog/wp-content/uploads/2013/05/How-to-Learn-Emacs8.png): Yes, there is a Emacs link in a Vim article.
- [Visual Cheat Sheet](http://michael.peopleofhonoronly.com/vim/): Shows keyboard layouts with what each key does.
- [Interactive Vim tutorial](http://www.openvim.com/): Meh, kinda more like a video that accepts one specific key press at a time.
