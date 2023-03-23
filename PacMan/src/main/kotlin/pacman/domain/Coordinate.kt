package pacman.domain

/**
 * The maze dimensions
 */
const val MAZE_WIDTH = 28
const val MAZE_HEIGHT = 31

/**
 * Represents coordinates on the maze
 */
data class Coordinate(val row: Int, val column: Int)

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
operator fun Coordinate.plus(direction: Direction): Coordinate {
    val newCoordinate = when (direction) {
        Direction.UP -> copy(row = row - 1)
        Direction.DOWN -> copy(row = row + 1)
        Direction.LEFT -> copy(column = column - 1)
        Direction.RIGHT -> copy(column = column + 1)
    }
    return if (newCoordinate.isValid()) newCoordinate else this
}

fun Coordinate.isValid(): Boolean =
    row >= 1 && row < MAZE_HEIGHT - 1 && column >= 1 && column < MAZE_WIDTH - 1
