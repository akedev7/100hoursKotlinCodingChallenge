package basic.classes

open class Room(val name: String) {

    open val dangerLevel = 5
    fun description() = "Room: $name" +
            "Danger level: $dangerLevel"

    open fun load() = "Nothing much to see there..."

}

class TownSquare : Room("Town Square") {
    override val dangerLevel = super.dangerLevel - 3
    override fun load() = "The villagers rally and cheer as you enter!\n${ringBell()}"
    private var bellSound = "GWONG"
    private fun ringBell() = "The bell tower announces"
}


fun main() {
    var currentRooom: Room = TownSquare()
    println(currentRooom.description())
    println(currentRooom.load())
    printIsSoruceOfBlessings(currentRooom)

}

fun printIsSoruceOfBlessings(any: Any) {
    val isSourceOfBlessing = if (any is Player) {
        any.isBlessed //Smart casting
    } else {
        (any as Room).name == "Fount of Blessings" //Type casting
    }
    println("$any is a source of blessings: $isSourceOfBlessing")
}