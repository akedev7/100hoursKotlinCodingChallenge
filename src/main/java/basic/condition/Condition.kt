fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortoal = false

    //Aura
    val auraVisible = isBlessed && healthPoints > 50 || isImmortoal
    if (auraVisible) {
        println("GREEN")
    } else {
        println("NONE")
    }

    if (healthPoints == 100) {
        println("$name is in excellent conditon!")
    } else if (healthPoints >= 90) {
        println("$name has a few scracthes.")
    } else if (healthPoints >= 75) {
        if (isBlessed) {
            println("$name has some minor wounds but is healing quite quickly")
        } else {
            println("$name has some minor wounds")
        }
    } else if (healthPoints >= 15) {
        println("$name looks pretty hurt")
    } else {
        println("$name is in awful condition!")
    }

    println("------------")

//    //You can see repeatitive logic for println name
//    //Using a conditional expression instead
    var auraColor = if (auraVisible) "GREEN" else "NONE"
    val healthStatus = if (healthPoints == 100) "is in excellent conditon!"
    else if (healthPoints >= 90) "has a few scracthes."
    else if (healthPoints >= 75) {
        if (isBlessed) "has some minor wounds but is healing quite quickly"
        else "has some minor wounds "
    } else if (healthPoints >= 15) "looks pretty hurt"
    else "is in awful condition!"

    println(auraColor)
    println("$name $healthStatus")
    println("------------")

    //Range + When
//    val auraColor = if (auraVisible) "GREEN" else "NONE"
//    val healthStatus = when (healthPoints) {
//        100 -> "is in excellent conditon!"
//        in 90..99 -> "has a few scracthes."
//        in 75..89 -> {
//            if (isBlessed) "has some minor wounds but is healing quite quickly"
//            else "has some minor wounds "
//        }
//        in 15..74 -> "looks pretty hurt"
//        else -> "is in awful condition!"
//    }
//    println(auraColor)
//    println("$name $healthStatus")
//    println("------------")

//When
    val race = "gnone"
    val faction = when (race) {
        "dwarf" -> "Keepers of the Mines"
        "gnone" -> "Keepers of the Mines"
        "orc" -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        else -> "No faction"
    }
    println(faction)
    println("------------")

//    Challenges: Typing out some ranges
    println(1 in 1..3)
    println((1..3).toList())
    println(1 in 3 downTo 1)
    println(1 in 1 until 3)
    println(2 !in 1..3)
    println('x' in 'a'..'z')
    println("------------")


//    Challenge: Enhancing the Aura
    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()
    auraColor = when (karma) {
        in 0..5 -> "red"
        in 6..10 -> "orange"
        in 11..15 -> "purple"
        in 16..20 -> "green"
        else -> ""
    }
    println(karma)
    println(auraColor)

    //Challenge: Configurable status format
    val statusFormatString = "(HP: $healthPoints)(Aura: $auraColor) -> $name $healthStatus"
    println(statusFormatString)

}