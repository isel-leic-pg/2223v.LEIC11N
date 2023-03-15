package pacman.view

import pacman.domain.MAZE_HEIGHT
import pacman.domain.MAZE_WIDTH
import pt.isel.canvas.Canvas
import pt.isel.canvas.WHITE

/**
 * Dimension in pixels of the maze cell's sprites
 */
const val CELL_SIZE = 8

/**
 * Dimension in pixels of the maze visual materialization
 */
const val MAZE_VIEW_WIDTH = CELL_SIZE * MAZE_WIDTH
const val MAZE_VIEW_HEIGHT = CELL_SIZE * MAZE_HEIGHT

/**
 * The maze's scale factor
 */
const val SCALE = 2.5

const val SCALED_CELL_SIZE = (CELL_SIZE * SCALE).toInt()

/**
 * Draws a grid on the screen area represented by [canvas]
 */
fun drawGrid(canvas: Canvas) {
    for (index in 0 until MAZE_HEIGHT) {
        canvas.drawLine(
            xFrom = 0,
            yFrom = SCALED_CELL_SIZE * index,
            xTo = (MAZE_VIEW_WIDTH * SCALE).toInt(),
            yTo = SCALED_CELL_SIZE * index,
            color = WHITE,
            thickness = 1
        )
    }
    for (index in 0 until MAZE_WIDTH) {
        canvas.drawLine(
            xFrom = SCALED_CELL_SIZE * index,
            yFrom = 0,
            xTo = SCALED_CELL_SIZE * index,
            yTo = (MAZE_VIEW_HEIGHT * SCALE).toInt(),
            color = WHITE,
            thickness = 1
        )
    }
}

/**
 * Draws the maze on the screen area represented by [canvas]
 */
fun drawMaze(canvas: Canvas) {
    drawTopLine(canvas)
    drawBottomLine(canvas)
}

private fun drawBottomLine(canvas: Canvas) {
    val xIndex = 12
    val spriteX = xIndex * CELL_SIZE + xIndex
    val spriteY = 0
    for (column in 1 until MAZE_WIDTH - 1) {
        canvas.drawImage(
            "layout-sprite|$spriteX,$spriteY,$CELL_SIZE,$CELL_SIZE",
            xLeft = column * SCALED_CELL_SIZE,
            yTop = SCALED_CELL_SIZE * (MAZE_HEIGHT - 1),
            width = SCALED_CELL_SIZE,
            height = SCALED_CELL_SIZE
        )
    }

    val llcXIndex = 5
    val llcSpriteX = llcXIndex * CELL_SIZE + llcXIndex
    canvas.drawImage(
        "layout-sprite|$llcSpriteX,0,$CELL_SIZE,$CELL_SIZE",
        xLeft = 0,
        yTop = SCALED_CELL_SIZE * (MAZE_HEIGHT - 1),
        width = SCALED_CELL_SIZE,
        height = SCALED_CELL_SIZE
    )

    val lrcXIndex = 4
    val lrcSpriteX = lrcXIndex * CELL_SIZE + lrcXIndex
    canvas.drawImage(
        "layout-sprite|$lrcSpriteX,0,$CELL_SIZE,$CELL_SIZE",
        xLeft = SCALED_CELL_SIZE * (MAZE_WIDTH - 1),
        yTop = SCALED_CELL_SIZE * (MAZE_HEIGHT - 1),
        width = SCALED_CELL_SIZE,
        height = SCALED_CELL_SIZE
    )
}

private fun drawTopLine(canvas: Canvas) {
    val xIndex = 10
    val spriteX = xIndex * CELL_SIZE + xIndex
    val spriteY = 0
    for (column in 1 until MAZE_WIDTH - 1) {
        canvas.drawImage(
            "layout-sprite|$spriteX,$spriteY,$CELL_SIZE,$CELL_SIZE",
            xLeft = column * SCALED_CELL_SIZE,
            yTop = 0,
            width = SCALED_CELL_SIZE,
            height = SCALED_CELL_SIZE
        )
    }

    canvas.drawImage(
        "layout-sprite|${CELL_SIZE+1},0,$CELL_SIZE,$CELL_SIZE",
        xLeft = 0,
        yTop = 0,
        width = SCALED_CELL_SIZE,
        height = SCALED_CELL_SIZE
    )

    canvas.drawImage(
        "layout-sprite|0,0,$CELL_SIZE,$CELL_SIZE",
        xLeft = SCALED_CELL_SIZE * (MAZE_WIDTH - 1),
        yTop = 0,
        width = SCALED_CELL_SIZE,
        height = SCALED_CELL_SIZE
    )
}

private fun drawLayoutSprite(canvas: Canvas, line: Int, column: Int, screenPosition: Point) {
    TODO()
}