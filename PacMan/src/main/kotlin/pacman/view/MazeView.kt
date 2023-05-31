package pacman.view

import pacman.FPS
import pacman.domain.Arena
import pacman.domain.Cell
import pacman.domain.toCoordinate
import pacman.domain.toInt
import pt.isel.canvas.Canvas

/**
 * Draws the maze on the screen area represented by this canvas.
 */
fun Canvas.drawArena(arena: Arena) {
    drawLayout()
    arena.maze.forEachIndexed { index, cell ->
        if (cell == Cell.PELLET) {
            drawPellet(this, coordinateToPoint(index.toCoordinate(), SCALE))
        }
        else if (cell == Cell.POWER_PELLET) {
            drawPowerPellet(this, coordinateToPoint(index.toCoordinate(), SCALE))
        }
    }
}

fun Canvas.redrawArena(arena: Arena, frameNumber: Int) {
    arena.powerPelletsLocations.forEach {
        if (frameNumber % FPS == 0) drawPowerPellet(this, coordinateToPoint(it, SCALE))
        else if (frameNumber % (FPS / 2) == 0) eraseCell(coordinateToPoint(it, SCALE))
    }
}