package pacman.view

import pacman.domain.Coordinate

/**
 * Represents coordinates on the screen and on the game's sprites
 */
data class Point(val x: Int, val y: Int)

/**
 * Converts the given maze coordinate to its respective [Point] instance.
 */
fun coordinateToPoint(at: Coordinate, scale: Double = 1.0) =
    Point(x = (at.column * CELL_SIZE * scale).toInt(), y = (at.row * CELL_SIZE * scale).toInt())
