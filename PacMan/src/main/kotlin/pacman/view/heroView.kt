package pacman.view

import pacman.domain.Direction
import pacman.domain.Hero
import pt.isel.canvas.Canvas

/**
 * Dimension in pixels of the hero's sprites
 */
const val HERO_SIZE = CELL_SIZE * 2

const val SCALED_HERO_SIZE = (HERO_SIZE * SCALE).toInt()

/**
 * Draws the given [hero] on the screen area represented by [canvas]
 */
fun Canvas.drawHero(hero: Hero) {
    val position = coordinateToPoint(hero.at, SCALE)
    val spriteColumn = 1
    val spriteLine = when (hero.facing) {
        Direction.RIGHT -> 0
        Direction.LEFT -> 1
        Direction.UP -> 2
        Direction.DOWN -> 3
    }
    drawHeroSprite(this, spriteLine, spriteColumn, position)
}

/**
 * Draws the sprite located at [line] and [column] on the hero sprite sheet on the given screen [position]
 */
private fun drawHeroSprite(canvas: Canvas, line: Int, column: Int, position: Point) {
    val spriteX = column * HERO_SIZE
    val spriteY = line * HERO_SIZE
    canvas.drawImage(
        "actors-sprite|$spriteX,$spriteY,$HERO_SIZE,$HERO_SIZE",
        xLeft = position.x - SCALED_CELL_SIZE / 2,
        yTop = position.y - SCALED_CELL_SIZE / 2,
        width = SCALED_HERO_SIZE,
        height = SCALED_HERO_SIZE
    )
}
