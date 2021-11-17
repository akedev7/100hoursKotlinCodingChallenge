package basic.listandset

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
    println(mutablePatronList)


}