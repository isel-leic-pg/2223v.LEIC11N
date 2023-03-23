package pacman.domain

/**
 * Represents the hero, Pac-Man
 */
data class Hero(
    val at: Coordinate,
    val facing: Direction
)

/**
 * Moves the hero in the direction he is facing
 */
fun move(hero: Hero) =
    hero.copy(at = add(coordinate = hero.at, direction = hero.facing))

/**
 * Makes the hero face the specified direction.
 */
fun face(hero: Hero, to: Direction) =
    hero.copy(facing = to)

fun moveBy(hero: Hero, to: Direction) = move(face(hero, to))
