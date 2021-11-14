package basic.string


const val TAVERN_NAME = "Taernyl's Folly"

fun main() {
    placeOrder("shandy,Dragon's Breath,5.91")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf("'") // Find index of '
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe) // Substring the name
    println("Madrigal speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',') //Split string
    val message = "Madrigal buys a $name ($type) for $price"
    println(message)

    val phrase = if (name.lowercase() == "dragon's breath") {
        "Madrigal exclaims: ${toDragonSpeck("Ah, delicious $name!")}"
    } else {
        "Marigal says: Thanks for the $name"
    }
    println(phrase)

    "Dragon's Breath".forEach{ println("$it")}

}

// Replace function accept Regex and Lambda as parameters (Lambda can be placed outside of ")" )
fun toDragonSpeck(phrase: String): String = phrase.replace(Regex("[aeiou]")) {
    when (it.value) {
        "a" -> "4"
        "e" -> "3"
        "i" -> "1"
        "o" -> "0"
        "u" -> "|_|"
        else -> it.value
    }
}


