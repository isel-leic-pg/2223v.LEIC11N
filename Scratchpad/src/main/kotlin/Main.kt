
/**
 * Script: Topic - Immutability and Mutability
 * 1. Let's refine our mental model of execution
 * 1.1. Local variables and local values, revisited
 * 1.1.1 Simple values
 * 1.1.2 Compound values
 * 1.1.3 Variables of simple types and of compound types
 * 1.3. What is the difference between a value and a variable?
 * 2. Remember: the substitution model of execution only works for immutable values
 * 3. What about compound types? What does it mean to be immutable?
 * 3.1. What are the consequences of mutability in compound types?
 * 3.2. Value types and reference types
 * 3.2. Identity and equivalence
 * 4. Conclusion: prefer immutable values and immutable compound types, for the sake of simplicity
 */
fun main() {
    var l1 = mutableListOf(1, 2)
    val l2 = l1
    l1.add(3)
    println(l1)
    println(l2)

    l1 = mutableListOf(4)

    l1.add(5)
    println(l1)
    println(l2)
}
