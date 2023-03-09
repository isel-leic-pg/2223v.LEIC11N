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
    for (index in 0 until  MAZE_HEIGHT) {
        canvas.drawLine(
            xFrom = 0,
            yFrom = SCALED_CELL_SIZE * index,
            xTo = (MAZE_VIEW_WIDTH * SCALE).toInt(),
            yTo = SCALED_CELL_SIZE * index,
            color = WHITE,
            thickness = 1
        )
    }
    for (index in 0 until  MAZE_WIDTH) {
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