# JetBrains IDE Cheat Sheet
This includes JetBrains IntelliJ IDEA, JetBrains Rider, and more


## Setup

### Setup git in the terminal
If Mac:
1. Go to IntelliJ > Preferences... > Tools > Terminal
2. Change the 'Shell path' to '.../git/bin/sh.exe'

If Windows:
1. Go to File > Settings... > Tools > Terminal
2. Change the 'Shell path' to 'C:\Program Files\Git\bin\sh.exe'


### Other changes I like to make

In Settings:
- Editor:
    - General
        - Under 'Strip trailing spaces on Save', uncheck 'Always keep trailing spaces on caret line'. Reason: More often I want to remove that space if I'm going through the trouble of 'ctrl+s'
        - Appearance:
            - Uncheck 'Show line numbers'. Reason: More workspace, can use 'control + g' to go to line, and current line number appears on the bottom status bar
            - Check 'Show whitespaces' Reason: Show tabs that should spaces, or vice-versa. Otherwise, just change them automatically on save
        - Editor Tabs:
            - Set 'Close button position' to 'None'. Reason: More space for tabs, and I never click the close button. I'll either use `shift+click' to close or `ctrl+f4`
        - Font:
            - Set 'Font' to 'JetBrains Mono'. Reason: Lowercase letters are bigger, and more ligatures.


#### Add shortcuts for 'split-right' and 'split-down'

| OS      | Action                | Shortcut                 |
| ------- | --------------------- | ------------------------ |
| Mac     | Split and Move Right  | `command + W, <right>`   | 
| Mac     | Split and Move Down   | `command + W, <down>`    | 
| Mac     | Split Horizontally    | `command + W, <up>`      | 
| Mac     | Split Vertically      | `command + W, <left>`    |
| Windows | Split and Move Right  | `alt + W, <right>`       | 
| Windows | Split and Move Down   | `alt + W, <down>`        | 
| Windows | Split Horizontally    | `alt + W, <up>`          | 
| Windows | Split Vertically      | `alt + W, <left>`        |
