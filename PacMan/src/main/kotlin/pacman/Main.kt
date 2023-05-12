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
 */
fun main() {
    onStart {
        val canvas = createWorldCanvas()
        var world = World()
        canvas.drawWorld(world)

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
        println("Bye!")
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