package pacman.domain

/**
 * The maze dimensions
 */
const val MAZE_WIDTH = 28
const val MAZE_HEIGHT = 31

data class Coordinate(val row: Int, val column: Int)