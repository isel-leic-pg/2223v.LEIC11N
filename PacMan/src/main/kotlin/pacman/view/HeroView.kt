package pacman.view

import pacman.domain.Direction
import pacman.domain.Hero
import pacman.domain.Step
import pacman.domain.isMoving
import pt.isel.canvas.BLACK
import pt.isel.canvas.Canvas

/**
 * The number of animation steps for the hero.
 */
const val ANIMATION_STEP_COUNT = 8

/**
 * The number of frames that are required so that the hero moves one cell.
 */
const val FRAMES_PER_HERO_MOVE = SCALE.toInt() * 2

/**
 * Draws the hero on this canvas, clearing the canvas on the previous hero position.
 * @param hero the hero to be drawn
 * @param frameNumber the current frame number. Used to determine the relative position of
 * the hero's sprite in the canvas with resct to the center of the cell.
 * @param animationStep the animation step (used to determine the hero's sprite)
 */
fun Canvas.redraw(hero: Hero, frameNumber: Int, animationStep: Step) {

    val spriteInfo = computeSpriteInfo(hero, animationStep)

    val scaledStepDelta = computeMovementStepDelta(frameNumber)
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

    clearActorArea(previousPositionInArena)
    clearActorArea(positionInArena)
    drawActorSprite(this, spriteInfo, positionInArena)
}


/**
 * Computes the scaled step delta (used to determine the hero's position on the canvas). Returns the variation of the
 * step, in pixels, that should be applied to the actor's position. Note that the actor has already actually moved
 * (its hit box has already changed), but the animation is still in progress, so the actor is not yet in its final
 * position on the screen. This is only accomplished in the last step of the animation.
 */
internal fun computeMovementStepDelta(frameNumber: Int): Int {
    val stepSize = CELL_SIZE / FRAMES_PER_HERO_MOVE
    return CELL_SIZE - (((frameNumber % FRAMES_PER_HERO_MOVE) + 1) * stepSize)
}

/**
 * Computes the location of the sprite on the hero's sprite sheet (see resources/actors-sprite.png).
 */
internal fun computeSpriteInfo(hero: Hero, animationStep: Step): SpriteInfo {

    val spriteSheetColumn = when (animationStep.current) {
        0, 1 -> 2
        4, 5 -> 0
        else -> 1
    }

    val spriteSheetRow =
        if (spriteSheetColumn == 2) 0
        else when (hero.facing) {
            Direction.RIGHT -> 0
            Direction.LEFT -> 1
            Direction.UP -> 2
            Direction.DOWN -> 3
        }

    return SpriteInfo(spriteSheetRow, spriteSheetColumn)
}
