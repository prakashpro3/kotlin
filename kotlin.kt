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
