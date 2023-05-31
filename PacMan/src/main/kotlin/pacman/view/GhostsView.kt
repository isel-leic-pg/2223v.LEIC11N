package pacman.view

import pacman.domain.Direction
import pacman.domain.Ghost
import pt.isel.canvas.Canvas

/**
 * The number of frames per ghost move. The ghost moves one cell per move.
 */
const val FRAMES_PER_GHOST_MOVE = SCALE.toInt() * 3


/**
 * Clears the canvas on the ghost's last position
 */
fun Canvas.clear(ghost: Ghost) {
    val previousPositionInArena = Point(
        x = Integer.max(ghost.previouslyAt.column * CELL_SIZE - actorsOffset.x, 0),
        y = Integer.max(ghost.previouslyAt.row * CELL_SIZE - actorsOffset.y, 0)
    )
    clearActorArea(previousPositionInArena)
}

/**
 * Draws the ghost on this canvas, clearing the canvas on the previous ghost position.
 * @param ghost the ghost to be drawn
 * @param frameNumber the current frame number. Used to determine the relative position of
 * the hero's sprite in the canvas with respect to the center of the cell.
 */
fun Canvas.draw(ghost: Ghost, frameNumber: Int) {

    val spriteInfo = computeSpriteInfo(ghost, frameNumber)

    val positionInArena = Point(
        x = Integer.max(ghost.at.column * CELL_SIZE - actorsOffset.x, 0),
        y = Integer.max(ghost.at.row * CELL_SIZE - actorsOffset.y, 0)
    )

    clearActorArea(positionInArena)
    drawActorSprite(this, spriteInfo, positionInArena)
}

/**
 * Computes the location of the ghost's sprite on the actor's sprite sheet (see resources/sprites/actors.png).
 */
internal fun computeSpriteInfo(ghost: Ghost, frameNumber: Int): SpriteInfo {
    val ghostsInitialSpriteRow = 4
    val spriteSheetRow = ghostsInitialSpriteRow + ghost.id.ordinal

    val spriteSheetColumn = when (ghost.facing) {
        Direction.RIGHT -> 0
        Direction.LEFT -> 2
        Direction.UP -> 4
        Direction.DOWN -> 6
    }

    return SpriteInfo(spriteSheetRow, spriteSheetColumn)
}

/**
 * Draws the given ghosts in the canvas.
 */
fun Canvas.draw(ghosts: List<Ghost>, frameNumber: Int) {
    ghosts.forEach { draw(it, frameNumber) }
}

/**
 * Clears the given ghosts in the canvas.
 */
fun Canvas.clear(ghosts: List<Ghost>) {
    ghosts.forEach { clear(it) }
}