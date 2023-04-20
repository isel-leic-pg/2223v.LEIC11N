package pacman.view

import pacman.domain.Direction
import pacman.domain.Hero
import pacman.domain.Step
import pacman.domain.isMoving
import pt.isel.canvas.BLACK
import pt.isel.canvas.Canvas

/**
 * Draws the hero on this canvas, clearing the canvas on the previous hero position.
 * @param hero the hero to be drawn
 * @param step the movement step (used to determine the hero's position on the canvas)
 */
fun Canvas.redraw(hero: Hero, step: Step) {

    val spriteInfo = computeSpriteInfo(hero)

    val scaledStepDelta = computeMovementStepDelta(step)
    val (deltaX, deltaY) = if (hero.isMoving()) {
        when (hero.facing) {
            Direction.RIGHT -> Pair(-scaledStepDelta, 0)
            Direction.LEFT -> Pair(scaledStepDelta, 0)
            Direction.UP -> Pair(0, scaledStepDelta)
            Direction.DOWN -> Pair(0, -scaledStepDelta)
        }
    } else Pair(0, 0)

    val positionInArena = Point(
        x = Integer.max(hero.at.column * CELL_SIZE - actorsOffset.x + deltaX, 0),
        y = Integer.max(hero.at.row * CELL_SIZE - actorsOffset.y + deltaY, 0)
    )

    val previousPositionInArena = Point(
        x = Integer.max(hero.previouslyAt.column * CELL_SIZE - actorsOffset.x, 0),
        y = Integer.max(hero.previouslyAt.row * CELL_SIZE - actorsOffset.y, 0)
    )

    clearHeroArea(previousPositionInArena)
    clearHeroArea(positionInArena)
    drawHeroSprite(this, spriteInfo, positionInArena)
}

/**
 * The size of each element in the actors sprite sheet (see resources/actors-sprite.png)
 * Note that there are larger elements on the sprite sheet, but they are not in use.
 */
private const val ACTORS_SPRITE_SIZE = 16

/**
 * The scaled actor size on the screen
 */
private const val ACTOR_SIZE = (ACTORS_SPRITE_SIZE * SCALE).toInt()

/**
 * Actors are drawn using an offset, so they seem to closely fit the arena's corridors
 */
private val actorsOffset = Point(x = CELL_SIZE / 2, y = CELL_SIZE / 2)

/**
 * Clears the area occupied by the hero on the canvas.
 */
private fun Canvas.clearHeroArea(arenaPosition: Point) {
    val correction = (SCALE * 2).toInt()
    drawRect(
        arenaPosition.x + correction / 2,
        arenaPosition.y + correction / 2,
        ACTOR_SIZE - correction,
        ACTOR_SIZE - correction,
        BLACK
    )
}

/**
 * Draws the hero sprite specified by its coordinates on the sprite sheet (see resources/actors-sprite.png) at the given
 * position on the arena.
 *
 * @param canvas            the canvas where to draw
 * @param arenaPosition     the position on the arena where to draw the sprite
 */
private fun drawHeroSprite(canvas: Canvas, spriteAt: SpriteInfo, arenaPosition: Point) {
    val originInSprite = Point(
        x = spriteAt.sheetColumn * ACTORS_SPRITE_SIZE,
        y = spriteAt.sheetRow * ACTORS_SPRITE_SIZE
    )

    val spriteInfo = "${originInSprite.x},${originInSprite.y},$ACTORS_SPRITE_SIZE,$ACTORS_SPRITE_SIZE"
    canvas.drawImage(
        fileName = "actors-sprite-t|$spriteInfo",
        xLeft = arenaPosition.x,
        yTop = arenaPosition.y,
        width = ACTOR_SIZE,
        height = ACTOR_SIZE
    )
}

/**
 * Computes the scaled step delta (used to determine the hero's position on the canvas). Returns the variation of the
 * step, in pixels, that should be applied to the actor's position. Note that the actor has already actually moved
 * (its hit box has already changed), but the animation is still in progress, so the actor is not yet in its final
 * position on the screen. This is only accomplished in the last step of the animation.
 */
internal fun computeMovementStepDelta(step: Step): Int {
    val stepSize = CELL_SIZE / step.total
    return CELL_SIZE - ((step.current + 1) * stepSize)
}

/**
 * Computes the location of the sprite on the hero's sprite sheet (see resources/actors-sprite.png).
 */
internal fun computeSpriteInfo(hero: Hero): SpriteInfo {

    val spriteSheetColumn = 1

    val spriteSheetRow = when (hero.facing) {
        Direction.RIGHT -> 0
        Direction.LEFT -> 1
        Direction.UP -> 2
        Direction.DOWN -> 3
    }

    return SpriteInfo(spriteSheetRow, spriteSheetColumn)
}

/**
 * The information needed to select a sprite on the hero's sprite sheet (see resources/actors-sprite.png)
 */
internal data class SpriteInfo(val sheetRow: Int, val sheetColumn: Int)
