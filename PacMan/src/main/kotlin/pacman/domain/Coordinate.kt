package pacman.domain

/**
 * Represents coordinates on the maze
 */
data class Coordinate(val row: Int, val column: Int)

/**
 * Converts an integer to a coordinate
 */
fun Int.toCoordinate() = Coordinate(row = this / MAZE_WIDTH, column = this % MAZE_WIDTH)

/**
 * Represents the directions in which the hero can move
 */
enum class Direction {
    UP, DOWN, LEFT, RIGHT
}

/**
 * Adds to this coordinate the position variation determined by [direction]. If the resulting
 * coordinate is outside the maze, the original coordinate is returned.
 */
operator fun Coordinate.plus(direction: Direction) = when (direction) {
        Direction.UP -> copy(row = if (row == 0) MAZE_HEIGHT - 1 else row - 1)
        Direction.DOWN -> copy(row = (row + 1) % MAZE_HEIGHT)
        Direction.LEFT -> copy(column = if (column == 0) MAZE_WIDTH - 1 else column - 1)
        Direction.RIGHT -> copy(column = (column + 1) % MAZE_WIDTH)
    }
