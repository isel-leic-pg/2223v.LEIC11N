# Outline

## Week 1
### 01/03/2023 - Course introduction
* Syllabus, teaching methodology 
* [Evaluation](https://2223moodle.isel.pt/mod/page/view.php?id=131603) (for authenticated users)
* Bibliography
  * [Conceitos de Programação em Kotlin, por Pedro Pereira](docs/ProgKotlin-28022023.pdf)
  * [Kotlin Apprentice (book)](https://www.amazon.com/Kotlin-Apprentice-Second-Beginning-Programming/dp/1950325008/ref=sr_1_1)
  * [Kotlin Home - language reference](https://kotlinlang.org/docs/reference/)

### 02/03/2023 - Representations
* Brief overview of the development environment
  * Identification of the main tools and build artifacts
  * [IntelliJ IDEA download](https://www.jetbrains.com/idea/download/)
  * [Open JDK 17.0.2 download](https://jdk.java.net/archive/)
* Kotlin's type system, introduction
  * [Primitive types](https://kotlinlang.org/docs/reference/basic-types.html)
  * Values and expressions (and __composing__ expressions)
  * __Composing__ values through aggregate data types
    * [Data classes](https://kotlinlang.org/docs/reference/data-classes.html)
* Immutability
  * Concept and motivation

***For reference:***
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=Z-MliPgm2Bg&list=PL8XxoCaL3dBgtEHFYBQHgXqxquGS945ju&index=1)


## Week 2
### 08/03/2023 - Behaviour, introduction
* Mental model of execution
  * Program order vs. execution order
* Elements of abstraction and code reuse, introduction
  * [Functions](https://kotlinlang.org/docs/functions.html), introduction
    *** Declaration and invocation (syntax and behaviour)
    *** Parameters and return values

***For reference:***
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=IkU5mpHrpS4&list=PL8XxoCaL3dBgtEHFYBQHgXqxquGS945ju&index=2)
* [Introdução ao controlo de versões com Git](https://www.youtube.com/watch?v=OiyyszczoGM&list=PL8XxoCaL3dBhHI1E3XKp_QeWQnxKd6U8x&index=2)

### 09/03/2023 - Behaviour, continued
* Mental model of execution, continued
  * Program order vs. execution order
* [Functions](https://kotlinlang.org/docs/functions.html), continued
  * Declaration and invocation (syntax and behaviour)
  * Parameters and return values
  * [Named arguments](https://kotlinlang.org/docs/functions.html#named-arguments)
  * [Default values](https://kotlinlang.org/docs/functions.html#default-arguments)
* Functions as:
  * Pure functions (no side effects)
  * Effectful functions (with side effects)
* Control flow
  * [Repetition using `for` construct](https://kotlinlang.org/docs/control-flow.html#for-loops)
* Displaying graphics on the screen using the [CanvasLib library](docs/CanvasLib102.pdf)

***For reference:***
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=zYilGk7XOlk&list=PL8XxoCaL3dBgtEHFYBQHgXqxquGS945ju&index=3)

## Week 3
### 15/03/2023 - Behaviour, continued
* Functions as a means of abstraction and code reuse
* Functions as: (revisited)
  * Pure functions (no side effects)   
  * Effectful functions (with side effects)   
* Displaying graphics on the screen using the CanvasLib library (continued)   
  * [Documentation](docs/CanvasLib102.pdf)   
  * [Repository](https://github.com/CCISEL/CanvasLib)   
* Live coding session: Building a PacMan clone   

***For reference:***
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=EAf7so_93ds&list=PL8XxoCaL3dBgtEHFYBQHgXqxquGS945ju&index=4)

### 16/03/2023 - Behaviour, continued
* Mental model of execution, continued   
  * Program order vs. execution order, revisited   
* Functions as a means of abstraction and code reuse (continued)   
* Control flow: Conditional expressions   
  * [Conditional expressions using `if` construct](https://kotlinlang.org/docs/control-flow.html#return-ifs)   
  * [Conditional expressions using `when` construct](https://kotlinlang.org/docs/control-flow.html#return-when)   
* Handling keyboard input using the CanvasLib library   
  * Introduction to the event based programming model   
  * The event loop, event queue and event handlers   
* Introduction to mutable state
  * `var` vs `val`
  * Imposing a discipline of immutability
* Representations:
  * [Enum classes](https://kotlinlang.org/docs/enum-classes.html)
* Live coding session: Building a PacMan clone, continued

***For reference:***
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=IjR5Jc7lIAo&list=PL8XxoCaL3dBgtEHFYBQHgXqxquGS945ju&index=5)

## Week 4
### 22/03/2023 - Coding session
* Revisiting the studied constructs
  * Putting the pieces together
    * Representations: primitive types, data classes and enum classes
    * Behaviour: functions, expressions, repetition and conditional expressions
* Live coding session: Building a PacMan clone, continued

***For reference:***
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=55o8uSro8Wc&list=PL8XxoCaL3dBgtEHFYBQHgXqxquGS945ju&index=6)

### 23/03/2023 - Functions, continued
* Extension functions
  * Purpose and motivation
  * [Documentation](https://kotlinlang.org/docs/extensions.html)
* Operator overloading
  * Purpose and motivation
  * [Documentation](https://kotlinlang.org/docs/operator-overloading.html)
* Live coding session: Building a PacMan clone, continued
  * Applying the new concepts to the game implementation
  * Adding animations to the game:
    * Expressing repetition using `canvas.setInterval`

***For reference:***
*[Lecture video (in Portuguese)](https://www.youtube.com/watch?v=FoVXnj7i3TQ&list=PL8XxoCaL3dBgtEHFYBQHgXqxquGS945ju&index=7)
  
## Week 5
### 29/03/2023 - Coding session
* Putting the pieces together
  * Revisiting the studied constructs
* Live coding session: Building a PacMan clone, continued

***For reference:***
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=O5O14nazqng&list=PL8XxoCaL3dBgtEHFYBQHgXqxquGS945ju&index=8)

### 30/03/2023 - Practice session
* Session dedicated to solving the first assignment

## Week 6
### 05/04/2023 - Evaluation session
* Session dedicated to the first mini test
  * Revision of the studied concepts
  * Realization of the first mini test

### 06/04/2023 - Easter break

## Week 7
### 12/04/2023 - Automated tests: introduction
* Introduction to automated tests
  * Purpose and motivation
  * [Documentation](https://kotlinlang.org/docs/jvm-test-using-junit.html)
* Applicability in the running example: PacMan clone

***For reference:***
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=McX2ozWcD0c&list=PL8XxoCaL3dBgtEHFYBQHgXqxquGS945ju&index=9)

### 13/04/2023 - Coding and debugging session
* Live coding session: Building a PacMan clone, continued
  * Dealing with bugs
  * Automated tests, continued

***For reference:***
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=Z8Z8Z8Z8Z8Z&list=PL8XxoCaL3dBgtEHFYBQHgXqxquGS945ju&index=10)

## Week 8
### 19/04/2023 - Coding session
* Live coding session: Building a PacMan clone, continued
  * A mental model for solving programming problems, continued

***For reference:***
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=z-4-qiOA0AY&list=PL8XxoCaL3dBgtEHFYBQHgXqxquGS945ju&index=11)

### 20/04/2023 - Representations, continued
* Kotlin's type system, continued
  * [Nullable types](https://kotlinlang.org/docs/null-safety.html)
    * Motivation 
    * Smart casts
  * Collections, introduction
    * Lists (concept and implementation)
    * Arrays vs linked lists, introduction
* Applicability in the running example: PacMan clone

***For reference:***
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=mMbstvBdnMU&list=PL8XxoCaL3dBgtEHFYBQHgXqxquGS945ju&index=12)

## Week 9
### 26/04/2023 - Higher Order Functions, introduction
* Functions, revisited
  * Global functions
* [Functions as values: Higher Order Functions](https://kotlinlang.org/docs/lambdas.html)
  * Purpose and motivation
  * Function types
  * Functions references: operator `::`

***For reference:***
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=T07IZcjyQuU&list=PL8XxoCaL3dBgtEHFYBQHgXqxquGS945ju&index=13)

### 27/04/2023 - Practice session
* Session dedicated to solving the second assignment

## Week 10
### 03/05/2023 - Collections: lists
* Immutable and mutable lists
  * [Documentation](https://kotlinlang.org/docs/collections-overview.html#list)
  * Motivation
  * Properties
* Expressing repetition
  * Using the `for` construct ([docs](https://kotlinlang.org/docs/control-flow.html#for-loops))
  * Using `forEach` ([docs](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/for-each.html))
* List operations:
  * Element selection: `filter` ([docs](https://kotlinlang.org/docs/collection-filtering.html))
  * Element transformation: `map` ([docs](https://kotlinlang.org/docs/collection-transformations.html))

***For reference:***
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=wFAwnWelJhI&list=PL8XxoCaL3dBgtEHFYBQHgXqxquGS945ju&index=14)

### 04/05/2023 - Evaluation session 
* Session dedicated to the second mini test
  * Revision of the studied concepts
  * Realization of the second mini test

## Week 11
### 10/05/2023 - Immutability and mutability
* Using immutable data representations
  * Motivation and consequences
* Using mutable data representations
  * Motivation and consequences
  * Identity and equivalence
* [Equality in Kotlin](https://kotlinlang.org/docs/equality.html)

***For reference:***
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=QwopbhP4-VY&list=PL8XxoCaL3dBgtEHFYBQHgXqxquGS945ju&index=15)

### 11/05/2023 - Coding session
* Live coding session: Building a PacMan clone, continued
  * A mental model for solving programming problems, continued

***For reference:***
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=nxHZhnjEBfI&list=PL8XxoCaL3dBgtEHFYBQHgXqxquGS945ju&index=16)
