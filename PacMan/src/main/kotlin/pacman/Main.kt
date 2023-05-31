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
 * Goal: Ghost movement and refinement of the game rendering
 * Step 1: We start with a simple movement pattern; if the ghost cannot move in the current direction,
 * it will choose a random direction.
 * Step 2: Refine rendering.
 * Step 2.1: The ghost movement is erasing the pellets. We need to redraw the pellets that were being
 * hidden by the ghost. Create a new function that redraws the pellets in the MazeView.kt file
 * Step 2.2: Refactor the solution so that redrawing the arena consists of the following steps:
 *     1. Clear the ghosts' previous positions
 *     2. Redraw the pellets that were hidden by the ghosts
 *     3. Redraw the hero
 *     4. Draw the ghosts on their current positions
 *     5. Redraw the power pellets if they are visible, that is, not being hidden by a ghost
 * Step 3: Lets add the other ghosts.
 * Step 3.1: They all start at the same position at the same instant, that is, Shadow's initial position.
 * Step 3.2: Move all the ghosts.
 * Step 4: We are using the same movement pattern for all ghosts. What if we want to change that? More,
 * what if we want to change the movement pattern of a specific ghost dynamically? For example, what if we want to
 * change the movement pattern when in scatter mode and resume the previous one when in chase mode?
 * Step 5: Ghosts start gradually, one at a time. The first one is Shadow, the second is Speedy, the third is Bashful
 * and the fourth is Pokey. They start at the same position, but with a delay of 8 seconds between them.
 */
fun main() {
    onStart {
//        loadClips(MUNCH_SOUND, SIREN_SOUND, POWER_PELLET_SOUND)
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