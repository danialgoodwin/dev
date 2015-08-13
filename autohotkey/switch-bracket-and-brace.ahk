; Switch the square bracket keys with curly bracket keys.
; ========================================== ;
#NoEnv  ; Recommended for performance and compatibility with future AutoHotkey releases.
SendMode Input  ; Recommended for new scripts due to its superior speed and reliability.
SetWorkingDir %A_ScriptDir%  ; Ensures a consistent starting directory.
; ========================================== ;

; Change via Registry: http://ahkscript.org/docs/misc/Remap.htm#registry

; Source: http://superuser.com/questions/425873/replace-with-and-with-using-autohotkey
*$[::
    if (GetKeyState("Shift"))
        SendInput, {[ Down}
    else
        SendInput, {{ Down}
    return

*$]::
    if (GetKeyState("Shift"))
        SendInput, {] Down}
    else
        SendInput, {} Down}
    return

*$[ Up::
    if (GetKeyState("Shift"))
        SendInput, {[ Up}
    else
        SendInput, {{ Up}
    return

*$] Up::
    if (GetKeyState("Shift"))
        SendInput, {] Up}
    else
        SendInput, {} Up}
    return


; More info: http://ahkscript.org/docs/misc/Remap.htm
; Pressing the curly brace key return the curly brace key.
; Though, brackets are properly changed.
;[::{
;]::}
;{::[
;}::]

; Not tested.
;[:: SEND {
;]:: SEND }
;{:: SEND [
;}:: SEND ]

