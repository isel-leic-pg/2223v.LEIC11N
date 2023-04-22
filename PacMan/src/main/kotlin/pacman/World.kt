package pacman

import pacman.domain.Coordinate
import pacman.domain.Direction
import pacman.domain.Hero
import pacman.domain.MAZE_HEIGHT
import pacman.domain.MAZE_WIDTH
import pacman.domain.Step
import pacman.domain.changeIntent
import pacman.domain.isFirst
import pacman.domain.isMoving
import pacman.domain.move
import pacman.domain.next
import pacman.view.ANIMATION_STEP_COUNT
import pacman.view.SCALE
import pacman.view.SCALED_MAZE_VIEW_HEIGHT
import pacman.view.SCALED_MAZE_VIEW_WIDTH
import pacman.view.drawMaze
import pacman.view.redraw
import pt.isel.canvas.BLACK
import pt.isel.canvas.Canvas

/**
 * Represents the state of the game world
 */
data class World(
    val hero: Hero = Hero(at = Coordinate(row = MAZE_HEIGHT / 2, column = MAZE_WIDTH / 2), facing = Direction.UP),
    val heroMovementStep: Step = Step(current = 0, total = SCALE.toInt()),
    val heroAnimationStep: Step = Step(current = 0, total = ANIMATION_STEP_COUNT)
)

/**
 * Computes the next state of the world
 */
fun World.doStep(): World {
    val nextStep = heroMovementStep.next()
    val nextAnimationStep =
        if (hero.isMoving()) heroAnimationStep.next()
        else heroAnimationStep

    return copy(
        hero = if (nextStep.isFirst()) hero.move() else hero,
        heroMovementStep = nextStep,
        heroAnimationStep = nextAnimationStep
    )
}

/**
 * Creates a new World where the hero's intent to move is given by the specified direction
 */
fun World.changeHeroIntent(to: Direction) = copy(hero = hero.changeIntent(to))

/**
 * Creates a canvas to draw the world
 */
fun createWorldCanvas() = Canvas(
    width = SCALED_MAZE_VIEW_WIDTH,
    height = SCALED_MAZE_VIEW_HEIGHT,
    background = BLACK
)

/**
 * Draws the world on this canvas
 */
fun Canvas.drawWorld(world: World) {
    erase()
    drawMaze()
    redraw(world.hero, world.heroMovementStep, world.heroAnimationStep)
}

/**
 * Redraws the world on this canvas. This method is used to prevent drawing unchanged areas in
 * each frame.
 */
fun Canvas.redrawWorld(world: World) {
    if (world.hero.isMoving())
        redraw(world.hero, world.heroMovementStep, world.heroAnimationStep)
}

