package pacman.view

import pt.isel.canvas.BLACK
import pt.isel.canvas.Canvas

/**
 * The size of each element in the actors sprite sheet (see resources/actors-sprite.png)
 * Note that there are larger elements on the sprite sheet, but they are not in use.
 */
const val ACTORS_SPRITE_SIZE = 16

/**
 * The scaled actor size on the screen
 */
const val ACTOR_SIZE = (ACTORS_SPRITE_SIZE * SCALE).toInt()

/**
 * Actors are drawn using an offset, so they seem to closely fit the arena's corridors
 */
val actorsOffset = Point(x = CELL_SIZE / 2, y = CELL_SIZE / 2)

/**
 * The information needed to select a sprite on the actor's sprite sheet (see resources/actors-sprite.png)
 */
data class SpriteInfo(val sheetRow: Int, val sheetColumn: Int)

/**
 * Clears the area occupied by an actor on the canvas.
 */
fun Canvas.clearActorArea(arenaPosition: Point) {
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
 * Draws the actor sprite specified by its coordinates on the sprite sheet (see resources/actors-sprite.png) at the given
 * position on the arena.
 *
 * @param canvas            the canvas where to draw
 * @param arenaPosition     the position on the arena where to draw the sprite
 */
fun drawActorSprite(canvas: Canvas, spriteAt: SpriteInfo, arenaPosition: Point) {
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
