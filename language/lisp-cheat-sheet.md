# Lisp Programming Language Cheat Sheet #

Lisp files are saved with ending of ".lisp".

- Lisp is NOT case-sensitive.
- Variables can have letters, numbers, +, -, *, _, = ? ~ < >, but not whitespace.
- Has higher-order function (can pass in functions as arguments).
- Has macros. `defmacro`
- Can create classes. `defclass`

## How to get started from scratch ##

Go to [clisp.org](http://www.clisp.org/), then choose the most appropriate version for your OS on the right-hand side. Download and install the package.

Once installed, double-click the shortcut to the Lisp shell. Type in the following simple one-liner

    (print "Hello World")

And, here's another complete program. How to exit program:

    (quit)
    


## Syntax ##

### Comments ###

Top-level comments to describe program are done with quadruple semicolon `;;;;`, and the rest of the time line comments will be triple-semicolon `;;;`. A double-semicolon `;;` can be used with indented code. A regular single semicolon can be used to start a comment after a line of code. To have a multi-line comment, use `#||` to start and `||#` to end.

### Output ###

    ;; The `~%` stands for newline. The `t` stands for terminal.
    (format t "Hello world ~%")
    
    ;;;
    (print "Hello World")

### Variables ###

    ;; Global variable, by convention are surrounded by asterisks to spot them easier.
    ;; `(read)` is used to get input data from console.
    (defvar *name* (read))
    
    ;; Change variable values.
    (defvar *number* 0)
    (setf *number* 6)

### Functions ###

    ;; Define function.
    (defun hello-you (name)
        (format t "Hello ~a~ ~%" name))
    
    ;; Call function.
    (hello-you *name*)

    ;; Get average.
    (defun get-avg (num-1 num-2)
        (/ (+ num-1 num-2) 2))
    (get-avg 10 50); Calls the function, passes in two arguments.

#### Higher-order functions ###

    todo    

### Math ###

    ;; Function name, then two attributes.
    ;; Lisp reads the following into cells, like "[+] [1] [2] [nil]", where nil is marking end.
    (+ 1 2)
    (+ 1 (- 5 3))
    (/ 5 4); Output=5/4
    (/ 5 4.0); Output=1.25
    (rem 5 4); Remainder
    (mod 5 4); Modulus
    (expt 4 2); exponent. Output=16
    (sqrt 81); square root. Output=9
    (eq 'dog 'dog); equality. Output=T (for true, "Nil" is for false)
    (equal "string" "String"); Output=Nil
    (equalp 1.0 1); Output=T
    ;;; Also, log, exp, floor, ceiling, max, min, oddp, evenp, numberp, sin, cod, tan, asin, acos, atan
    
### Conditionals ###

    (defvar *age* 18)
    
    (if (?= *age* 18)
        (format t "You can vote~%")
        (format t "You can't vote~%")); "else" is built-in.
    
    (defun get-school (age)
        (case age
            (5 (print "Kindergarten"))
            (6 (print "First Grade"))
            (otherwise (print "middle school"))))

    (when (= *value* 5)
        ()
        ())

### Loop ###

    (loop for x from 1 to 10
        do (print x))
        
    (loop
        ()
        (when ()
            (return x)))
    
    (dotimes ()
        ())


### Data structures ###

    (list 'superman 'batman 'flash)
    
    ;;; Get first item with (car ())
    ;;; Get non-first item with (cdr ())
    ;;; Get second item with (cadr ())
    ;;; Get fourth item with (cadddr ())

    (defvar superman (list :name "Superman" :secret-id "Clark Kent"))
    (defvar *hero-list* nil)
    (push superman *hero-list*)
    (dolist (hero *hero-list*)
        (format t "~[~ : ~a ~]~%" hero))


### File IO ###

    ;;; Write text to a file.
    (with-open-file (my-stream
                     "test.txt"
                     :direction :output
                     :if-exists :supersede)
        (print "Some random text" my-stream)))
    
    ;;; Read data from a file
    (let ((in (open "test.txt" :if-does-not-exist nil)))
       (when in
          (loop for line = (read-line in nil)
          while line do (format t "~a~%" line))
          (close in)
       )
    )



## Further Resources ##
- [Official website](http://www.clisp.org/)
- Great: [Lisp Tutorial on YouTube](https://www.youtube.com/watch?v=ymSq4wHrqyU)
