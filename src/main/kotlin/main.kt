fun main() {

    fun sum(x: Int, y: Int) = x + y     //Declares a function that matches the operation signature.


    val higherOrderFunctions = HigherOrderFunctions()
    val sumResult = higherOrderFunctions.calculate(4, 5, ::sum)            //Invokes the higher-order function passing
                                                                // in two integer values and the function argument ::sum.
                                                     // :: is the notation that references a function by name in Kotlin.

    val mulResult = higherOrderFunctions.calculate(4, 5) { a, b -> a * b }       //Invokes the higher-order function
                                                                            // passing in a lambda as a function argument.
    println("sumResult $sumResult, mulResult $mulResult")

    val func = higherOrderFunctions.operation()     //Invokes operation to get the result assigned to a variable.
    println(func(2))                            //Invokes func. The square function is actually executed.

    println()

    val lambdaFunctions = LambdaFunctions()

    lambdaFunctions.printSomeLambdas("wyraz")

    println()

}