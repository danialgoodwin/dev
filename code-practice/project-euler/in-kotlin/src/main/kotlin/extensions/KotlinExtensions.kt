package extensions

import java.time.LocalDateTime

fun log(message: String) {
    println(LocalDateTime.now().toString() + " " + message)
}
