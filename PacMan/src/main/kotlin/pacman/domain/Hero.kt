package pacman.domain

enum class Direction {
    UP, DOWN, LEFT, RIGHT
}

/**
 * Represents the hero, Pac-Man
 */
data class Hero(
    val at: Coordinate,
    val facing: Direction
)
