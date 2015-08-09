# Ruby Cheat Sheet - Testing #


## MiniTest ##
MiniTest is an automated testing library that comes with Ruby.

In order to run the tests, a class must be created that inherits MiniTest.

Test methods must be prefixed with "test_".

    require 'minitest/autorun'
    
    class MyTest < Minitest::Unit::TestCase
      def test_that_addition_workds
        asset_equal 4, 2 + 2
      end
      
      def test_that_my_array_has_a_value
        my_array = %w(dog cat frog)
        assert my_array.include?('frog')
      end
      
      # `assert_delta` checks to see that floating point numbers are within a given range
      def test_asset_delta
        assert_in_delta 3.14159, 3, 0.2
      end
      
      # `assert_match` checks to see if the regular expression evaluates against a string
      def test_assert_match
        assert_match /world/, 'hello world'
      end
      
      def test_nil
        some_variable = nil
        assert_nil some_variable
      end
      
      def test_output
        assert_output "hello world", nil do
          print 'hello world' # Succeeds
          puts 'hello world' # Fails because a newline character is added at the end
        end
      end
      
      def test_raise
        assert_rases NameError do
          this_variable_doesnt_exist
        end
      end
      
      # `assert_respond_to` checks to see if the object responds to a given method
      def test_respond_to
        assert_respond_to Array.new, 'include?'
      end
      
    end

### MiniTest::Spec ###
Minitest::Spec allows tests to be written with a different syntax.

"must" is used instead of "assert"

All the tests used in the regular MiniTest library (as shown above) will work here also. Though, "raise", or exception handling, must be done slightly differently.

    require 'minitest/autorun'
    require 'minitest/spec'
    
    describe 'MyTests' do
      # before and after blocks can be added to run before and after all the tests
      before do
        puts "Tests are beginning."
      end
    
      it "add 2 + 2" do
        (2+2).must_equal 4
      end
      
      it "includes a frog" do
        %w(dog cat frog).must_include('frog')
      end
      
      it "must be a Fixnum" do
        (2+2).must_be_instance_of Fixnum
      end
      
      it "should raise an error" do
        array = []
        lambda {array.hello}.must_raise NoMethodError
      end
      
    end


## Test-Driven Development ##
A process of writing code that involves writing tests for the program before the code for the program is written.

- Generally, you want to write just enough code to get the tests to pass.

### Example ###

Setup the files structure something like this:

    my_project_name
    - /lib/
      - bank_account.rb
    - /spec/
      - bank_account_spec.rb

The `bank_account.rb` file can start off as blank. Then, in TDD, you would only write code in there once a test is created for it.

Here's a starting point for `bank_account_spec.rb`:

    require 'minitest/autorun'
    require 'minitest/spec'
    
    # Append load path one level up
    # `$:` is shortcut for the load path array
    # `.unshift` to add a new element to array
    $:.unshift File.expand_path(File.dirname(__FILE__) + '/..')
    
    require 'lib/bank_account'
    
    describe BankAccount do
      subject ( BankAccount.new }
      
      it "should be a bank account instance" do
        subject.must_be_instance_of BankAccount
      end
      
      it "should have a name" do
        subject.must_respond_to 'name'
      end
      
      it "should initialize with a name" do
        bank_account = BankAccount.new("Dan")
        bank_account.name.must_equal 'Dan'
      end
    end
