package basic.classes

import java.io.File

object Game {

    private val player = Player("Madrigal")
    private var currentRoom: Room = TownSquare()

    init {
        println("Welcome, adventurer.")
    }

    fun play() {
        while (true) {
            println(currentRoom.description())
            println(currentRoom.load())

            //Palyer status
            printPlayerStatus(player)
            print("> Enter your command:")
//            println("Last command: ${readLine()}")
            println(GameInput(readLine()).processCommand())

        }
    }

    private fun printPlayerStatus(player: Player) {
        println(
            "Aura: ${player.auraColor()}" +
                    "Blessed: ${if (player.isBlessed) "YES" else "NO"}"
        )
        println("${player.name} ${player.formatHealthStatus()}")
    }

    private class GameInput(arg: String?) { //GameInput belongs to Game instance
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, { "" })

        fun processCommand() = when (command.toLowerCase()) {
            else -> commandNotFound()
        }

        private fun commandNotFound() = "I'm not quite sure what you're tring to do!"
    }

}

class PremadeWorldMap {
    companion object { // like static variable and method in a java class
        private const val MAPS_FILEPATH = "myethack.maps"
        fun load() = File(MAPS_FILEPATH).readBytes()
    }
}

fun main() {
    Game.play()
}