# My Java Code Style #
(Based off of AOSP contributer code style guidelines.)

1. If there is already a different code style guideline in place, then use that.
2. If not, pick a common style (like this or AOSP or Java) and stick with it.


## Indentation and Spacing ##

- Prefer line wraps at 80 characters, but 100 is okay too. Wrapped lines should have an eight space indent. Code inside a function should be indented four spaces.
- Opening braces do not start a newline and have a single space before them. Closing braces do start a new line.
- For conditional statements
 - There should be a single space on either side of the parenthesis.
 - They should always have braces, even for single lines. Ex: `if (isSomething()) { return; }`
- For method signature, there should be no space between the method name and open parenthesis.
- Operators get a spacing before and after.
- Never use the tab character; Always have your IDE convert all tabs to spaces.

### Example ###
    public class Example {
        
        private String name;
        
        private int time = 60 * 60 * 1000;
        
        public static void main(String[] args) {
            if (name == null) {
                name = "Test";
            }
            
            if (name.equalsIgnoreCase("Test") || name.equalsIgnoreCase("Tester")
                    || name.equalsIgnoreCase("TestA") || name.equalsIgnoreCase("TestB")
                    || name.equalsIgnoreCase("TestA") || name.equalsIgnoreCase("TestB")) {
                // TODO: Do something.
            }
        }
        
    }


## Comments ##

- All classes must be prefaced with Javadoc.
- All public API methods must be prefaced with Javadoc.
- Internal methods should have comments. If doubt, write it out.
- Use TODO comments for temporary code. They should always be in all caps, and followed by a colon. Ex: `// TODO: Clean this function.`


## Ordering of variables and methods in a class ##
    public class Example {
        
        // Variables
        
        // Constructors
        
        // Methods
        
    }


## Naming ##
- The default (no modifier) visibility of variables and classes is "package-private". To be more clear on that intention, use `/* package */` so that others know it was done on purpose.
- Use fully qualified imports. Use `import foo.Bar;` and don't use `import foo.*;`
- Constant fields (`static final`) should be in the format of ALL_CAPS_WITH_UNDERSCORES. Other fields start with a lowercase letter.
- Treat acronyms as words. Do: `XmlHttpRequest`, Don't: `XMLHTTPRequest`, Do: `String url`, Don't `String URL`, Do: `getCustomerId()`, Don't: `getCustomerID()`.


## Exceptions ##
- Never ignore exceptions in code. If there is nothing required to do, then comment why.
- Never catch the generic `Exception`; Always catch specific sub-classes. List out many of them if you have to.


## Different Convensions ##
- [AOSP Code Style Guidelines for Contributors](https://source.android.com/source/code-style.html)
- [Square](https://github.com/square/java-code-styles)

