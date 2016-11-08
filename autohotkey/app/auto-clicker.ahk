#NoEnv  ; Recommended for performance and compatibility with future AutoHotkey releases.
SendMode Input  ; Recommended for new scripts due to its superior speed and reliability.
SetWorkingDir %A_ScriptDir%  ; Ensures a consistent starting directory.

global isRun = false
global clickFrequencyInMilliseconds = 1000

~$F7::
    While GetKeyState("F7", "P") {
        ;Click
        sendInput, {LButton}
        Sleep clickFrequencyInMilliseconds
    }

;; The following is experimental
; Start auto-clicking
;F7::
;    isRun = true
;    while (isRun) {
;        sendInput, {LButton}
;        Sleep clickFrequencyInMilliseconds
;    }

; Stop auto-clicking
;F8::
;    isRun = false
