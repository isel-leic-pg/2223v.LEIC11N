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
fun Hero.move(maze: List<Cell>): Hero {
    val newPositionChangedDirection = at + intent
    val intendedIndex = newPositionChangedDirection.column + newPositionChangedDirection.row * MAZE_WIDTH
    if (maze[intendedIndex] == Cell.EMPTY)
        return copy(at = newPositionChangedDirection, previouslyAt = at, facing = intent)

    val newPositionSameDirection = at + facing
    val facingIndex = newPositionSameDirection.column + newPositionSameDirection.row * MAZE_WIDTH
    return if (maze[facingIndex] == Cell.EMPTY)
        copy(at = newPositionSameDirection, previouslyAt = at)
    else
        copy(facing = intent, previouslyAt = at)
}

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
