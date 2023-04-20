package pacman.domain

/**
 * Used to represent the passage of time. Game actions take place in steps. The total number of steps determines the
 * time it takes for an action to complete.
 *
 * @param current the current step
 * @param total the total number of steps
 */
data class Step(val current: Int, val total: Int)

/**
 * Returns the next step.
 */
fun Step.next() = Step((current + 1) % total, total)

/**
 * Returns true if this is the first step of the action.
 */
fun Step.isFirst() = current == 0
