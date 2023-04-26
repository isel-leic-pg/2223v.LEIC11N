
fun count(phrase: String, predicate: (Char) -> Boolean): Int {
    var count: Int = 0

    phrase.forEach {
        if (predicate(it)) count += 1
    }

//    for (letter in phrase) {
//        if (predicate(letter)) count += 1
//    }

//    for (index in 0 until phrase.length) {
//        if (predicate(phrase[index])) count += 1
//    }
    return count
}

/**
 * Script:
 * 1. Let's count occurrences in a phrase
 * 1.1. Implement countAs function using an imperative approach and using a range of indexes.
 *      - Let's take a closer look at ranges (https://kotlinlang.org/docs/ranges.html)
 * 1.2. Implement countEs function using the same approach as previously
 * 1.3. Can we create a generalization? What are the similarities (or differences)?
 *      - HOF (Higher Order Functions) as a technique for composing behaviour
 *      - Let's take a closer look at the HOFs we've been using
 * 1.4. Change the implementation to use the iterable approach (externalized iteration)
 * 1.5. Next, we use foreach to internalize the iteration (compare both approaches)
 * 1.5. Finally, let's use the count operation and let's check out its implementation. Looks familiar?
 * 2. And now, lists. Let's create a histogram list of occurrences of vowels in a phrase.
 * 2.1. We start by producing a list of integers (not the best approach)
 *      - For this, we look at List and MutableList
 *      - And we implement it using the same approach as before: a local mutable list to which we add the count
 * 2.2. Next, we produce a list of Occurrences, a data class containing the letter and the count
 * 2.3. Finally, we use buildList
 * 3. What's the problem with our implementation? How many times do we iterate on the input phrase? Can we do better?
 */
fun main() {

//    val result = count(phrase = "SLB é o MAIOR") {
//        it.lowercaseChar() == 'a'
//    }

    val result = "SLB é o MAIOR".count { it.lowercaseChar() == 'a' }
    println(result)
}