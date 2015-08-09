#NoEnv  ; Recommended for performance and compatibility with future AutoHotkey releases.
SendMode Input  ; Recommended for new scripts due to its superior speed and reliability.
SetWorkingDir %A_ScriptDir%  ; Ensures a consistent starting directory.

;======================================================================================;
; Download AutoHotkey from http://www.autohotkey.com/
; # is Windows Key
; + is Shift
; ^ is Ctrl
; ! is Alt
; 
; {tab}
; {backspace}
; {left}{up}{right}{down}
;
; Send +{Click 100, 200}  ; Shift+LeftClick
; Send ^{Click 100, 200, right}  ; Control+RightClick
;
; Abbreviations to Expand
;::TY::Thank you
;======================================================================================;

; Sends a double-click at caret position. (WindowsKey + z)
#z::
	MouseGetPos X,Y
    Send {Click %A_CaretX%, %A_CaretY% 2}
    MouseMove (X),(Y)
RETURN

; Sends a double-click at caret position. (double-tap ctrl)
; Works in most non-web programs. Doesn't work well in many webpages.
; The purpose of the Mouse stuff if to move mouse back to original position, otherwise the mouse cursor
; would be moved to where the double-click is done.
Ctrl::
    If (A_PriorHotKey = A_ThisHotKey and A_TimeSincePriorHotkey < 500) {
	    MouseGetPos X,Y
	    Send {Click %A_CaretX%, %A_CaretY% 2}
	    MouseMove (X),(Y)
    }
RETURN
