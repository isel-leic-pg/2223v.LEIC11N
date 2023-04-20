package pacman

import pacman.domain.Coordinate
import pacman.domain.Direction
import pacman.domain.Hero
import pacman.domain.MAZE_HEIGHT
import pacman.domain.MAZE_WIDTH
import pacman.domain.Step
import pacman.domain.isFirst
import pacman.domain.move
import pacman.domain.next
import pacman.view.drawMaze
import pacman.view.redraw
import pt.isel.canvas.Canvas

/**
 * Represents the state of the game world
 */
data class World(
    val hero: Hero = Hero(at = Coordinate(row = MAZE_HEIGHT / 2, column = MAZE_WIDTH / 2), facing = Direction.UP),
    val step: Step = Step(current = 0, total = 2)
)

/**
 * Computes the next state of the world
 */
fun World.doStep(): World {
    val nextStep = step.next()
    return if (nextStep.isFirst()) {
        copy(hero = hero.move(), step = nextStep)
    } else copy(step = nextStep)
}

/**
 * Draws the world on this canvas
 */
fun Canvas.drawWorld(world: World) {
    erase()
    drawMaze()
    redraw(world.hero, world.step)
}

/**
 * Redraws the world on this canvas. This method is used to prevent drawing unchanged areas in
 * each frame.
 */
fun Canvas.redrawWorld(world: World) {
    redraw(world.hero, world.step)
}

