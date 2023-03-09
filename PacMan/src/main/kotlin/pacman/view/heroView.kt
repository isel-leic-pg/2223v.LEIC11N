package pacman.view

import pacman.domain.Hero
import pt.isel.canvas.Canvas

/**
 * Dimension in pixels of the hero's sprites
 */
const val HERO_SIZE = CELL_SIZE * 2

/**
 * Draws the given [hero] on the screen area represented by [canvas]
 */
fun drawHero(canvas: Canvas, hero: Hero) {
    val position = coordinateToPoint(hero.at, SCALE)
    canvas.drawImage(
        fileName = "actors-sprite|$HERO_SIZE,0,$HERO_SIZE,$HERO_SIZE",
        xLeft = position.x - SCALED_CELL_SIZE / 2,
        yTop = position.y - SCALED_CELL_SIZE / 2,
        width = (HERO_SIZE * SCALE).toInt(),
        height = (HERO_SIZE * SCALE).toInt()
    )
}
