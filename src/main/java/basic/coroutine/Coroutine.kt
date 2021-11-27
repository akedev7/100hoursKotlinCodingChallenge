package basic.coroutine

import kotlinx.coroutines.*

fun main() { // this: CoroutineScope
    println(Thread.currentThread().name)

    GlobalScope.launch { // launch a new coroutine and continue
        val testdata: String = "test"
        println("Inside" + testdata + Thread.currentThread().name)
        delay(3000L) // non-blocking delay for 1 second (default time unit is ms)
        println("Inside" + testdata + Thread.currentThread().name)
        delay(3000L)
        println("Inside" + testdata + Thread.currentThread().name)
        println("World!") // print after delay
    }

    GlobalScope.launch { // launch a new coroutine and continue
        val testdata: String = "test"
        println("Inside" + testdata + Thread.currentThread().name)
        delay(3000L) // non-blocking delay for 1 second (default time unit is ms)
        println("Inside" + testdata + Thread.currentThread().name)
        delay(3000L)
        println("Inside" + testdata + Thread.currentThread().name)
        println("World!") // print after delay
    }
}