package pacman.view

import pacman.domain.Coordinate

/**
 * Represents coordinates on the screen and on the game's sprites
 */
data class Point(val x: Int, val y: Int)

/**
 * Converts the given maze coordinate to its respective [Point] instance.
 */
fun coordinateToPoint(at: Coordinate, scale: Double = SCALE) =
    Point(x = (at.column * LAYOUT_SPRITE_SIZE * scale).toInt(), y = (at.row * LAYOUT_SPRITE_SIZE * scale).toInt())
