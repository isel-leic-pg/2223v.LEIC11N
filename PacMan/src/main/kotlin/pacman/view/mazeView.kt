package pacman.view

import pacman.domain.Arena
import pacman.domain.Cell
import pacman.domain.MAZE_HEIGHT
import pacman.domain.MAZE_WIDTH
import pacman.domain.toCoordinate
import pt.isel.canvas.Canvas
import pt.isel.canvas.WHITE

/**
 * Dimension in pixels of the maze cell's sprites
 */
const val LAYOUT_SPRITE_SIZE = 8

/**
 * The maze's scale factor
 */
const val SCALE = 2.0

const val CELL_SIZE = (LAYOUT_SPRITE_SIZE * SCALE).toInt()
const val SCALED_MAZE_VIEW_WIDTH = CELL_SIZE * MAZE_WIDTH
const val SCALED_MAZE_VIEW_HEIGHT = CELL_SIZE * MAZE_HEIGHT

/**
 * Draws the maze on the screen area represented by [canvas]
 */
fun Canvas.drawMaze(arena: Arena) {
    layoutSpritesCoordinates.forEach {
        drawLayoutSprite(this, it.originInSprite, it.originInArena)
    }

    arena.maze.forEachIndexed { index, elem ->
        if (elem == Cell.PELLET)
            drawPellet(this, coordinateToPoint(index.toCoordinate(), SCALE))
        else if (elem == Cell.POWER_PELLET)
            drawPowerPellet(this, coordinateToPoint(index.toCoordinate(), SCALE))
    }
}

internal fun drawPellet(canvas: Canvas, at: Point) {
    drawLayoutSprite(canvas, PELLET_SPRITE_CODE.toPoint(), at)
}

internal fun drawPowerPellet(canvas: Canvas, at: Point) {
    drawLayoutSprite(canvas, POWER_PELLET_SPRITE_CODE.toPoint(), at)
}

/**
 * Draws on the given [screenPosition] the sprite located at [spritePosition] of the layout sprite sheet
 */
internal fun drawLayoutSprite(canvas: Canvas, spritePosition: Point, screenPosition: Point) {
    val spriteX = spritePosition.x
    val spriteY = spritePosition.y
    canvas.drawImage(
        "layout-sprite|$spriteX,$spriteY,$LAYOUT_SPRITE_SIZE,$LAYOUT_SPRITE_SIZE",
        xLeft = screenPosition.x,
        yTop = screenPosition.y,
        width = CELL_SIZE,
        height = CELL_SIZE
    )
}

/**
 * Draws a grid on the screen area represented by [canvas]
 */
private fun drawGrid(canvas: Canvas) {
    for (index in 0 until MAZE_HEIGHT) {
        canvas.drawLine(
            xFrom = 0,
            yFrom = CELL_SIZE * index,
            xTo = SCALED_MAZE_VIEW_WIDTH,
            yTo = CELL_SIZE * index,
            color = WHITE,
            thickness = 1
        )
    }
    for (index in 0 until MAZE_WIDTH) {
        canvas.drawLine(
            xFrom = CELL_SIZE * index,
            yFrom = 0,
            xTo = CELL_SIZE * index,
            yTo = SCALED_MAZE_VIEW_HEIGHT,
            color = WHITE,
            thickness = 1
        )
    }
}
