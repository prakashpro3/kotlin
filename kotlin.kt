fun removeNullDataFromList(){
    //Efficient way to transform and remove null values.
    val data = listOf("2", "4", null, "6")
    val result = data.mapNotNull {it?.toIntOrNull()}
    println("Output: $result") // Output: [2, 4, 6]
}

fun groupItemBykeyFromList(){
    //group items based on a key
    val words = listOf("apple", "banana", "avocado", "blueberry")
    val result = words.groupBy {it?.first()}
    println("Output: $result") // Output: {a=[apple, avocado], b=[banana, blueberry]}

    val numbers = listOf(1, 2, 3, 4, 5, 6)
    val grouped = numbers.groupBy { if (it % 2 == 0) "Even" else "Odd" }
    println("Output: $grouped") // Output: {Odd=[1, 3, 5], Even=[2, 4, 6]}


    data class Student(val name: String, val grade: Char)
    val students = listOf(
       Student("Alice", 'A'),
       Student("Bob", 'B'),
       Student("Charlie", 'A'),
       Student("Dave", 'C')
    )
    val groupedByGrade = students.groupBy { it.grade }
    println("Output: $groupedByGrade") // Output: {A=[Student(name=Alice, grade=A), Student(name=Charlie, grade=A)], B=[Student(name=Bob, grade=B)], C=[Student(name=Dave, grade=C)]}


    val files = listOf("doc.txt", "image.png", "data.csv", "notes.txt", "diagram.png")
    val filesGrouped = files.groupBy { it.substringAfterLast('.') }
    println("Output: $filesGrouped") // Output: {txt=[doc.txt, notes.txt], png=[image.png, diagram.png], csv=[data.csv]}
}

fun filterUniqueDataFromList(){
    // filter unique/distinct items from the list
    data class User(val id: Int, val name: String)
    val data = listOf(User(1, "Alice"), User(1, "Alice"), User(2, "Bob"), User(3, "Alice"))
    val result = data.distinct()
    println("Output: $result") // Output: [User(id=1, name=Alice), User(id=2, name=Bob), User(id=3, name=Alice)]
    val distinctByKey = data.distinctBy {it?.name}
    println("Output: $distinctByKey") // Output: [User(id=1, name=Alice), User(id=2, name=Bob)]
}

fun mergeMultipleList(){
    // merge multiple lists
    val nestedList = listOf(listOf(1, 2, 3), listOf(4, 5))
    val result = nestedList.flatten()
    println("Output: $result") // Output: [1, 2, 3, 4, 5]
}

fun mergeMultipleListWithObject() {
    data class Book(val title: String, val authors: List<String>)
    val book1 = Book("Book 1", listOf("Author A", "Author B"))
    val book2 = Book("Book 2", listOf("Author C"))
    val book3 = Book("Book 3", listOf("Author B", "Author D"))

    val books = listOf(book1, book2, book3)
    val authors = books.flatMap { it.authors }
    
    println("Output: $authors") // Output: [Author A, Author B, Author C, Author B, Author D]
}

fun zipMultipleList(){
    // merge multiple lists
    val names = listOf("Alice", "Bob")
    val ages = listOf(25, 30)
    val result = names.zip(ages)
    
    println("Output: $result") // Output: [(Alice, 25), (Bob, 30)]
}

fun saperateList(){
    // Separate elements based on a condition.
    val numbers = listOf(1, 2, 3, 4, 5)
    val (even, odd) = numbers.partition { it % 2 == 0}
    
    println("Output-even: $even") // Output-even: [2, 4]
    println("Output-odd: $odd")   // Output-odd: [1, 3, 5]
}

fun separatePeopleByAge() {
    data class Person(val name: String, val age: Int)
    val people = listOf(
        Person("Alice", 25),
        Person("Bob", 30),
        Person("Charlie", 17),
        Person("Diana", 15)
    )

    val (adults, minors) = people.partition { it.age >= 18 }
    
    println("Adults: $adults")   // Output: [Person(name=Alice, age=25), Person(name=Bob, age=30)]
    println("Minors: $minors")   // Output: [Person(name=Charlie, age=17), Person(name=Diana, age=15)]
}

fun chunksList(){
    // Split a list into smaller batches.
    val numbers = (1..10).toList() // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    val result = numbers.chunked(3)
    println("Output: $result") // Output: [[1, 2, 3], [4, 5, 6], [7, 8, 9], [10]]
    val windowed = numbers.windowed(3, 1)
    println("Output: $windowed") // Output: [[1, 2, 3], [2, 3, 4], [3, 4, 5], [4, 5, 6], [5, 6, 7], [6, 7, 8], [7, 8, 9], [8, 9, 10]]
}

fun calculateSumsOfList(){
    // Calculate sums.
    val numbers = listOf(1, 2, 3, 4)
    val result = numbers.sum()
    println("Output: $result") // Output: 10
}

fun calculateSumsList(){
    // Calculate sums.
    val numbers = listOf(1, 2, 3, 4)
    val result = numbers.fold(0) {acc, num -> acc + num}
    println("Output: $result") // Output: 10
    val result2 = numbers.fold(3) {acc, num -> acc + num}
    println("Output: $result2") // Output: 13

    val words = listOf("Kotlin", "is", "awesome")
    val sentence = words.fold("") { acc, word -> acc + " " + word }
    println(sentence.trim())  // Output: Kotlin is awesome

    val numbers = listOf(1, 2, 3, 4)
    val product = numbers.fold(1) { acc, num -> acc * num }
    println(product)  // Output: 24

    val keyValueList = listOf(Pair("a", 1), Pair("b", 2), Pair("c", 3))
    val map = keyValueList.fold(mutableMapOf<String, Int>()) { acc, pair ->
        acc[pair.first] = pair.second
        acc
    }
    println(map)  // Output: {a=1, b=2, c=3}
}

fun calculateSumUsingReduce() {
    val numbers = listOf(1, 2, 3, 4)
    val result = numbers.reduce { acc, num -> acc + num }
    println("Sum using reduce: $result")  // Output: 10
}

fun findMaxNumber() {
    // finds the largest element in the list or collection.
    val numbers = listOf(1, 2, 3, 4, 5)
    val max = numbers.reduce { acc, num -> if (acc > num) acc else num }
    println("Max value using reduce: $max")  // Output: 5
    
    val max2 = numbers.maxOrNull()
    println("Max value using reduce: $max2")  // Output: 5
    
    data class Person(val name: String, val age: Int)
    val people = listOf(Person("Alice", 25), Person("Bob", 30), Person("Charlie", 28))
    val oldestPerson = people.maxByOrNull { it.age }
    println("Oldest person: $oldestPerson")  // Output: Oldest person: Person(name=Bob, age=30)
}

fun lamdaExpressionAlternateInterface() {
    lamdaExpressionToOvercomeInterface(
        onSuccess = {it -> println("Message: $it")},
        onFailure = {it -> println("Message: $it")}
    )
}

fun lamdaExpressionToOvercomeInterface(onSuccess:(String) -> Unit, onFailure:(String) -> Unit) {
    onSuccess("Hi")
    onFailure("Errororo")
}

fun takeIfUnless(){
    val age = 19
    val result1 = age.takeIf {it > 18}?.let{ 
        println("TakeIf: $it") // age=21 this will print
        "user is able to vote"
    } // output: age=21 - user is able to vote Or null
    
    val result2 = age.takeUnless {it > 18}?.let{ 
        println("takUnless: $it") // age=18 this will print
        "user is not able to vote"
    } // output: age=18 - user is not able to vote Or null
    
    println("result1: $result1")
    println("result2: $result2")
}
