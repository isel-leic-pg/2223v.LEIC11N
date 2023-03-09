package pacman.view

import pacman.domain.Coordinate

/**
 * Dimension in pixels of the maze cell's sprites
 */
const val CELL_WIDTH = 8
const val CELL_HEIGHT = 8

/**
 * Represents coordinates on the screen and on the game's sprites
 */
data class Point(val x: Int, val y: Int)

/**
 * Converts the given maze coordinate to its respective [Point] instance.
 */
fun coordinateToPoint(at: Coordinate): Point {
    return Point(x = at.column * CELL_WIDTH, y = at.row * CELL_HEIGHT)
}