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
 * 1. Improve hero representation so that it also includes his intent to move. This will allow us to ONLY make the
 * change to where he is facing when he is in the final position of the movement.
 * 2. Use redrawWorld to only redraw what has changed.
 * 3. Use the same level of abstraction in the implementation of the main function
 * 3.1. Define a function that creates the canvas (createWorldCanvas) where the world is to be displayed
 * 3.2. Define a function that receives a key event and returns the new hero direction, or null if the key is not valid
 * 4. Let's animate the hero movement with the several sprites
 * 5. And now, the maze.
 * 5.1 What is the representation of the maze?
 * 5.2 How many different representations of the maze do we need?
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

        canvas.onTimeProgress(period = 1000/40)  {
            world = world.doStep()
            canvas.drawWorld(world)
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