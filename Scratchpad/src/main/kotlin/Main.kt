
/**
 * Script: Topic - Lists
 * 1. Let's create a list of integers using the listOf function
 * 1.1. Let´s print the list
 * 1.2. Let's print the even elements of the list
 * 1.3. Let's print the odd elements of the list
 * 1.4. Let's print the result of multiplying by 2 all the elements of the list
 * 2. Let's create a histogram of occurrences of letters in a phrase.
 * 2.1. We start by producing a list of integers (not the best approach)
 *      - For this, we look at List and MutableList
 *      - And we implement it using the same approach as before: a local mutable list to which we add the count
 * 2.2. Next, we produce a list of Occurrences, a data class containing the letter and the count
 * 2.3. Finally, we use buildList
 * 3. What's the problem with our implementation? How many times do we iterate on the input phrase? Can we do better?
 */

data class Occurrence(val letter: Char, val count: Int)

fun histogram(word: String): List<Occurrence> {
    val alphabet = 'a' .. 'z'
    val counts = MutableList(size = alphabet.count()) { 0 }

    word.lowercase().forEach {
        val letterIndex = alphabet.indexOf(it)
        counts[letterIndex] += 1
    }

    return counts.mapIndexed { index: Int, elem: Int ->
        Occurrence(letter = alphabet.elementAt(index), count = elem)
    }
}

fun main() {

    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val evenList = list.filter { it % 2 == 0 }

    val squares = list.map { it * it }

    val anotherList = list
        .filter { it % 2 == 0 }
        .map { (it * it).toString() }

    println(list)
    println(evenList)
    println(squares)
    println(anotherList)

    val counts = histogram("GLORIOSO")
    println(counts)
}
