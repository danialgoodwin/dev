# Ruby Cheat Sheet - Blocks #

- The last line in a block is the implicit return.

## Examples of "blocks" ##

    do
      puts "Hello World!"
    end
    
    { puts "Hello World!" }

### Special Blocks ###

    # my_snippet.rb
    puts "This is the first line of Ruby program"
    BEGIN { puts "INSIDE BEGIN BLOCK" }
    END { puts "INSIDE END BLOCK" }
    
    # Output of running above ruby program
    INSIDE BEGIN BLOCK
    This is the first line of Ruby program
    INSIDE END BLOCK

## Block Method ##

    def block_method
      puts "This is the first line in block_method."
      yeild # Tells block method to finish and run other block that called this.
      puts "This statement is after the yield keyword."
    end
    
    block_method do
      puts "This statement is called from the block."
    end

- `yield` can be called zero or more times in the block method.

### Pass a block into a method ###
Use ampersand before a argument name to tell Ruby that a block is expected

    def say_hello(&block)
      puts "Hello"
      block.call
    end
    say_hello { puts "Hello again" }
    say_hello do # Same as aboave
      puts "Hello again" 
    end

Test is a block was passed in with `block_given?`

    def say_hello(&block)
      puts "Hello"
      if block_given?
        block.call
      else
        puts "No block was provided"
      end
    end

### Pass arguments with `yield` ###

    def get_name
      print "Enter your name: "
      name = gets.chomp
      yield name
    end
    
    get_name do |user_name| # Must specify the argument name here in order to use it.
      print "That's a cool name, #{user_name}!"
    end

### Pass arguments both ways ###

    def get_name(prompt)
      print prompt + ": "
      name = gets.chomp
      yield name
    end
    
    get_name("Enter you name") do |user_name|
      print "That's a cool name, #{user_name}!"
    end

### Return value from block method ###

    def get_name
      print "Enter your name: "
      name = gets.chomp
      yield name
      name # Implicit return
    end
    
    my_name = get_name do |user_name| # Must specify the argument name here in order to use it.
      print "That's a cool name, #{user_name}!"
    end
    
    puts "my_name: #{my_name}"

Another way:

    def get_name(&block)
      print "Enter your name: "
      name = gets.chomp)
      print "Age: "
      age = gets.chomp
      block.call(name, age) # Use `<block_name>.call()` instead of `yield
      # yield name, age # Same as above
      # yield name, age if block_given? # Only yield if a valid block is passed in
      name # Implicit return
    end
    
    my_name = get_name do |user_name, age|
      print "That's a cool name, #{user_name}! Age: #{age}."
    end

## Ruby core methods that takes blocks as argument ##

In the documentation for string, array, hash, and others, search for "block".

### String ###

    string = "Treehouse"
    string.each_char{|c| print "#{c}-"} # => T-r-e-e-h-o-u-s-e

    haiku = <<-EOF
    A string with three lines
    Is considered multi line
    Ruby code haiku
    EOF

    haiku.each_line{ |line| puts "* #{line}" }

    5.downto(3) { |number| print number } # => 543

### [Array](http://www.ruby-doc.org/core-2.2.0/Array.html) ###

    array = [1, 2, 3]
    array.each { |item| print "-#{item}-" } # => -1--2--3-
    
    array.all? { |item| item > 3 } # Returns true if all items are greater than three
    array.any? { |item| item > 3 } # Returns true if any items are greater than three
    
    # Returns a new array containing all elements of array for which the given block returns a true value
    array.select { |item| item > 2 } # => [3]
    
    array.reject { |item| item % 3 == 0 } # => [1,2]
    array.count { |item| item % 3 == 0 } # => 1
    
    array.map { |item| item * 2 } # Runs block on every item in array, returns new array # Same as `.collect` # Use bang method to modify array in-place

### [Hash](http://www.ruby-doc.org/core-2.2.0/Hash.html) ###

    hash = { 'name' => 'Jason', 'location' => 'Treehouse' }
    
    # hash.each_pair # Same as hash.each
    hash.each do |key, value|
      puts "key: #{key} value: #{value}"
    end
    
    hash.each_key{ |key| puts "key: #{key}" }
    hash.each_value { |val| puts "val: #{val}" }
    
    hash.all? { |item| item > 3 } # Returns true if all items are greater than three
    hash.any? { |item| item > 3 } # Returns true if any items are greater than three
    
    hash.select { |key, val| key == "name" } # Returns a new hash: `{ 'name' => 'Jason' }` # Use band method to modify hash in-place
    
    hash.keep_if{ |key, val| key == "name" } # Modifies hash to `{ 'name' => 'Jason' }`
    hash.reject { |key, val| key == "name" } # Returns a new hash: `{}`
    
    hash.delete_if { |key, val| key == "name" } # Modifies hash
    
    hash.find {|k,v| ... }
    hash.find_all {|k,v| ... }
    
    hash.map {|k,v| v *= 2 } # Runs block on every item, returns new hash # Same as `.collect` # Use bang method to modify hash in-app

## Exmaple: How the Ruby core method blocks could be implemented  ##

    class MyArray
      attr_reader :array
      def initialize
        @array = []
      end

      def push(item)
        array.push(item)
      end

      def each(&block)
        i = 0
        while i < array.length
          block.call(array[i])
          i += 1
        end
        array
      end
    end
    
    my_array = MyArray.new
    my_array.push(1)
    my_array.push(2)
    my_array.push(3)
    
    my_array.each{ |item| puts "item: #{item}" }


## Dealing with Exceptions ##

Make sure a piece of code runs by using `ensure`.

    def header(&block)
      puts "Header"
      block.call
    rescue
      puts "Rescue: Footer" # Allows graceful recovery exception
    ensure
      puts "Ensure: Footer
    end
    
    header do
      puts "Body" 
      raise "This is an arbitrary error" # Throws an exception
    end


## Practical Example ##

### Benchmarker ###

    class SimpleBenchmarker
      def run(description, &block)
        start_time = Time.now
        yield
        end_time = Time.now
        elapsed = end_time - start_time
        puts "\n#{description} results"
        puts "Elapsed time: #{elapsed} seconds"
      end
    end

    benchmarker = SimpleBenchmarker.new
    benchmarker.run "Sleep a random amount of time" do
      # my_method_to_test
      5.times do
        print "."
        sleep(rand(0.1..1.0))
      end
    end
