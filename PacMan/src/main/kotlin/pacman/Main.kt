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
 * SCRIPT:
 * 1. And now, the maze.
 * 1.1 What is the representation of the maze?
 * 1.2 How many different representations of the maze do we need?
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

        canvas.onTimeProgress(period = 1000 / 40)  {
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