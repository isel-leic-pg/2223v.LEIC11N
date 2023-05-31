package pacman.view

import pacman.FPS
import pacman.domain.Arena
import pacman.domain.Cell
import pacman.domain.Step
import pacman.domain.hasPellet
import pacman.domain.isMoving
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

fun Canvas.redrawArena(arena: Arena, frameNumber: Int, heroAnimationStep: Step) {

    clear(arena.ghosts)
    redrawPellets(arena)
    arena.powerPelletsLocations.forEach {
        if (frameNumber % FPS == 0) drawPowerPellet(this, coordinateToPoint(it, SCALE))
        else if (frameNumber % (FPS / 2) == 0) eraseCell(coordinateToPoint(it, SCALE))
    }
    redraw(arena.pacMan, frameNumber, heroAnimationStep)
    draw(arena.ghosts, frameNumber)
}

fun Canvas.redrawPellets(arena: Arena) {
    arena.ghosts
        .map { it.previouslyAt }
        .forEach {
            if (arena.maze.hasPellet(it)) {
                drawPellet(this, coordinateToPoint(it, SCALE))
            }
        }
}