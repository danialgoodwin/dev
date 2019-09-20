# Xcode Cheat Sheet


## UI

### Storyboard

#### How to add a new constraint
1. Open the storyboard
2. Click 'Add New Constraints', which can be found at the bottom right of the storyboard, the second-from-the-right button

Notes:
- In the 'Add New Constraints' popup, even though there are numbers at the top, the drop-down option provides the ability to contraint to another view instead, but all view may not be available. You may have to add the contraint, the edit it later.
- To easily swap the first and second item, select the drop-down for either item, then click 'Reverse First And Second Item'


## Simulator


## Workspace

### How to open file in a new tab

    option + click


## Debugging

### How to skip execution of a line of code

- Option 1: Drag the handle (`=`) on the right of the current line to the line you are interested in
- Option 2: Configure the breakpoint to skip the line of code by adding the expression: `thread jump --by (number of lines to skip)`


More resources:
- Xcode Debugging Tips And Tricks — WWDC 2018: https://medium.com/@pratibha.r.shetty/xcode-debugging-tips-and-tricks-wwdc-2018-255b87bed17b
