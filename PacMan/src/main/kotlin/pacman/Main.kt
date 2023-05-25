package pacman

import pacman.domain.Direction
import pt.isel.canvas.DOWN_CODE
import pt.isel.canvas.KeyEvent
import pt.isel.canvas.LEFT_CODE
import pt.isel.canvas.RIGHT_CODE
import pt.isel.canvas.UP_CODE
import pt.isel.canvas.onFinish
import pt.isel.canvas.onStart

/**
 * Frames per second
 */
const val FPS = 30

/**
 * Implementation of a Pac-Man clone, based on [this version](https://freepacman.org/)
 * For information about the game, namely, scoring system and movement patterns,
 * see [here](https://pacman.fandom.com/wiki/Pac-Man_(game))
 *
 * Next lecture script
 * Goal: Add ghosts to the game
 * Step 1: Ghost representation. Discuss what is required.
 * Step 2: Ghost rendering.
 * Step 2.1: What is common to all actors, ghosts and hero?
 * Step 2.2: Create the ActorsView.kt file and move the common code there.
 * Step 2.3: Create the GhostsView.kt file and place the ghost specific code there.
 * Step 3: Lets add one ghost to the arena. We start with SHADOW.
 * Step 4: Ghost movement.
 * Step 4.1: We start with a simple movement pattern; if the ghost cannot move in the current direction,
 * it will choose a random direction.
 * Step 4.2: We will use the same movement pattern for all ghosts, for now. What if we want to change that? More,
 * what if we want to change the movement pattern of a specific ghost dynamically?
 * Step 5: Lets add the other ghosts.
 * Step 5.1: They all start at the sane position at the same instant, that is, Shadow's initial position.
 * Step 5.2: Move all the ghosts.
 * Step 5.3: Ghosts start gradually, one at a time. The first one is Shadow, the second is Speedy, the third is Bashful
 * and the fourth is Pokey. They start at the same position, but with a delay of 8 seconds between them.
 */
fun main() {
    onStart {
        loadClips(MUNCH_SOUND, SIREN_SOUND, POWER_PELLET_SOUND)
        val canvas = createWorldCanvas()
        var world = World()
        canvas.drawWorld(world)

        playSoundLoop(SIREN_SOUND)

        canvas.onKeyPressed { key ->
            val direction = getDirection(key)
            if (direction != null)
                world = world.changeHeroIntent(direction)
        }

        canvas.onTimeProgress(period = 1000 / FPS)  {
            world = world.doStep()
            canvas.redrawWorld(world)
        }
    }

    onFinish {
        stopsAllSounds()
    }
}

/**
 * Gets the direction represented by the specified key event, or null if the key is not valid
 */
fun getDirection(key: KeyEvent): Direction? {
    return when (key.code) {
        UP_CODE-> Direction.UP
        DOWN_CODE -> Direction.DOWN
        LEFT_CODE -> Direction.LEFT
        RIGHT_CODE -> Direction.RIGHT
        else -> null
    }
}