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

enum class Direction {
    UP, DOWN, LEFT, RIGHT
}

/**
 * Adds to [coordinate] the position variation determined by [direction]
 */
fun add(coordinate: Coordinate, direction: Direction) =
    when (direction) {
        Direction.UP ->
            if (coordinate.row != 1) coordinate.copy(row = coordinate.row - 1)
            else coordinate
        Direction.DOWN ->
            if (coordinate.row != MAZE_HEIGHT - 2) coordinate.copy(row = coordinate.row + 1)
            else coordinate
        Direction.LEFT ->
            if (coordinate.column != 1) coordinate.copy(column = coordinate.column - 1)
            else coordinate
        Direction.RIGHT ->
            if (coordinate.column != MAZE_WIDTH - 2) coordinate.copy(column = coordinate.column + 1)
            else coordinate
    }

