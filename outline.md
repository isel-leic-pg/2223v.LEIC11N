# Outline

## Week 1
### 01/03/2023 - Course introduction
* Syllabus, teaching methodology 
* [Evaluation](https://2021moodle.isel.pt/mod/page/view.php?id=121005) (for authenticated users)
* Bibliography
  * [Kotlin Apprentice (book)](https://www.amazon.com/Kotlin-Apprentice-Second-Beginning-Programming/dp/1950325008/ref=sr_1_1)
  * [Kotlin Home - language reference](https://kotlinlang.org/docs/reference/)

## Week 2
### 12/10/2020 - The programmer's universe (introduction)

> Underlying every programming language is a model
> of a computing system that its programs control.   

by John Backus, [here](https://dl.acm.org/doi/pdf/10.1145/359576.359579)

* Tecnhology stacks and programming models
  * [The tech stack drawn during the lecture](assets/tech_stack.png "A tech stack")

For reference:
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=wEd6ARKXCjI&list=PL8XxoCaL3dBgXjxTLx4Fm-uxTD8k-cXQA&index=2)

### 14/10/2020 - Representations
* Our first steps in Kotlin
  * The `Hello world!` application
  * The REPL (_Read Evaluate Print Loop_)
  * [Kotlin playground](https://play.kotlinlang.org/)
  * Building and running a trivial program
    * Comand line tools (kotlinc, javac, java)
  
* Kotlin's type system, introduction
  * [Primitive types](https://kotlinlang.org/docs/reference/basic-types.html)
  * Values and expressions (and __composing__ expressions)
  * __Composing__ values through aggregate data types
    * [Data classes](https://kotlinlang.org/docs/reference/data-classes.html)
  
For reference:
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=nobgBEA2oP8&list=PL8XxoCaL3dBgXjxTLx4Fm-uxTD8k-cXQA&index=3)

### 19/10/2020 - Representations, continued
* Kotlin's type system, continued
  * [Data classes](https://kotlinlang.org/docs/reference/data-classes.html)
    * Default construction parameters
    * Named arguments
    * [Parameters and arguments](https://en.wikipedia.org/wiki/Parameter_(computer_programming)#Parameters_and_arguments) (a.k.a. _formal_ parameters and _actual parameters_)
  * Strings, revisited
    * String templates and string concatenation
* Immutability
  * A simplified mental model for representations
  * The substitution model of evaluation

For reference:
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=YELdO0TZEhM&list=PL8XxoCaL3dBgXjxTLx4Fm-uxTD8k-cXQA&index=4)

### 21/10/2020 - Setup
* Setting up the development environment

For reference:
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=GZWstPijzxA&list=PL8XxoCaL3dBgXjxTLx4Fm-uxTD8k-cXQA&index=5)

### 26/10/2020 - Behaviour
* Elements of code reuse and code organization
  * Functions as
    * Pure functions
    * Effects
* Mental model for execution
  * The substitution model of evaluation
  * Program order vs execution order

For reference:
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=1uH6NwxSHEo&list=PL8XxoCaL3dBgXjxTLx4Fm-uxTD8k-cXQA&index=6)
* [Code used to draw an explosion (a red circle) where the mouse is pressed](https://gist.github.com/palbp/d0f43caa85b21d8e91d09e03e9a0c5ab)

### 28/10/2020 - Putting it all together
* Representations and behaviour, coming together
  * Behaviour
    * Conditional expressions
      * `if else`
    * Functions, revisited
      * Named parameters
      * Default parameters
      * __Composing__ functions with functions (i.e. functions that call other functions)
    * Repetition, introduction
      * Expressing repetition using `canvas.setInterval`
* Representations
  * Primitive types, revisited
    * Implicit and explicit type conversions
  * Introduction to mutations 
    * `var` vs `val`
    * Imposing a discipline on mutations (for now, only admissible in the main function)
  
For reference:
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=-S2WHawYf0c&list=PL8XxoCaL3dBgXjxTLx4Fm-uxTD8k-cXQA&index=7)
* [Code used to draw a growing explosion](https://gist.github.com/palbp/1d7bff47e83ce68e2c3f098c23b16092)

### 02/11/2020 - Coding session 
* Goal: Let's start to build our version of [Missile Command](https://en.wikipedia.org/wiki/Missile_Command)
* Using CanvasLib
  * [Documentation](https://github.com/CCISEL/CanvasLib/blob/master/docs/CanvasLib.pdf)
  * [Implementation on GitHub](https://github.com/CCISEL/CanvasLib)

For reference:
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=VocpJ9qoP4Q&list=PL8XxoCaL3dBgXjxTLx4Fm-uxTD8k-cXQA&index=8)
* [Coding challenge solution](https://gist.github.com/palbp/6b3766d45f5cec89877ff12e0bd0da1e)
* [Gist of the Code written during the session](https://gist.github.com/palbp/94ab93113c69d12e44dcef9d99231b31)

### 04/11/2020 - Representations and behaviour, revisited
* Goal: Let's continue to build our version of [Missile Command](https://en.wikipedia.org/wiki/Missile_Command)
* Setting up our MissileCommand project
  * Importing code from GitHub
* Representations, continued
  * Representing colors through RGB encoding
  * An introduction to numerical bases
    * Binary and hexadecimal
* Behaviour, continued
  * Conditional evaluation
    * `when` expression [documentation](https://kotlinlang.org/docs/reference/control-flow.html#when-expression)

For reference:
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=u0_1uoC6u74&list=PL8XxoCaL3dBgXjxTLx4Fm-uxTD8k-cXQA&index=9)

### 09/11/2020 - Practical class
* Practical class dedicated to the development of the first project assignement (the requirements are [here](assets/trab1Pg2021.pdf), in Portuguese)

### 11/11/2020 - Practical class
* Practical class dedicated to the development of the first project assignement (the requirements are [here](assets/trab1Pg2021.pdf), in Portuguese)

### 16/11/2020 - Coding session (subjects' review)
* Review of the most important subjects thusfar

For reference:
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=KOMjwYPTgho&list=PL8XxoCaL3dBgXjxTLx4Fm-uxTD8k-cXQA&index=10)

### 18/11/2020 - Kotlin type's system, revisited
* [Nullable types](https://kotlinlang.org/docs/reference/null-safety.html)
  * Motivation and consequences
  * Smart casts
  * Safe call operator
  * Elvis operator

For reference:
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=iFTEmryDOqE&list=PL8XxoCaL3dBgXjxTLx4Fm-uxTD8k-cXQA&index=11)

### 23/11/2020 - Higher Order Functions, introduction
* [Functions](https://kotlinlang.org/docs/reference/functions.html)
  * Global functions
  * Local functions
* [Functions as values: Higher Order Functions (HOF)](https://kotlinlang.org/docs/reference/lambdas.html)
  * Function types
  * Lambda expressions
  * Function references: operator `::`

For reference:
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=-_13jOIuyv4&list=PL8XxoCaL3dBgXjxTLx4Fm-uxTD8k-cXQA&index=12)

### 25/11/2020 - Collections: imutable lists
* Imutable lists
  * Motivation
  * Properties
* Expressing repetition through internal iteration: `forEach`
* List transformation operations: `filter` and `map`
 
For reference:
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=15RnUEbyDKE&list=PL8XxoCaL3dBgXjxTLx4Fm-uxTD8k-cXQA&index=13)

### 02/12/2020 - Coding session
* Review of the most important subjects thusfar
* Imutable lists, continued
  * Expanding lists: operator `+`
  * List transformation operations:`any`, `filterNotNull` and `mapNotNull`
 
For reference:
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=Z37Btp4eEvM&list=PL8XxoCaL3dBgXjxTLx4Fm-uxTD8k-cXQA&index=14)

### 09/12/2020 - Coding session
* Execution, revisited 
  * Expressions vs instructions
    * `if else` expression and instruction
    * `if` instruction
* Imutable lists, continued
  * Operator `-`

For reference:
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=u7Iu_il6DWY&list=PL8XxoCaL3dBgXjxTLx4Fm-uxTD8k-cXQA&index=15)

### 14/12/2020 - Evaluation
* Realization of the second individual evaluation form

### 16/12/2020 - Lists and functions, continued (preview)
* Immutable lists, continued
  * Reduction operations: `reduce` and `fold`
* Functions, continued
  * [Extension functions](https://kotlinlang.org/docs/reference/extensions.html)
  * [Operator overload](https://kotlinlang.org/docs/reference/operator-overloading.html)
* Coding session: Improving the Missile Command code base

For reference:
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=HANI7K7Qeg4&list=PL8XxoCaL3dBgXjxTLx4Fm-uxTD8k-cXQA&index=16)
* [Design smell: Primitive obsession](https://blog.ploeh.dk/2011/05/25/DesignSmellPrimitiveObsession/)

### 04/01/2021 - Immutability and mutability
* Using imutable data representations
  * Motivation and consequences
  * Demistifying the actual cost of immutability
  * Observation of memory consumption using [VisualVM](https://visualvm.github.io/download.html)
  * Notion of peak usage and working set
* Using mutable data representations
  * Motivation and consequences
  * A small incursion into the imperative programming style

For reference:
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=EyDzP8HNUAI&list=PL8XxoCaL3dBgXjxTLx4Fm-uxTD8k-cXQA&index=17)
* [Immutability we can afford](https://elizarov.medium.com/immutability-we-can-afford-10c0dcb8351d)

### 06/01/2021 - Practical class
* Practical class dedicated to the assesment of the second project assignment (the requirements are [here](assets/trab2Pg2021.pdf), in Portuguese)

### 11/01/2021 - The imperative style
* The imperative style
  * Main traits: mutations and state machines
  * Motivation and consequences of its use
* Support in Kotlin
  * Execution control
    * Selection
    * Repetition
  * `var`qualifier used in local values (a.k.a. local variables)
* Exercises

For reference:
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=D5IAjjjyw7A&list=PL8XxoCaL3dBgXjxTLx4Fm-uxTD8k-cXQA&index=18)
  
### 13/01/2021 - Practical class
* Practical class dedicated to the development of the third project assignment (the requirements are [here](assets/trab3Pg2021.pdf), in Portuguese)

### 18/01/2021 - The imperative style, continued
* Mutable lists and immutable lists 
* Exercises

For reference:
* [Lecture video (in Portuguese)](https://www.youtube.com/watch?v=YQDXHQuuSfk&list=PL8XxoCaL3dBgXjxTLx4Fm-uxTD8k-cXQA&index=19)

### 20/01/2021 - Conclusion
* Overview of the studied subjects 
* Looking ahead to the next programming subjects addressed in LEIC curricular programme

For reference:
* [Lecture video (in Portuguese)](#20012021---conclusion)
