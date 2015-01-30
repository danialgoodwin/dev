require "./todo_item"

class TodoList
  attr_reader :name, :todo_items
  def initialize(name)
    @name = name
    @todo_items = []
  end
  
  def find_index(name)
    index = 0
    found = false
    todo_items.each do |todo_item|
      if todo_item.name == name
        found = true
        break
      end
      index += 1
    end
    
    if found
      return index
    else
      return nil
    end
  end
  
  def add_item(name)
    todo_items.push(TodoItem.new(name))
  end
  
  # Returns true if item was deleted, otherwise false.
  def remove_item(name)
    if index = find_index(name)
      todo_items.delete_at(index)
      return true
    else
      return false
    end
  end
  
  def mark_complete(name)
    if index = find_index(name)
      todo_items[index].mark_complete!
      return true
    else
      return false
    end
  end
  
  def print_list(kind='all')
    puts "#{name} List - #{kind} items"
    puts "-" * 30
    todo_items.each do |todo_item|
      case kind
      when 'all'
        puts todo_item
      when 'complete'
        puts todo_item if todo_item.complete?
      when 'incomplete'
        puts todo_item unless todo_item.complete?
      end
    end
    puts "\n"
  end
  
end

todo_list = TodoList.new("Groceries")
todo_list.add_item("milk")
todo_list.add_item("eggs")
todo_list.add_item("bread")
todo_list.remove_item("eggs")
todo_list.mark_complete("milk")
todo_list.print_list

# puts todo_list.inspect
# puts todo_item.inspect
# puts todo_item