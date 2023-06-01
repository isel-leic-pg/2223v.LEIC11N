
data class Student(val number: Int, val grades: List<Float>)

fun average(grades: List<Float>): Float {
    var total = 0f
    for (grade in grades)
        total += grade
    return total / grades.size
}

fun getBestN(grades: List<Float>, n: Int): List<Float> {

    var result = grades
    while (result.size > n) {
        val elem: Float? = result.minOrNull()
        if (elem != null)
            result = result - elem
    }

//    val result = grades.toMutableList()
//    while (result.size > n) {
//        val elem = result.minOrNull()
//        if (elem != null)
//            result.remove(elem)
//    }

    return result
}

fun Student.computeAverageOfBestN(n: Int): Float {
    require(n > 0)
    return average(getBestN(grades, n))
}

data class StudentGradeAverage(
    val number: Int,
    val average: Float
)

fun getApprovedStudentsAverages(
    students: List<Student>
): List<StudentGradeAverage> {
    return students
        .map {
            StudentGradeAverage(
                number = it.number,
                average = it.computeAverageOfBestN(3)
            )
        }
        .filter { it.average >= 8 }
}

fun getApprovedStudentsNumbers(
    students: List<Student>
): List<Int> {
    return getApprovedStudentsAverages(students).map { it.number }
}
