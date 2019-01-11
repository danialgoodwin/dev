





## Functions

    fun main() {
        val c1 = MyCustom("C1")
        val c2 = MyCustom("C2")
        val c3 = c1 plus c2
        val c4 = c1 + c2
    }
    
    class MyCustom(var Name: String) {}
    
    // Add ability to use `c1 plus c2`. The function must have only 1 parameter
    infix fun MyCustom.plus(other: MyCustom) : MyCustom {
        return MyCustom(this.Name + other.Name)
    }
    
    // Add ability to use `c1 + c2`. Only certain operators are allowed for overloading
    operator infix fun MyCustom.plus(other: MyCustom) : MyCustom {
        return MyCustom(this.Name + other.Name)
    }


## Types
- Classes and methods are `public` and `final` by default
  - Use `open` to show the type can be derived/overridden
  - There is no 'package-private'
  - Use `internal` to have visibility for the containing module only
- Sealed classes allow restricting class hierarchies
  - Great for `when` expressions so that an `else` clause doesn't have to be used. This is because the compiler knows all of the subtypes
- Use `object class` to create a singleton
- Use `companion object` to create 'static' methods

    data class Event(val name: String, val location: String)
    
    val event = Event("asdf", "Denver")
    val event2 = event.copy(location = "Jacksonville")



## Coroutines
Simple threading and concurrency.

    val myDeferred = async {
        // Do stuff
    }
    val myValue = myDeferred.await()

    // Fire and forget
    launch {
        // Maybe do network request here
        withContext(dispatchers.main) {
            // Maybe update UI
        }
    }
    
    // Cancellable
    val job = launch {
        // Do something
        yield() // Co-operate with cancel, aka bcome interruptable, or check `isActive`
    }
    job?.cancel()

- `Dispatchers.Default` uses cpuCount threads (core)
- `IO` uses 64

        async {
            val local = withContext(IO) {
                fileStore.loadImage(...)
            }
            // No thread context switch
            return processIimage(local)
        }

