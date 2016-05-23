# C++ Cheat Sheet
(work in progress)



## Quickstart

1. Install gcc or clang
2. Create 'hello.cpp' and fill with the following code:

        #include <iostream>
        using namespace std;
        int main() {
          cout << "Hello, World!" << endl;
          return 0;
        }

3. Run `g++ hello.cpp -o hello` or `clang++ hello.cpp -o hello` depending on your compiler preference.
4. Run the program with `hello`



## Basics

### Types

    Type        Meaning                             Minimum Size
    ====        =======                             ============
    bool        boolean                             NA
    char        character                           8 bits
    wchar_t     wide character                      16 bits
    short       short integer (signed by default)   16 bits
    int         integer (signed by default)         16 bits
    long        long integer (signed by default)    32 bits
    float       single-precision floating-point     6 significant digits
    double      double-precision floating-point     10 significant digits
    long double extended-precision floating-point   10 significant digits

    A signed type can represent both negative and positive numbers, whereas unsigned types represent only values greater than or equal to zero.
    An (8-bit) unsigned type holds values 0 to 255.
    A (8-bit) signed type holds values -127 to 127 (one's complement) or -128 to 127 (two's complement).

    const bool isHappy = true;
    char grade = 'A';
    int favoriteNumber = 7;
    float aNum = 3.14;
    double bNum = 6.281234;

    short int // At least 16 bits
    long int // At least 32 bits
    long long int // At least 64 bits
    unsigned int // Same size as signed/regular int
    long double // Not less than regular double

    ([more info](http://en.cppreference.com/w/cpp/language/types))

### Input and Output

    std::cin >> input; // Reads in one word
    std::cout << "Hello, World!" << endl; // Prints value to output




## Tips

- Get size of data type: `cout << "Size of int: " << sizeof(myInt) << endl;`
- Always include `ifndef HEADER_H` and `#define HEADER_H` before the includes and `#endif` after all the includes.

### Style Guide and Naming Convention
The following are common conventions, but if your large project already has a different convention, then follow that instead.

For file name, prefer 'lower_underscore_like_this.cc'.

Name classes, functions, and enums LikeThis
Name variables like_this
Name private member variables like_this_ (note the trailing underscore)
Name constants kLikeThis

Name macros LIKE_THIS

There never/rarely be global variables, but if your use one, then consider prefixing with 'g_' to distinguish from local variables.

([more info](https://google.github.io/styleguide/cppguide.html#Naming))



## Libraries

    #include <string>
    // Ability to use 'String' types more cleanly. You can concatenate with `str2 = str1 + "asdf"`.
    // Must include `using namespace std;`
    // When comparing strings with `<` or `>`, capital letters come before lower case letters.



## More Info

- Good: [Google's C++ Mini-course](https://developers.google.com/edu/c++/getting-started)
