





# Google Play Services
## Location

Using `FusedLocationProviderClient`:

    client.getLastLocation().addOnCompleteListener { task ->
        val location = task.result // `Location` object
    }
    
    suspend fun getLastLocation(): Location {
        return suspendCancellableCoroutine { continuation ->
            locationClient.lastLocation.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    continuation.resume(task.result)
                } else {
                    continuation.resumeWithException(task.exception!!)
                }
             }
        }
    }
