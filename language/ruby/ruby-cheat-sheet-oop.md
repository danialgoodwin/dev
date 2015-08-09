# Ruby Cheat Sheet - Objects and Classes #

Convensions:

- Class names start with capital, and if using multiple words, use camel-case. Ex: `MyClassName`
- File names for those classes are all lowercase and has separation of words with an underscore

### Usage ###

    my_string = String.new
    my_string.class # Returns String
    
    String.new("Dan")
    Array.new => []
    Hash.new => {}
    
    my_string.methods # Returns the methods this object supports.
    my_string.respond_to?("upcase") # Returns true if method is available, other false.

### Basic Example ###

    class MyClass
      def initialize
        puts "This is the initialize method.. automatically called for MyClass.new"
      end
    end

### Fields ###

    # Unchangeable fields
    class Name
      def title
        "Mr."
      end
      def first_name
        "Dan"
      end
      def last_name
        "Goodwin"
      end
    end
    
    name = Name.new
    puts name # Prints object reference
    puts name.title
    puts name.first_name
    puts name.last_name
    
    # Allow fields to be set once upon initialization
    class Name
      def initialize(title,first_name,last_name)
        # Put an "at" sign to make an instance variable (and refer to it).
        @title = title
        @first_name = first_name
        @last_name = last_name
      end
      def title
        @title
      end
      def first_name
        @first_name
      end
      def last_name
        @last_name
      end
    end
    
    name = Name.new("Mr.")
    puts name # Prints object reference
    puts name.title + " " +
         name.first_name + " " +
         name.last_name

    class Name
      # This automatically creates/allows the getters.
      attr_reader :title, :first_name, :last_name
      
      def initialize(title,first_name,last_name)
        @title = title
        @first_name = first_name
        @last_name = last_name
      end
    end
    
    class Name
      attr_reader :title, :first_name, :last_name
      # This automatically creates/allows the setter.
      attr_writer :title
      
      # This takes the place of attr_reader and attr_writer
      attr_accessor :title
      
      def initialize(title,first_name,last_name)
        @title = title
        @first_name = first_name
        @last_name = last_name
      end
      
      # This isn't needed when you use `att_writer :title`.
      def title=(new_title)
        @title = new_title
      end
    end

### Methods ###

    class Name
      attr_reader :title, :first_name, :last_name
      attr_accessor :title
      def initialize(title,first_name,last_name)
        @title = title
        @first_name = first_name
        @last_name = last_name
      end
    
      def full_name
        @first_name + " " + @last_name
      end
    
      def full_name_with_title
        @title + " " + full_name()
      end
    
    end
    
    name = Name.new("Mr.", "Dan", "Goodwin")
    puts name.full_name_with_title

### The `to_s` method ###

Without the `to_s` method, calling `puts name` will print address in memory, like `#<Name:007f7bd1c44a10>`. With the `to_s` method, `puts name` will print whatever you want.

    class Name
      ...
      def to_s
        full_name_with_title
      end
    end

Use `name.inspect` to get more information about the object. It will return the memory address and internal state (instance variables and values).

