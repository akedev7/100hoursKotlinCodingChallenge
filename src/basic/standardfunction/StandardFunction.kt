package basic.standardfunction

import java.io.File

fun main() {
    val menuFile = File("menu-file.text").apply {  // instead of set the same property multiple times, we can use apply
        setReadable(true)
        setWritable(true)
        setExecutable(false)
    }

    val firstItemSqured = listOf(1, 2, 3).first().let {
        it * it
    }

    println(formatGreeting(null))
    println(formatGreeting("VIP Guys"))

    val menuFile2 = File("menu-file.text")
    val serveDragonBreath = menuFile2.run {
        readText().contains("Dragon's Breath")
    }

    TODO() // will be continue on this chapter once finish all the chapter because this is like extra feature of Kotlin, we should focus on main feature.


}

fun formatGreeting(vipGuest: String?): String {
    return vipGuest?.let {
        "Welcome, $it. Pelase, go straight back - your table is ready."
    } ?: "Welcome to the travern. You will be seated soon."

}

fun formatGreetingNotUseLet(vipGuest: String?): String {
    return if (vipGuest != null) {
        "Welcome, $vipGuest. Pelase, go straight back - your table is ready."
    } else {
        "Welcome to the travern. You will be seated soon."
    }
}