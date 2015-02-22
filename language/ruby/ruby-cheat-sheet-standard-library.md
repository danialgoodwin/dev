# Ruby Cheat Sheet - Ruby Standard Library #


## YAML (Yet Another Markup Language) ##
YAML is a plain text in human readable format that is frequently used for configuration files.

    require 'yaml'
    
    array = %w(dog cat frog)
    array.to_yaml # => "---\n- dog\n- cat\n- frog\n"
    puts array.to_yaml

Output:

    ---
    - dog
    - cat
    - frog

For hashes

    hash = {name: 'Dan', location: 'USA'}
    puts hash.to_yaml

Output:

    ---
    :name: Dan
    :location: USA

YAML can have as many levels of containers as needed. An array in a hash may look something like this:

    ---
    :name: Dan
    :location: USA
    :location:
    - USA
    - Japan
    - New Jersey

The output of `.to_yaml` can be sent to a file to save it:

    File.open('.config.yml', 'w') do |config|
      config.puts hash.to_yaml
    end

Then, contents can be retrieved:

    config = YAML.load(File.read('./config.yml'))


## ERB (Embedded Ruby) ##
ERB is a templating system build in Ruby. Basically, you can include Ruby code within strings. Kinda works like PHP in some HTML code.

    require 'erb'
    
    treehouse = {
      name: 'Treehouse',
      location: 'Treehouse Island'
    }
    
    template = <<-TEMPLATE # Arbitrary name, this is just "heredoc" syntax
      From the desk of <%= treehouse[:name] %>
      -------------------------------------------
      Welcome to <%= treehouse[:location] %>
      
      We hope you enjoy your stay.
      -------------------------------------------
    TEMPLATE
    
    erb = ERB.new(tempalte)
    puts erb.result

Though, if you don't want to print out the executed Ruby code, then don't include the equals sign.

    my_template = "
      Words, words, words.
      <% treehouse.keys.each do |key| %>
        Key: <%= key %>
      <% end %>
    "


## FileUtils ##
FileUtils library provides methods for interacting with files in the system.

    require 'fileutils'
    
    here = File.dirname(__FILE__) # => "."
    File.expand_path(here) # Returns full path
    
    Dir.entries(here) # Returns list of files in directory

    FileUtils.mkdir_p(here + '/new_dir') # Creates a new directory
    
    FileUtils.cmp(here + '/file1.txt1', here + '/file2.txt') # Returns true if both files are equal
    
    FileUtils.cp 'file1', 'file2' # Copies file


## Logger ##
Logger library provides way to have logging and debugging easily.

There are different levels of logging available: FATAL, ERROR, WARN, INFO, DEBUG

    require 'logger'
    
    class BankAccount
      attr_reader :file_logger, :stdout_logger
      
      def initialize(name)
        @name = name
        @transactions = []
        @stdout_logger = Logger.new(STDOUT)
        @file_logger = Logger.new("./bank_account.log")
      end
      
      def deposit(amount)
        log "Depositing #{amount}"
        @transactions.push(amount)
      end
      
      def withdraw(amount)
        log "Withdrawing #{amount}"
        @transactions.push(-amount)
      end
      
      def log(message, level=Logger::INFO)
        file_logger.add level, message, "#{self.class} (#{name})"
        stdout_logger.add level, message, "#{self.class} (#{name})"
      end
    end
    
    account = BankAccount.new("Dan")


## URI/URL ##
The URL (Uniform Resource Identifier) module can be used to parse and manipulate URIs.

    require 'uri'
    require 'open-uri'
    
    url = URI.parse('http://danialgoodwin.com/')
    url.hostname # => danialgoodwin.com
    url.path # => /
    
    google = open('http://google.com').read # Returns the URI's source code


## Benchmark ##
"The Benchmark module provides methods to measure and report the time used to execute Ruby code."

    require 'benchmark'
    
    repetitions = 1000000
    
    # Compare strings vs symbol as hash key
    Benchmark.bm(7) do |x|
      x.report 'String' do
        repetitions.times do
          options = {'hello'=>'world'}
        end
      end
      x.report 'Symbol' do
        repetitions.times do
          options = {hello:'world'}
        end
      end
    end


## OptParse ##
Use the OptParse library to help parse command line arguments/options/flags when running Ruby code. This also automatically creates the help test and the `-h` option.

    # In my_ruby_script.rb
    require 'ostruct'
    require 'optparse'
    require 'open-uri'
    
    class MyParse
      def self.parse(args)
        options = OpenStruct.new
        opts = OptionParse.new do |opts|
          opts.banner = "Usage: url"
          
          opts.on('-u', '--url URL', 'Fetches the given URL') do |url|
            options.url = url
          end
        end
        
        begin
          opts.parse!(args)
        rescus Exception => e
          puts "Exception encountered: #{e}
          puts opts
          exit 1
        end
        
        options
      end
    end
    
    options = MyParse.parse(ARGV)
    
    if options.url
      puts open(options.url).read
    end
    

Usage from command line:

    ruby my_ruby_script.rb -h
    ruby my_ruby_script.rb -u http://google.com/


## Observable ##
The Observable module allows easy implementation of the observer pattern in classes.

    require 'observer'
    
    class BankAccount
      include Observable
      
      def initialize(name)
        @name = name
        @transaction = []
      end
      
      def deposit(amount)
        changed
        notify_observers(Time.now, 'deposit', amount)
        @transaction.push(amount)
      end
      
      def withdraw(amount)
        changed
        notify_observers(Time.now, 'withdrawal', amount)
        @transaction.push(-amount)
      end
    end
    
    class AccountObserver
      def initialize(account)
        @account = account
        @account.add_observer(self)
      end
      
      def update(time, kind, amount)
        puts "[#{time} #{kind}]: #{amount}
      end
    end
    
    account = BankAccount.new("Dan")
    AccountObserver.new(account)
    
    account.deposit(100)
    account.withdraw(50)
