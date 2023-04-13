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
 * Computes the delta in pixels to be applied to the hero's position in order to animate the movement.
 */
internal fun computeAnimationDelta(step: AnimationStep): Int {
    val stepSize = SCALED_CELL_SIZE / step.total
    return SCALED_CELL_SIZE - ((step.current + 1) * stepSize)
}


internal fun computeAnimationDelta(step: AnimationStep, facing: Direction): Point {
    return when (facing) {
        Direction.RIGHT -> Point(x = -computeAnimationDelta(step), y = 0)
        Direction.LEFT -> Point(x = computeAnimationDelta(step), y = 0)
        Direction.UP -> Point(x = 0, y = computeAnimationDelta(step))
        Direction.DOWN -> Point(x = 0, y = -computeAnimationDelta(step))
    }
}

/**
 * Draws the given [hero] on the screen area represented by [canvas]
 */
fun Canvas.drawHero(hero: Hero, step: AnimationStep) {
    val position = coordinateToPoint(hero.at, SCALE)
    val delta = computeAnimationDelta(step = step, facing = hero.facing)

    val adjustedPosition = Point(x = position.x + delta.x, y = position.y + delta.y)
    val spriteColumn = 1
    val spriteLine = when (hero.facing) {
        Direction.RIGHT -> 0
        Direction.LEFT -> 1
        Direction.UP -> 2
        Direction.DOWN -> 3
    }
    println("Hero is at ${hero.at} and facing ${hero.facing}")
    println("Step is $step")
    println("Original position is $position")
    println("Drawing hero at $adjustedPosition")
    drawHeroSprite(this, spriteLine, spriteColumn, adjustedPosition)
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
