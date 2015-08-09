#NoEnv  ; Recommended for performance and compatibility with future AutoHotkey releases.
SendMode Input  ; Recommended for new scripts due to its superior speed and reliability.
SetWorkingDir %A_ScriptDir%  ; Ensures a consistent starting directory.

;======================================================================================;
; # is Windows Key
; + is Shift
; ^ is Ctrl
; ! is Alt
; 
; 
; 
; {backspace}
; {enter}
; {shift down}{shift up}
; {tab}
; {left}{up}{right}{down}
;
; Send +{Click 100, 200}  ; Shift+LeftClick
; Send ^{Click 100, 200, right}  ; Control+RightClick
;
; myVariable = 18
; Send %myVariable%
; myVariable++
;
;
;
;======================================================================================;

; map caps lock key to enter key
Capslock::Enter

Enter::
    SetCapsLockState, off
    Suspend On
    Send, {ENTER}
    Suspend Off
return


; double-click at cursor location when windowskey+z
#z::
    xoff=0
    yoff=0
    MouseGetPos,X,Y
    MouseMove,(A_CaretX-xoff),(A_CaretY-yoff)
    Send {Click  %A_CaretX%,%A_CaretY% 2}
    ;click 2
    MouseMove,(X),(Y)
return

; double-press ctrl to double-click
;Ctrl::
;    If (A_PriorHotKey = A_ThisHotKey and A_TimeSincePriorHotkey < 500) {
;        MouseGetPos X,Y
;        Send {Click  %A_CaretX%,%A_CaretY% 2}
;        MouseMove (X),(Y)
;    }
;return

#space::run www.google.com

