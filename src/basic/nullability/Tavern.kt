fun main() {


    // readLine method return String?, it means it can return value of null
    var beverage = readLine()
//    beverage.capitalize()  **This capitalizes method cannot be called because beverage can be null
    beverage = null
    println(beverage)
    println("-----------")

    //Then, There are 3 ways to handle nullability
    //1 - Use the safe call operator (check if it's not null before call the method) / or use let
    println(beverage?.capitalize())
    println("-----------")

    println(beverage?.let{
        if (it.isNotBlank()) {
            it.capitalize()
        } else {
            "Buttered Ale"
        }
    })
    println("-----------")

//2 - Use !!. if you're sure that the variable will NEVER null, otherwise, it will cause a null pointer exception
    println(beverage!!.capitalize())

//3 - Use IF for null checking (if possible, prefer the safe call operator because of less code)
    if (beverage != null) {
        print(beverage.capitalize())
    } else {
        println("Beverage is null!!")
    }

    //or give default value
    val selectedBeverage = beverage ?: "Beverage is null"
    println(selectedBeverage)

}




