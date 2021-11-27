package basic.classes

data class Coordinate(val x: Int, val y: Int) {
    val isInBounds = x >= 0 && y >= 0


    //Operator overloading
    operator fun plus(other: Coordinate) = Coordinate(x + other.x, y + other.y)

}

enum class Direction(private val coordinate: Coordinate) { //Tie each Direction to Coordinate
    NORTH(Coordinate(0, -1)),
    EAST(Coordinate(1, 0)),
    SOUTH(Coordinate(0, 1)),
    WEST(Coordinate(-1, 0));

    fun updateCoordinate(playerCoordinate: Coordinate) {
        Coordinate(playerCoordinate.x + coordinate.x, playerCoordinate.y + coordinate.y)
    }
}