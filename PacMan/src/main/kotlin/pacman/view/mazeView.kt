package pacman.view

import pacman.domain.MAZE_HEIGHT
import pacman.domain.MAZE_WIDTH
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
fun Canvas.drawMaze() {
    for (column in 1 until MAZE_WIDTH - 1) {
        // Top Line
        drawLayoutSprite(this, line = 0, column = 11, screenPosition = Point(CELL_SIZE * column, y = 0))
        // Bottom Line
        drawLayoutSprite(this, line = 0, column = 12, screenPosition = Point(CELL_SIZE * column, y = SCALED_MAZE_VIEW_HEIGHT - CELL_SIZE))
    }

    for (line in 1 until MAZE_HEIGHT - 1) {
        // Left line
        drawLayoutSprite(this, line = 0, column = 3, screenPosition = Point(x = 0, y = CELL_SIZE * line))
        // Right line
        drawLayoutSprite(this, line = 0, column = 2, screenPosition = Point(x = SCALED_MAZE_VIEW_WIDTH - CELL_SIZE, y = CELL_SIZE * line))
    }

    // Top corners
    drawLayoutSprite(this, line = 0, column = 1, screenPosition = Point(0, 0))
    drawLayoutSprite(this, line = 0, column = 0, screenPosition = Point(SCALED_MAZE_VIEW_WIDTH - CELL_SIZE, 0))

    // Bottom corners
    drawLayoutSprite(this, line = 0, column = 5, screenPosition = Point(0, SCALED_MAZE_VIEW_HEIGHT - CELL_SIZE))
    drawLayoutSprite(this, line = 0, column = 4, screenPosition = Point(SCALED_MAZE_VIEW_WIDTH - CELL_SIZE, SCALED_MAZE_VIEW_HEIGHT - CELL_SIZE))
}


/**
 * Draws the sprite located at [line] and [column] on the layout sprite sheet on the given [screenPosition]
 */
private fun drawLayoutSprite(canvas: Canvas, line: Int, column: Int, screenPosition: Point) {
    val spriteX = column * LAYOUT_SPRITE_SIZE + column
    val spriteY = line * LAYOUT_SPRITE_SIZE + line
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
