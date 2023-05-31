package pacman

import pacman.domain.ArenaState
import pacman.domain.Direction
import pacman.domain.GhostId
import pacman.domain.HeroAction
import pacman.domain.Step
import pacman.domain.addNextGhost
import pacman.domain.changeIntent
import pacman.domain.createArena
import pacman.domain.isMoving
import pacman.domain.move
import pacman.domain.moveGhosts
import pacman.domain.moveHero
import pacman.domain.next
import pacman.view.ANIMATION_STEP_COUNT
import pacman.view.FRAMES_PER_GHOST_MOVE
import pacman.view.FRAMES_PER_HERO_MOVE
import pacman.view.SCALED_MAZE_VIEW_HEIGHT
import pacman.view.SCALED_MAZE_VIEW_WIDTH
import pacman.view.draw
import pacman.view.drawArena
import pacman.view.redraw
import pacman.view.redrawArena
import pt.isel.canvas.BLACK
import pt.isel.canvas.Canvas

const val SCATTER_MODE_DURATION = FPS * 8
const val SECONDS_BETWEEN_GHOSTS = 8

/**
 * Represents the state of the game world
 */
data class World(
    val arenaState: ArenaState = ArenaState(arena = createArena(), action = HeroAction.MOVE),
    val frameNumber: Int = 0,
    val scatterModeEnd: Int? = null,
    val heroAnimationStep: Step = Step(current = 0, total = ANIMATION_STEP_COUNT)
)

/**
 * Computes the next state of the world
 */
fun World.doStep(): World {

    val nextFrameNumber = frameNumber + 1

    val arenaStateAfterAddGhost = maybeAddGhost(arenaState, nextFrameNumber)

    val arenaAfterGhostsMove =
        if (nextFrameNumber % FRAMES_PER_GHOST_MOVE == 0) arenaStateAfterAddGhost.moveGhosts()
        else arenaStateAfterAddGhost

    val nextArenaState =
        if (nextFrameNumber % FRAMES_PER_HERO_MOVE == 0) arenaAfterGhostsMove.moveHero()
        else arenaAfterGhostsMove

    val nextAnimationStep =
        if (arenaState.arena.pacMan.isMoving()) heroAnimationStep.next()
        else heroAnimationStep

    val nextScatterModeEnd = when {
        nextArenaState.action == HeroAction.EAT_POWER_PELLET -> frameNumber + SCATTER_MODE_DURATION
        scatterModeEnd == frameNumber -> null
        else -> scatterModeEnd
    }

    val nextWorld = copy(
        arenaState = nextArenaState,
        frameNumber = nextFrameNumber,
        heroAnimationStep = nextAnimationStep,
        scatterModeEnd = nextScatterModeEnd
    )

//    computeSoundEffects(world = this, nextWorld = nextWorld)

    return nextWorld
}

/**
 * Creates a new World where the hero's intent to move is given by the specified direction
 */
fun World.changeHeroIntent(to: Direction) =
    copy(
        arenaState = arenaState.copy(
            arena = arenaState.arena.copy(
                pacMan = arenaState.arena.pacMan.changeIntent(to)
            )
        )
    )

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
    drawArena(world.arenaState.arena)

    redraw(world.arenaState.arena.pacMan, world.frameNumber, world.heroAnimationStep)
    draw(world.arenaState.arena.ghosts, world.frameNumber)
}

/**
 * Redraws the world on this canvas. This method is used to prevent drawing unchanged areas in
 * each frame.
 */
fun Canvas.redrawWorld(world: World) {
    redrawArena(world.arenaState.arena, world.frameNumber, world.heroAnimationStep)
}

/**
 * The identifier of the wav resource containing the munch sound effect
 */
const val MUNCH_SOUND = "sounds/munch"

/**
 * The identifier of the wav resource containing the siren sound effect
 */
const val SIREN_SOUND = "sounds/siren"

/**
 * The identifier of the wav resource containing the sound effect used after a power pellet is eaten. This sound
 * effect replaces the siren sound effect while the ghosts are vulnerable.
 */
const val POWER_PELLET_SOUND = "sounds/power_pellet"

/**
 * Computes the sound effects to be played for the changes in the world state.
 */
private fun computeSoundEffects(world: World, nextWorld: World) {

    val isEating = world.arenaState.action == HeroAction.EAT_PELLET || world.arenaState.action == HeroAction.EAT_POWER_PELLET
    val willBeEating = nextWorld.arenaState.action == HeroAction.EAT_PELLET || nextWorld.arenaState.action == HeroAction.EAT_POWER_PELLET

    val enteredScatterMode = world.scatterModeEnd == null && nextWorld.scatterModeEnd != null
    val exitedScatterMode = world.scatterModeEnd != null && nextWorld.scatterModeEnd == null

    when {
        !isEating && willBeEating -> playSoundLoop(MUNCH_SOUND)
        isEating && !willBeEating -> stopSoundLoop(MUNCH_SOUND)
        enteredScatterMode -> { stopSoundLoop(SIREN_SOUND); playSoundLoop(POWER_PELLET_SOUND) }
        exitedScatterMode -> { playSoundLoop(SIREN_SOUND); stopSoundLoop(POWER_PELLET_SOUND) }
    }
}

/**
 * Adds a ghost to the arena state if it's time to do so. Otherwise, returns the same arena state.
 * A ghost is added every SECONDS_BETWEEN_GHOSTS seconds until all of them are in the maze.
 */
fun maybeAddGhost(arenaState: ArenaState, frameNumber: Int): ArenaState {
    val elapsedSeconds = frameNumber / FPS
    return if (arenaState.arena.ghosts.size == GhostId.values().size) arenaState
    else if (elapsedSeconds > arenaState.arena.ghosts.size * SECONDS_BETWEEN_GHOSTS) arenaState.addNextGhost()
    else arenaState
}
