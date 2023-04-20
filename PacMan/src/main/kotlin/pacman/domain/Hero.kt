package pacman.domain

/**
 * Represents the hero, Pac-Man
 */
data class Hero(
    val at: Coordinate,
    val facing: Direction,
    val intent: Direction = facing,
    val previouslyAt: Coordinate = at
)

/**
 * Moves the hero in the direction he is facing
 */
fun Hero.move() = copy(at = at + facing, facing = intent, previouslyAt = at)

/**
 * Makes the hero face the specified direction
 */
fun Hero.face(to: Direction) = copy(facing = to)

/**
 * Changes the hero's intent to move in the specified direction
 */
fun Hero.changeIntent(to: Direction) = copy(intent = to)

/**
 * Returns true if the hero is moving. False otherwise.
 */
fun Hero.isMoving() = at != previouslyAt
