class HigherOrderFunctions {

    //Declares a higher-order function. It takes two integer parameters, x and y.
    // Additionally, it takes another function operation as a parameter.
    // The operation parameters and return type are also defined in the declaration.
    fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
        return operation(x, y)          //The higher order function returns the result of
    }                                    //operation invocation with the supplied arguments.


    fun operation(): (Int) -> Int {    //Declares a higher-order function that returns a function.
        return ::square         //(Int) -> Int represents the parameters and return type of the square function.
    }

    fun square(x: Int) = x * x            //Declares a function matching the signature.

}