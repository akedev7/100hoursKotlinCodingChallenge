package basic.listandset

import java.io.File

val patronList: List<String> = listOf("Eli", "Mordoc ", "Sophie")
val mutablePatronList = mutableListOf("Eli", "Mordoc ", "Sophie")
fun main() {
    println(patronList.first())
    println(patronList.last())
    println(patronList.getOrElse(4) { "Unknown Patron" }) // accept Lambda
    println(patronList.getOrNull(4) ?: "Unknown Patron") // return null if out of array

    if (patronList.contains("Eli")) {
        println("The tavern  master says: Eli's in the back playing cards")
    } else {
        println("The tavern master says: Cli isn't here.")
    }

    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("The tavern master says: Yes, they're seated by the stew kettle krub.")
    } else {
        println("The tavern master says: Nay, they departed hours ago krub.")
    }

    println("---------")
    println(mutablePatronList)
    mutablePatronList.add("Alex")
    mutablePatronList.add(0, "Alex")
    mutablePatronList.addAll(listOf("Reginald", "Tommy"))
    mutablePatronList.removeIf() {
        it.contains("o")
    }
    mutablePatronList.clear()
    println(mutablePatronList)

    for (patron in patronList) {
        println("Good morning $patron")
    }

    patronList.forEach {
        println("Good evening $it")
    }

    patronList.forEachIndexed { index, patron ->
        println("Good night $index $patron")
    }

    val menuList = File("data/tavern-menu-data.txt").readText().split("\n")
    println("Random menu is ${menuList.shuffled().first().split(",").first()}")

}