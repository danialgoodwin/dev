# Ruby Cheat Sheet - Basics #
(IRB: Interactive Ruby)


Once in `irb`, type `exit` or `quit` to leave the shell/process.

- Comments are done with `#`.

The "hash rocket": =>



## Variables ##

- Global: These have a `$` in front and are typically written in lower case (or uppercase).
- Local: Typically written in lower case and underscored spacing between words. Available in scope.
- Instance: Used in classes, name starts with `@`, then name typically written in lower case and underscored spacing between words. Available throughout a class.
- Constant: By convention, these are in all upper case with underscore spacing between words.



### Example 1 ###
1. Create a new file called `hello.rb`
2. Add the following to the file: `puts "Hello World!"
3. Run the program by `ruby hello.rb`

### Example Code ###

    name = "Dan"
    puts "Hello #{name}"
    
    print "Please enter your name: "
    name = gets
    puts "Hello #{name}"


### [String](http://ruby-doc.org/core-2.1.2/String.html) ###

    String.new # => ""
    s = String.new("Hello World") # => "Hello World"
    s = 'Hello World' # => "Hello world"
    
Gotchas: There is a difference between single-quote String and double-quote String in Ruby. Single (or using `%q(String)`) is verbatim (no interpolation), and double (or using `%Q(String)) allows Ruby to parse/interpolate the String to replace variables. (Sidenote: character after "Q" or "q" doesn't have to be parentheses, just about any character would work as long as it is closed with the same character.)

    name = "Dan"
    puts "Hello #{name}" # => Hello Dan
    puts 'Hello #{name}' # => Hello #{name}

The following two are the same. The second is called a heredoc. Both can interpolate variables within.

    name = "
    Hello
    My name is #{variable_name}
    "
    
    name = <<-SOME_STRING
    Hello
    My name is #{variable_name}
    SOME_STRING

#### Operations ####

By adding a bang `!` to the end of these method, you will change the variable itself instead of just returning a new variable.

    name = "Dan"
    last_name = "Goodwin"
    full_name = name + " " + last_name
    name[0] # => 65, the ASCII code for "D"
    name.chomp # => Removes all whitespace from beginning and end, including newline character "\n"
    name.chop # => Removes all whitespace from end, including newline character "\n"
    name.index("D") # => 0
    name.include?("Da") # => true
    name.upcase
    name.downcase
    name.reverse # => "naD"
    name.reverse.upcase # => "NAD"
    name.swapcase # => "dAN"
    name.length # => 3
    name.size # => 3
    
    name * 3 # => "DanDanDan"
    name << " " << last_name # => "Dan Goodwin", also name variable gets assigned everything after it.
    
    name.replace("Danial") # => "Danial"
    
    "Hello World !".split(" ") # => ["Hello", "world", "!"]
    
    "a".ord # Returns the `Integer` ordinal of a one-character string, aka ASCII code.
    
    # Print number formatted to two decimal places.
    puts sprintf("%0.2f", bank_account.balance)

#### Special (Escape) Characters ####

Use these "escape" chacters to print whitespace in strings.

    \n          newline
    \t          tab
    \s          space
    \v          vertical tab
    \b          backspace
    \"
    \'
    \\          backslash

    name = "Dan"
    string = "Hello, my name is #{name}.\nCool!"

### Numbers ###

- [Fixnum](http://www.ruby-doc.org/core-2.1.2/Fixnum.html)
- [Float](http://www.ruby-doc.org/core-2.1.2/Float.html)
- Rational
- BigDecimal

#### Examples ####

    a = 1
    b = 2.2 # Same as `2.+(2)`
    c = a + b
    
    num = 012 # Creates octal number, which is 10 in base 10
    
    string = "100"
    number = string.to_i # Converts string to Fixnum, and ignores fractional part
    number = string.to_f # Converts string to Float, adds ".0" if needed
    
    year = 2015
    puts "The year is #{year}"
    puts "In five years, the year will be #{year + 5}"
    future = 5
    puts "In #{future} years, the year will be #{year + future}"
    
    count = "Count: " + 5 # Error: No conversion from integer to string
    count = "Count: " + 5.to_s # This is how to append numbers to string.
    
    amount = 100.5
    sprintf("$%0.2f", amount) # => "$100.50" # Same as `format()`
    

Beware floating point math.

    7.3 - 7.2 # => 0.0999999999999964

To get around this, use BigDecimal

    require "bigdecimal" # Required to use BigDecimal
    a = BigDecimal.new("7.3");
    b = BigDecimal.new("7.2");
    c = a - b # Has value of 0.1E0

#### Operations ####

    +, -, *
    /               division without remainder
    %               modulus (or, remaidner)
    **              exponent
    ==, !=
    <, <=, =>, >
    <=>             combined comparison operator ("spaceship" operator): Returns 0 if both sides are equal, 1 if left side is greater, and -1 if right side is greater
    .eql?           returns true if same type and same value, ex: 10.eql?(10.0) returns false
    
    num = 10
    num += 1 # => 11
    num **= 11 # => 121

#### Precedence ####

Gotchas:

    1 && 2 # => 2
    2 && 1 # => 1
    1 && 2 == 1 && 2 # => false

Order, from highest (solved first) to lowest. Items on the same line are equivalent precedence:

    ()
    ==
    &&, ||

#### Math ####

Constants are `E` and `PI`.

    Math::E # => 2.718281828459045
    Math::PI # => 3.141592653589793
    Math.log(10, 10) # => 1

#### Money ####
A Ruby gem that encapsulates all the difficulties of working with currency in code, including rounding and converting between monetary units.

    gem install money # Call this in the system console
    require "money" # Add this to top of Ruby file to use
    
    price = Money.new(1000) # Provide number of cents
    puts price # => 10.00
    

#### Random Numbers ####

    rand # Returns a random number 0-1 every time it is called
    rand 100 # Returns a random integer 0-100


### Datatypes ###

    1.class # Returns Fixnum
    a = 2
    a.class # Returns Fixnum
    b = 3.14
    b.class # Returns Float
    true.class # Returns TrueClass. true is a singleton.
    false.class # Returns FalseClass. false is a singleton.
    nil.class # Returns NilClass. nil is a singleton.

#### [nil](http://www.ruby-doc.org/core-2.1.5/NilClass.html) ###

    nil => nil
    nil.class => NilClass
    nil.inspect => "nil"
    nil.to_i => 0
    0.nil? => false
    nil.to_a => []
    [].nil? => false
    [] == nil.to_a => true
    nil.to_h => []
    nil.nil? => true
    !nil => true
    true.nil? => false

### Conditionals / Control Structures ###

    car1_speed = 500
    car2_speed = 300
    if car1_speed > car2_speed
      puts "Car 1 is faster than car 2."
    end
    
    name = gets.chomp
    if name == "Dan"
      puts "That's my name, too!"
    else
      puts "Hi #{name}!"
    end
    
    name = gets.chomp
    if name == "Dan"
      puts "That's my name, too!"
    elsif name.downcase = "nad"
      puts "That's my name backwards!"
    else
      puts "Hi #{name}!"
    end
    
    case name
      when "Dan"
        puts "That's my name, too!"
      when "nad"
        puts "That's my name backwards!"
      else
        puts "Hi #{name}!"
    end
    
    number = gets.chomp.to_i
    if (number > 10) && (number.odd?)
      puts "That's a pretty high odd number!"
    elsif !number.even?
      puts "That's odd"
    end

### Collections ###

#### Array ####
Represents a list of elements. A single array may have numbers, string, and ever other arrays at the same time.

    grocery_list = Array.new # Creates an empty array # => []
    grocery_list = [] # Creates an empty array.
    grocery_list = ["milk", "eggs", "bread"]
    
    grocery_list = %w(milk eggs bread) # Creates an array of only strings. Same as above. (using lowercase "w")
    
    item = "milk"
    grocery_list = %W(#{item} eggs bread) # Creates an array of only strings. Same as above. (using uppercase "W")

    grocery_list << "carrots" # Adds to the end of array.
    grocery_list.push("potatoes") # Adds to the end of array.
    grocery_list += ["cookies", "chips"] # Adds to the end of array.
    grocery_list.unshift("celery") # Adds to the beginning of array.
    
    grocery_list.insert(2, "oatmeal")
    last_item = grocery_list.pop # Removes and returns last item in array
    first_item = grocery_list.shift # Removes and return first item in array
    drop_two_items = grocery_list.drop(2) # Returns the last two items in array. Array is not modified.
    first_three_items = grocery_list.slice(0, 3) # Returns items specified. Array is not modified. Add an exclamation point to modify in-place
    
    puts grocery_list.inspect
    
    grocery_list[0] # Returns first item
    grocery_list.at(0) # Returns first item
    grocery_list.first # Returns first item
    grocery_list.last # Returns last item
    grocery_list[-1] # Returns last item
    
    grocery_list.length # Returns number of items in array
    grocery_list.count # Returns number of items in array
    grocery_list.count("eggs") # Returns how many times specified element is in array
    grocery_list.include?("eggs") # Returns true is element exists in array, otherwise false
    grocery_list.index["eggs"]
    
    a1 = [1,2,3,4]
    a2 = [3,4,5,6]
    a1 & a2 # => [3,4] # Set intersection: Returns a new array containing elements common to both arrays

##### Sort #####

    a1 = [10, 2, 3, 4, 1]
    a1.sort # => [1, 2, 3, 4, 10]
    a1.sort{|a, b| a <=> b} # Same as above
    a1.sort{|a, b| b <=> a} # Sorts in reverse
    a1.sort.reverse # Same as above

#### [Hash](http://www.ruby-doc.org/core-2.1.2/Hash.html) ####
Refer to items in arrays by index. Refer to items in hash by identifier (string or number or symbol).

    item = Hash.new # Creates an empty hash
    item = {} # Same as above

    item = {"name" => "Bread"} # key => value
    item["name"] # Returns "Bread"
    
    item = {"name" => "Bread", "quantity" => 1} # This has two keys
    
    item[1] = "Grocery Store" # Example of using number as hash key
    item["brand"] = "Treehouse Bread Company" # Example of using string as hash key
    item[:name] = "Bread" # Example of using symbol as hash key. 
    item = {name:"Bread", quantity:1} # Example of using symbol as hash key. 

    item.delete(1) # Removes and returns item with key of 1
    
    item.count # Returns number of keys
    item.empty? # Returns true if no elements
    item.clear # Removes all keys and values

    # Set default item for hash
    h = Hash.new { |hash, key| hash[key] = "Default value for #{key}" }
    h['hello'] # By not assigning it anything the default value is used from above
    
Adding keys as string will allow duplicates. Adding keys as a symbol will only allow one.

    hash = {}
    hash.keys # Returns an array of all the keys in hash
    hash.key['my_value'] # Pass in value to return key
    hash.has_key?("name")
    hash.key?("name") # Alias for `has_key?`
    hash.member?("name") # Alias for `has_key?`
    
    hash.values # Returns an array of all values in hash
    hash.has_value?(1)
    hash.values_at("name", "quantity") # Returns an array of values for specified keys
    
    hash.fetch("quantity")
    hash.store("calorie", 100)
    
    puts "Hash: #{hash.inspect}" # Prints out to screen the contents of hash
    
    hash.length # Returns the number of key-value pairs
    hash_invert = hash.invert # Transposes keys and values, doesn't change original hash
    first_item = hash.shift # Removes and returns a key-value pair as a two-item array `[key, value]`
    hash2 = {}
    merged_hashes = hash.merge(hash2)

### Loops ###

By convention most devs use `do-end` if more than one line of code, and use braces if just one line of code to loop.

    loop do
      print "Do you want to continue? (y/n)
      answer = gets.chomp.downcase
      if answer == "n"
        break
      end
    end
    
    loop {
      print "Do you want to continue? (y/n)
      answer = gets.chomp.downcase
      break if answer == "n"
    }

    answer == ""
    while answer != "n"
      print "Do you want to continue? (y/n)
      answer = gets.chomp.downcase
    end

    def print_hello(number_of_times)
      i = 0
      while i < number_of_times
        puts "hello"
        i += 1
      end
    end

    # Basically, opposite of the way `while` breaks
    answer == ""
    until answer == "n" do # Having `do` is optional for this and `while`
      print "Do you want to continue? (y/n)
      answer = gets.chomp.downcase
    end
    
    array = [1, 2, 3, 4, 5]
    for i in array do
      puts "i is #{i}"
    end
    # Note: `i` is still available outside this loop
    
    # Same as above
    for i in 1..5 do
      puts "i is #{i}"
    end

To exit a loop early, use `break`.

    loop do
      break if answer == "y"
      
      # Same as above
      if answer == "y"
        break
      end
      ...
    end

To skip a loop, use `next`

    loop do
      next if answer != "y"
      ...
    end

To repeat current loop, us `retry`.

To repeat entire loop from beginning, use `redo`.


#### Iterators ####
From the "Enumerable" module.

    # The long way
    array = [0, 1, 2, 3, 4, 5]
    i = 0
    while i < array.length
      item = array[i]
      puts "The current array item is: #{item}"
      i += 1
    end
    
    # Simplified
    array = [0, 1, 2, 3, 4, 5]
    array.each do |item|
      puts "The current array item is: #{item}"
    end
    
    # Same, but on one line
    array.each { |item| puts "The current item is #{item}." }
    
    # Iterate over each key-value pair in a hash
    business = {"name"=>"Treehouse", "location"=>"Portland, OR"}
    business.each do |key, value| # Same as `.each_pair`
      puts "Key: #{key}, value: #{value}"
    end
    
    # Sidenote: `each` is also `each_pair`.
    # There is also a `each_key` and `each_value`
    business.each_key { |key| puts "Key: #{key}" }
    business.each_value { |value| puts "Value: #{value}" }
    
    # Iterates over Integers
    5.times do
      puts "Hello!"
    end
    
    # Outs indexes, starting at zero
    5.times do |item|
      puts "Hello! #{item}" 
    end

Most Ruby devs don't use for-loops because the variable exists outside the loop.

    # Example Ruby for-loop using range
    for item in 1..10 do
      puts "Current item: #{item}"
    end
    
    # Example Ruby for-loop using array
    for item in ["programming", "is", "fun"]
      puts "Current item: #{item}"
    end


## Function ##

- Must start with a lowercase letter.
- May contain underscore.
- May end with an optional question mark or an exclamation point.
- May not contain a `^`.
- The last line in a function is an implicit return.
  - If nothing is inside the method body, then `nil` is returned.

### Examples ###

    def sayHello()
      puts "Hello"
    end
    sayHello # Calls the function

    # Provides a default value for argument
    def print_separator(character="-")
      puts character * 80
    end
    print_separator # Or, `print_separator()` to call the function
    
    def doubleName(name)
      return name * 2
    end
    
    def add(a, b)
      return a + b
    end
    puts add(1, 2)


## Method ##
Two types of methods.

### Instance Method ###
Basically, functions inside of classes that get called on objects/instances.

    class BankAccount
      def deposit(amount)
        ...
      end
      ...
    end

### Class Method ###
Basically, functions that are called on classes. Seems just like `static` methods in Java.

Prefix the function with `self`.

    class BankAccount
      def self.create_for(name)
        @account ||= [] # Conditional assignment
        @account << BankAccount.new(name)
      end
      
      def self.find_for(name)
        @accounts.find{|account| account.name == "#{name}"}
      end
      ...
    end

Instead of prefixing all the class methods with `self`, you can do the following:

    class BankAccount
      class << self
        def create_for(name)
          @account ||= [] # Conditional assignment
          @account << BankAccount.new(name)
        end
        
        def find_for(name)
          @accounts.find{|account| account.name == "#{name}"}
        end
      end
      ...
    end


## Class ##
Naming convention is capital camelcase, ex: "MyClassName".

### Example ###

    class BankAccount
      # Special method `initialize` that gets called when `BankAccount.new` is called
      def initialize(name)
        @transactions = []
        @balance = 0
      end
      
      def deposit
        print "Amount to deposit: "
        amount = gets.chomp
        @balance += amount.to_f
        puts "$#{amount} deposited."
      end
      
      def show_balance
         puts "Balance: #{@balance}"
      end
    end
    
    bank_account = BankAccount.new("Danial Goodwin");
    bank_account.class # => BankAccount
    bank_account.deposit
    bank_account.show_balance

### Attr Examples ###

These two classes are the same.
    
    class Person
      attr_reader :age
      attr_accessor :job
      ...
    end

    class Person
      def age
        @age
      end
      
      def job=(name)
        @job = job
      end
      
      def job
        @job
      end
      ...
    end

### Visibility ###

Public methods can be called from anywhere, this is the default for methods.

Protected methods can be called within the class and by other objects of the same class.

Private methods can be called only from within the class or instance.

Here's an example of using controlling method as `private`. This keyword can be switched with `protected`.

    class BankAccount
      ...
      def reset!
        @balance = 0
      end
      private :reset! # This way accepts one method
    end
    
    class BankAccount
      ...
      private # Anything below this will be private
      def reset!
        @balance = 0
      end
    end


## Procs and Lambdas ##
Procs and lambdas, sometimes called "closures", are blocks of code that are assigned to variables. This way, they can be passed around to different methods with different scopes.

Lambdas are a type of Proc in Ruby. Unlike Procs, Lambdas require the exact number of arguments as specified when created. The other difference is how `return` is handled.

    my_proc = Proc.new {} # Must pass in a block
    my_proc = proc {} # Same as above
    
    proc.call # Execute the block code
    
    my_lambda = lambda {} # Must pass in a block
    my_lambda = -> {} # Same as above # Using the "skinny arrow"

Procs can take arguments by placing the argument names inside of pipes

    my_proc = proc { |name| puts "Hello, #{name}" }
    my_proc.call # => Hello, # Ruby will use `nil` if no argument is provided
    my_proc.call "Dan" # => Hello, Dan
    my_proc.call("Dan") # Same as above, parentheses are optional when calling methods

    my_lambda = lambda { |name| puts "Hello, #{name}" }
    my_lambda.call # Error, because not correct amount of arguments
    my_proc.call "Dan" # => Hello, Dan

### Returning ###

Sample program demonstrating differences.

    def return_from_proc
      variable = proc { return "returning from proc inside method" }
      variable.call
      return "returning from proc as last line from method"
    end
    
    def return_from_lambda
      variable = lambda { return "returning from lambda inside method" }
      variable.call
      return "returning from lambda as last line from method"
    end
    
    puts return_from_proc
    puts return_from_lambda

Output:

    returning from proc inside method
    returning from lambda as last line from method


## Module ##

Basically, a container that can be used for namespacing and augmenting existing classes with more behavior.

Naming is just like classes -- capital camel case, ex: "MyModuleName".

    module Treehouse
      MASCOT = "Mike The Frog"
    end
    Treehouse::MASCOT # => "Mike The Frog"

    module Treehouse
      class Frog
        attr_accessor :name
      end
    end
    mike = Treehouse::Frog.new
    mike.name = "Mike The Frog"

### Extend ###
Extend makes methods defined in a module available to a class extended by module. `extend` can be used on an instance or a class.

    class Hello
      def initialize(name)
        @name = name
      end
    end
    
    module SayHello
      def say_hello
        puts "Hello #{@name}"
      end
    end
    
    hello = Hello.new("Dan")
    hello.extend SayHello
    
    hello.say_hello # => Hello Dan

Another example:

    module SayHello
      def say_something
        puts "something"
      end
    end
    
    class Hello
      extend SayHello
      
      def initialize(name)
        @name = name
      end
    end
    
    Hello.say_something

### Include ###
Instead of `extend`, you can use `include` in a class. `inlclude` makes the module methods available to the instances of the class.

    module SayHello
      def say_hello
        puts "Hello #{@name}"
      end
    end
    
    class Hello
      include SayHello
      
      def initialize(name)
        @name = name
      end
    end
    
    hello = Hello.new("Dan")
    hello.say_hello # => Hello Dan

### Example ###
Both `include` and `extend` can be used at the same time.


## Miscellaneous ##

#### Conditional Assignment ####

    name = "Dan"
    if defined?(name)
      name
    else
      name = "Zebra"
    end

    # Assign the value only if name is not already set.
    name ||= "Dan"
    
    # Usage
    new_name = "Dan"
    new_name ||= "Zebra" # Doesn't get assigned
    puts new_name # => Dan
    
    # Basically, a shortcut for.. (though, Ruby might be doing something else under the hood)
    other_name = (other_name || "Dan") # The first "true" value is returned.

#### Conditional Return Type ####

    # Returns string or integer depending on argument passed in
    def ask(question, kind="string")
      print question + " "
      answer = gets.chomp
      answer = answer.to_i if kind == "number"
      return answer
    end

[Create a random number](http://ruby-doc.org/core-2.0/Random.html)

    prng = Random.new
    prng.rand(100) # Returns a random Integer. Specify max number, must be greater than zero
    prng.rand(1.5) # Returns a random Float between 0.0 and max.
    prng.rand(5..9) # inclusive
    prng.rand(5...9) # exclusive
    prng.rand(5.0..9.0) # inclusive
    prng.rand(5.0...9.0) # exclusive


## Ruby Core ##

### Symbols ###
Each symbol only exists once in memory.

These look like variables prefixed with a colon, ex: `:my_symbol`. Though, in Ruby 1.9 and  up, symbols aren't strictly required.

    my_object = {:food => "pizza", :topping => "cheese"}
    my_object = {food: 'pizza', topping: 'cheese'} # Same as above

### Date and Time ###

    require 'date'
    require 'time'
    
    date = Date.new
    date.to_s
    
    date = Date.new(2015, 4, 1)
    date.to_s # => 2015-04-01
    
    date.strftime("%Y/%m/%d") # => 2015/04/01
    date.strftime("%b %d, %Y") # => April 01, 2015
    
    date.mday # Returns numerical day of month # Same as `.day`
    date.month # Returns numerical month
    date.wday # Returns numerical day of week, starting from 0 for Sunday
    date.friday? # Returns true if day is on Friday
    date.yday # Returns numerical day of year

### Enumerable ###
Include this module to have ability to sort, traverse, and search classes. Classes that `include Enumerable` require a class method `each` to be defined.

In order for a class to use the Enumerable#max, min, or sort, then the spaceship `<=>` operator must be defined.

    class BankAccount
        attr_reader :transactions
        include Enumerable
        
        def <=> (other_account)
          self.balance <=> other_account.balance
        end
        
        def initialize(name)
          @name = name
          @balance = 0
          @transactions = []
        end
        
        def balance 
          # `inject` is from the Enumerable library
          @transactions.inject(0) {|sum, iterator| sum += iterator }
        end
        
        def each
          @transactions.each{|transaction| yield transaction}
        end
        
        def to_s
          "<#{self.class}:name: #{@name}, balance: #{balance}>"
        end
        
        ...
    end
    
    account1 = BankAccount.new("Name1")
    account2 = BankAccount.new("Name2")
    
    accounts = []
    accounts.push(account1)
    accounts.push(account2)
    
    # Use the Enumerable library included in the class
    # `to_s` is overriden so that useful output will be shown
    puts accounts.sort

### Comparable ###
Using the Comparable module in a class allows the class to have many comparison operators available for the instances, and `.between?(min, max)`.

Classes that `include Comparable` must define the <=> operator.

    class Book
      attr_accessor :rank
      include Comparable
      
      def <=> (other_book)
        self.rank <=> other_book.rank
      end
      
      ...
    end
    
    book1 = Book.new(25)
    book2 = Book.new(26)
    book3 = Book.new(27)
    
    book2.between?(book1, book3) # Returns true if is between, as defined by <=>
    
### IO ###
"Class IO is the basis for all input and output in Ruby."

#### File ####

    # "w+" is read-write, and overwrites previous data. 
    File.open(".my_file.txt", "w+") do |file|
      file.puts "Hello, file" # Writes to file
    end
    
    # "a+" is read-write, and appending to previous data. 
    File.open(".my_file.txt", "a+") do |file|
      file.puts "Hello, file" # Writes to file
    end
    
    # `.readlines` puts the file in arrays, one element per line
    puts IO.readlines('my_file.txt')

### Struct ###
Structs are a quick way to bundle attributes together without having to write your own custom class.

    Struct.new("Treehouse", :name, :location)
    treehouse = Struct::Treehouse.new
    treehouse.name = "Treehouse"
    treehouse.location = "Treehouse Island"

    # Create a class that doesn't need the Struct namespace
    Island = Struct.new(:name, :location)
    treehouse = Island.new("Treehouse", "Treehouse Island")
    
    # Add a method
    Island = Struct.new(:name, :location) do
      def travel
        puts "Going to #{location}"
      end
      def to_s
        "Name: #{name}, location: #{location}"
      end
    end
    treehouse = Island.new("Treehouse", "Treehouse Island")
    treehouse.travel
    treehouse.to_s
    