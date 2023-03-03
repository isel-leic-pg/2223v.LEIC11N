package pacman

import pacman.domain.Coordinate
import pacman.domain.Hero

fun main() {
    val origin = Coordinate(row = 0, column = 0)
    val other = Coordinate(row = 1, column = 1)

    val hero = Hero(at = origin)
    println(hero)
    println(hero.at)
    println(hero.at.row)
    println(hero.at.column)
}