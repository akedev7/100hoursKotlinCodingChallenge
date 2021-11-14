package basic.exception

fun main() {
    var swordJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3

    if (isJugglingProficient) {
        swordJuggling = 2
    }

    try {
        proficiencyCheck(swordJuggling)
        swordJuggling = swordJuggling!!.plus(1)
    } catch (e: Exception) {
        println(e)
    }
    
    juggleSwords(swordJuggling!!)
}

private fun juggleSwords(swordJuggling: Int) {
    require(swordJuggling >=3, {"Juggle at least 3 swords to be exciting."}) // Built-in Precondition
    println("You juggle $swordJuggling swords!")
}

fun proficiencyCheck(swordJuggling: Int?) {
//    swordJuggling?: throw UnskilledSwordJugglerException()
    checkNotNull(swordJuggling, { "Player cannot  juggle swords" }) // Built-in Precondition

}

class UnskilledSwordJugglerException() : IllegalStateException("Player cannot juggle swords.")
