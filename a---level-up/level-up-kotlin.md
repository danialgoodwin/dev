








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
