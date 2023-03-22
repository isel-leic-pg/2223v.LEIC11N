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