fun main() {


    //Example of anonymous function in standard library
    var numLetter = "Mississippi".count()
    println(numLetter)

    numLetter = "Mississippi".count { letter -> letter == 's' }
    println(numLetter)
    println("-----------")

    println({
        val currentYear = 2018
        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
    }())


    //Assign anonymous function to a variable
    val greetomgFunction: () -> String = {
        val currentYear = 2018
        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
    }
    println(greetomgFunction())
    println("-----------")

    //Note: if anonymous function accept 1 argument, we can use "it"
    val greetingFunctionWithPlayerNameAndNumBuilding: (String, Int) -> String = { playerName, numBuildings ->
        val currentYear = 2018
        println("Adding $numBuildings horses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
    println(greetingFunctionWithPlayerNameAndNumBuilding("Gyul", 10))
    println("-----------")

    //Define a function that accepts a function (can be anonymous function (lambda) or named function (need to use :: to refer it)
    runSimulation(playerName = "Guyul", greetingFunctionWithPlayerNameAndNumBuilding, ::printConstructionCost)
    println("-----------")

    //Define a function that can return a function (i.e., contructionCostFactory)
    runSimulation(
        playerName = "Guyul",
        greetingFunctionWithPlayerNameAndNumBuilding,
        contructionCostFactory("high-grade")
    )

}

fun contructionCostFactory(type: String) =
    when (type) {
        "high-grade" -> {
            numBuilding -> println("high grade construction cost ${1000 * numBuilding}")
        }
        else -> ::printConstructionCost
    }


// inline keyword is used in function that accept lambda to reduce cost of lambda memory allocation, it will just inline the lambda into the callers when complied.
inline fun runSimulation(
    playerName: String,
    greetingFunction: (String, Int) -> String,
    costPrinter: (Int) -> Unit
) {
    val numBuildings = (1..3).shuffled().last()
    println(greetingFunction(playerName, numBuildings))
    costPrinter(numBuildings)
}

fun printConstructionCost(numBuilding: Int) {
    val cost = 500
    println("construction cost: ${cost * numBuilding}")
}




