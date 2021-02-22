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

    val order = Order(listOf(Item("Bread", 25.0F), Item("Wine", 29.0F), Item("Water", 12.0F)))

    //Calls extension functions directly on an instance of Order.
    println("Max priced item name: ${order.maxPricedItemName()}")
    println("Max priced item value: ${order.maxPricedItemValue()}")
    println("Min priced item name: ${order.minPricedItemName()}")
    println("Min priced item value: ${order.minPricedItemValue()}")
    println("Items: ${order.commaDelimitedItemNames}")      //Accesses the extension property on an instance of Order.

    val pusty = null
    println(pusty.nullSafeToString())

}

//Adds extension functions for the Order type.
fun Order.maxPricedItemValue(): Float = this.items.maxByOrNull { it.price }?.price ?: 0F
fun Order.minPricedItemValue(): Float = this.items.minByOrNull { it.price }?.price ?: 0F
fun Order.maxPricedItemName() = this.items.maxByOrNull { it.price }?.name ?: "NO_PRODUCTS"
fun Order.minPricedItemName() = this.items.minByOrNull { it.price }?.name ?: "NO_PRODUCTS"

val Order.commaDelimitedItemNames: String         //Adds an extension property for the Order type.
    get() = items.map { it.name }.joinToString()

//It is even possible to execute extensions on null references. In an extension function,
// you can check the object for null and use the result in your code:
fun <T> T?.nullSafeToString() = this?.toString() ?: "NULL"