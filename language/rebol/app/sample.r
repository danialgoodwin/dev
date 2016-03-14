REBOL []

;; Minimal sample
; alert "Hello, World!"

;; Variable sample
; birth: 10-Aug-1990
; alert reform [ "You are" now - birth "days old!" ]

;; GUI sample
; view layout [
;   backcolor gold
;   h2 "Web Bookmarks"
;   style btn btn 130
;   btn "REBOL.com" [browse http://www.rebol.com]
;   btn "REBOL.net" [browse http://www.rebol.net]
;   btn "REBOL.org" [browse http://www.rebol.org]
; ]

;; Console sample
; print "hello console"
; halt ;; Shows Rebol console

;; Files sample
; print read %sample-text.txt
; do %demo.r
; print read %readme.txt
; data: load %app/contacts.r
; dir: %"/c/documents and settings/dan/"
; dir: %/c/documents%20and%20settings/dan/

;; List directory
; files: load %../
; probe files

;; List all txt files in current directory
; file-list: []
; foreach file load %. [
;   if %.txt = suffix? file [append file-list file]
; ]
; probe file-list

;; List all music files in music directory
; file-types: [%.mp3 %.wma %.wav]
; file-list: []
; foreach file load %music/ [
;     if find file-types suffix? file [append file-list file]
; ]
; probe file-list





halt
