import java.util.Date
import kotlin.random.Random

fun main(){

    // simple print
    println("---------------------hello---------------------")

    //variables: read-only & mutable
    val readOnlyNumber = 5
    var mutableNumber = 10
    val text = "some text"
    /*
    val differentDeclaration: String
    differentDeclaration = "some String"
     */

    //readOnlyNumber += 5    //this is wrong
    mutableNumber -= 5       //this is allowed

    //print expressions
    println("readOnlyNumber: $readOnlyNumber")
    println("mutableNumber: $mutableNumber")
    println("text.length: ${text.length}")

    //collections: List, Set, Map
        //mutable list
    val mutableMessages = mutableListOf("hello", "how are you")
    mutableMessages[0] = "hi"
    mutableMessages.add("today?")
    println(mutableMessages)

        //read only list
    val readOnlyNumbers = listOf(1, 2, 3)

    //readOnlyNumbers[0] = 0  //can not modify
    println("second parameter of readOnlyNumbers: ${readOnlyNumbers[1]}")
    println("does readOnlyNumbers contains 3: ${3 in readOnlyNumbers}")
    println("count of elements in readOnlyNumbers: ${readOnlyNumbers.count()}")

    //Set

        //read-only
    val readOnlyFruits = setOf("apple", "banana", "cherry", "cherry") //cherry is duplicated

        //mutable
    val mutableFruits: MutableSet<String> = mutableSetOf("apple", "cherry", "banana")
    mutableFruits.add("apple")

    //mutableFruits[0] = "orange"  //As sets are unordered, you can't access an item at a particular index
    println("readOnlyFruits: $readOnlyFruits")
    println("mutableFruits: $mutableFruits")

    //Map
    val readOnlyFoodPrices: Map<String, Int> = mapOf("pizza" to 170, "sandwich" to 90)
    val mutableFoodPrices = mutableMapOf("pizza" to 170, "sandwich" to 90)

    //mutableFoodPrices.put("stake", 185)
    mutableFoodPrices["stake"] = 185
    println("readOnlyFoodPrices: $readOnlyFoodPrices")
    println("mutableFoodPrices: $mutableFoodPrices")
    println("menu contains pizza: ${"pizza" in mutableFoodPrices.keys}")
    println("foods menu only prices: ${mutableFoodPrices.values}")


    //conditional expressions

        //if
    val age = Random.nextInt(1, 36)
    if(age > 18){
        println("you can enter")
    }else {
        println("you can not enter")
    }

    //use (if) as ternary expression
    println(
        if(age > 18) "you are greater than 18"
        else "you are 18 or less"
    )

        //when
    val num = Random.nextInt(1, 4)
    when(num){
        1 -> println("one")
        2 -> println("two")
        3 -> println("three")
    }

    // use (when) as ternary expression
    val result = when(num){
        1 -> "one"
        2 -> 2
        3 -> "three"
        else -> "unknown"
    }
    println("result: $result")

    //using (when) with Boolean expressions
    val temp = Random.nextInt(-5, 13)
    val description = when{
        temp <= -3 -> "freezing"
        //using range check
        (temp in -2..0) -> "getting cold"
        (temp in 1..4) -> "warm"
        (temp > 5) -> "hot"
        else -> "temp = $temp"
    }
    println("weather description: $description")

    // other range checks which can be use
    /*
        ..<
        4 downTo 1
        1..5 step 2
        'a'..'d'
        'z' downTo 's'
     */

    //loops

        //for
    for(i in 1..5){
        println("inside for: i = $i")
    }

    val cakes = listOf("carrot", "cheese", "chocolate")
    //iterate over collections
    for(cake in cakes)
        println(cake)

        //while
    var cakesEaten = 0
    while(cakesEaten < 3){
        println("cakesEaten: ${cakesEaten++}")
    }

    cakesEaten = 0
    var cakesBaked = 4
    do{
        cakesEaten++
        cakesBaked--
        println("eaten a cake")
    }while(cakesBaked > 0)
    println("ate $cakesEaten cakes!!!!")

    // calling functions
    sayHello()
    printFactorial(5)
    val numbers = listOf(1, 5, 8, 6, 9, 7, 4, 531, 45, 58, 78, 54, 65)
    printOddNumbers(numbers)

        //named arguments
    printMessageWithPrefix(prefix = "log", message = "hello")
    printMessageWithPrefix("hello")

        //single expression function: look at the declaration
    println(sum(5, 4))

    //lambda expression
    println({msg: String -> msg.uppercase()}("hello"))

    //assign lambda expression to a variable
    val makeStringUppercase = {msg: String -> msg.uppercase()}
    println(makeStringUppercase("good bye"))

    // define with function type
    val makeStringLowerCase: (String) -> String = {str -> str.lowercase()}
    println(makeStringLowerCase("WHATS UP"))

    //pass lambda expression to another function
    val evenNumbers = numbers.filter {x -> x % 2 == 0}
    val oddNumbers = numbers.filter {x -> x % 2 != 0}
    val doubled = numbers.map {n -> n * 2}
    val tripled = numbers.map {n -> n * 3}
    println("evenNumbers: $evenNumbers")
    println("oddNumbers: $oddNumbers")
    println("doubledNumbers: $doubled")
    println("tripledNumbers: $tripled")

    //using functions with lambda return type
    val timesInMinutes = listOf(2, 10, 15, 1)
    val minutesToSeconds = toSeconds("minute")
    val totalTimeInSeconds = timesInMinutes.map(minutesToSeconds).sum()
    println("totalTimeInSeconds: $totalTimeInSeconds")

    //classes
    class Contact(var firstname: String, var lastname: String)
    val c = Contact("ahmad", "yazdi")
    c.firstname = "Ahmad"
    c.lastname = "Yazdi"
    println("contact: ${c.firstname} ${c.lastname}")

    class Costumer{
        var id: Long = 0
        var email: String = ""
        override fun toString(): String{
            return "id: $id \nemail: $email"
        }
    }
    val costumer = Costumer()
    costumer.id = 1
    costumer.email = "ahmad@gmail.com"
    println("costumer: $costumer")

        //data classes
    data class Dog(var id: Long, var name: String)
    val dog = Dog(1, "alex")
    val dog2 = Dog(2, "teddi")
    val dog3 = dog.copy()
    println("dog: $dog") //don't need to override toString() function
    println("dog equals dog2? ${dog == dog2}")
    println(dog3)

    //null safety
    var neverNull: String = "This can't be null"

        //neverNull = null  //this is not allowed
    var nullable: String? = "this one can be null"
    nullable = null

        //printMessageWithPrefix(nullable)  //nullables can't be passed as function parameter
    nullTaker(neverNull)
    nullTaker(nullable)

        //null safe calls
    println(nullable?.length)

        //Elvis operator ?:
        //provide a default value to return if a null value is detected
    println(nullable?.length ?:0)
}


//functions
fun sayHello(){
    println("helloooooooooooooooooo")
}

fun printFactorial(num: Int){
    println("------ print factorial ------")
    if(num > 0){
        var f = 1
        print("$num! = ")
        for(i in num downTo 1){
            print("$i ")
            f *= i
            if(i > 1) print("* ")
        }
        println("= $f")
    }
}

fun printOddNumbers(numbers: List<Int>){
    println("------ printEvenNumbers ------")
    for(n in numbers)
        print(
            if(n > 0 && n % 2 != 0) "$n \n"
            else ""
        )
}

fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("[$prefix] $message")
}

//single expression function
fun sum(x: Int, y: Int) = x + y

//Return lambda expression from a function
fun toSeconds(time: String): (Int) -> Int = when(time){
    "hour" -> {value -> value * 60 * 60}
    "minute" -> {value -> value * 60}
    else -> {value -> value}
}

//accept null in functions
fun nullTaker(maybeNull: String?){
    if(!maybeNull.isNullOrEmpty()) println("the value inside maybeNull is: $maybeNull")
    else println("maybeNull is null or empty")
}