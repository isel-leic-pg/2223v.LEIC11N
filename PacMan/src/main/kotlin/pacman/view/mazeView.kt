package pacman.view

import pacman.domain.Arena
import pacman.domain.Cell
import pacman.domain.toCoordinate
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
