package pacman.domain

import java.nio.file.Files.move

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
fun Hero.move() = copy(at + facing)

/**
 * Makes the hero face the specified direction
 */
fun Hero.face(to: Direction) = copy(facing = to)

/**
 * Moves the hero in the specified direction
 */
fun Hero.moveBy(to: Direction) = face(to).move()
