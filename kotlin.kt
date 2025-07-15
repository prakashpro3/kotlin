fun removeNullDataFromList(){
    //Efficient way to transform and remove null values.
    val data = listOf("2", "4", null, "6")
    val result = data.mapNotNull {it?.toIntOrNull()}
    println("Output: $result") // Output: [2, 4, 6]
}
