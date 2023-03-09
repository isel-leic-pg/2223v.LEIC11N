package pacman

import pacman.domain.Coordinate
import pacman.domain.Hero
import pacman.view.coordinateToPoint

fun main() {
    val hero = Hero(at = Coordinate(row = 5, column = 7))
    val ghostPosition = Coordinate(row = 3, column = 7)

    val heroAtScreen = coordinateToPoint(hero.at)
    val ghostAtScreen = coordinateToPoint(ghostPosition)

    println(heroAtScreen)
    println(ghostAtScreen)
}