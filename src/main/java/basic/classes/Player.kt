package basic.classes

import java.io.File

class Player(
    _name: String,
    _healthPoint: Int,
    _isBlessed: Boolean,
    _isImmortal: Boolean
) {
    var name = _name
        get() = "${field.capitalize()} of $hometown"
        private set(value) {
            field = value.trim()
        }
    var healthPoints = _healthPoint
    val isBlessed = _isBlessed
    private val isImmortal = _isImmortal
    private val hometown: String = selectHomeTown()
    lateinit var alignment: String // Kotlin will not allow unassigned variable when initialize the object except using lateinit

    var currentPosition = Coordinate(0,0 ) //data class, it provide default implementation like toString, equals, copy, hashCode

    //Second constructor
    constructor(name: String): this(name, 100, true, false){
        if(name.toLowerCase() == "kar") healthPoints = 40
    } // "this" keyword is calling to primary constructor

    init { // init block is used to validate the data coming in the constructor, will  throw illegalArgumentException is precondition fails
        require(healthPoints> 0) { "healthPoints must be greater than zero." }
        require(name.isNotBlank()) { "Player must have a new" }
    }

    fun castFireball(numFireballs: Int = 2) {
        println("A glass of Fireball springs into existence (x$numFireballs)")
    }

    fun formatHealthStatus(): String = when (healthPoints) {
        100 -> "is in excellent conditon!"
        in 90..99 -> "has a few scracthes."
        in 75..89 -> {
            if (isBlessed) "has some minor wounds but is healing quite quickly"
            else "has some minor wounds "
        }
        in 15..74 -> "looks pretty hurt"
        else -> "is in awful condition!"
    }

    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        return if (auraVisible) "GREEN" else "NONE"
    }

    private fun selectHomeTown(): String {
        return File("data/hometown.txt").readText()
            .split("\n")
            .shuffled()
            .first()
    }

}

fun main() {
    val player = Player("Madrigal", 89, _isBlessed = true, _isImmortal = false)
    println(player.name + "TheBrave")
    player.castFireball(10)

    //Use Enum method to move player position
    Direction.EAST.updateCoordinate(playerCoordinate = player.currentPosition)
}

