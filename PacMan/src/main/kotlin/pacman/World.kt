package pacman

import pacman.domain.Arena
import pacman.domain.Direction
import pacman.domain.Step
import pacman.domain.changeIntent
import pacman.domain.createArena
import pacman.domain.isFirst
import pacman.domain.isMoving
import pacman.domain.moveHero
import pacman.domain.next
import pacman.view.ANIMATION_STEP_COUNT
import pacman.view.SCALE
import pacman.view.SCALED_MAZE_VIEW_HEIGHT
import pacman.view.SCALED_MAZE_VIEW_WIDTH
import pacman.view.drawArena
import pacman.view.redraw
import pt.isel.canvas.BLACK
import pt.isel.canvas.Canvas

/**
 * Represents the state of the game world
 */
data class World(
    val arena: Arena = createArena(),
    val heroMovementStep: Step = Step(current = 0, total = SCALE.toInt()),
    val heroAnimationStep: Step = Step(current = 0, total = ANIMATION_STEP_COUNT)
)

/**
 * Computes the next state of the world
 */
fun World.doStep(): World {
    val nextStep =
        if (arena.pacMan.isMoving()) heroMovementStep.next()
        else heroMovementStep

    val nextAnimationStep =
        if (arena.pacMan.isMoving()) heroAnimationStep.next()
        else heroAnimationStep

    return copy(
        arena = if (nextStep.isFirst()) arena.moveHero() else arena,
        heroMovementStep = nextStep,
        heroAnimationStep = nextAnimationStep
    )
}

/**
 * Creates a new World where the hero's intent to move is given by the specified direction
 */
fun World.changeHeroIntent(to: Direction) =
    copy(arena = arena.copy(pacMan = arena.pacMan.changeIntent(to)))

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
    drawArena(world.arena)
    redraw(world.arena.pacMan, world.heroMovementStep, world.heroAnimationStep)
}

/**
 * Redraws the world on this canvas. This method is used to prevent drawing unchanged areas in
 * each frame.
 */
fun Canvas.redrawWorld(world: World) {
    if (world.arena.pacMan.isMoving())
        redraw(world.arena.pacMan, world.heroMovementStep, world.heroAnimationStep)
}
