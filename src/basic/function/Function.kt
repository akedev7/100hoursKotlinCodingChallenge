const val MAX_EXPERIENCE: Int = 5000

fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortoal = false

    //Aura
    val auraVisible = isBlessed && healthPoints > 50 || isImmortoal
    var auraColor = getAuraColor(auraVisible)
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)
    castFireball()
}

private fun getAuraColor(auraVisible: Boolean) = if (auraVisible) "GREEN" else "NONE"

private fun castFireball(numFireballs: Int = 2) =
    println("A glass of Fireball springs into existence. (x$numFireballs)")

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println("(Aura $auraColor)(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String = when (healthPoints) {
    100 -> "is in excellent conditon!"
    in 90..99 -> "has a few scracthes."
    in 75..89 -> {
        if (isBlessed) "has some minor wounds but is healing quite quickly"
        else "has some minor wounds "
    }
    in 15..74 -> "looks pretty hurt"
    else -> "is in awful condition!"
}


