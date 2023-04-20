package pacman

import pacman.domain.Direction
import pacman.domain.face
import pacman.view.SCALED_MAZE_VIEW_HEIGHT
import pacman.view.SCALED_MAZE_VIEW_WIDTH
import pt.isel.canvas.BLACK
import pt.isel.canvas.Canvas
import pt.isel.canvas.onFinish
import pt.isel.canvas.onStart
import java.awt.event.KeyEvent

fun main() {
    onStart {
        val canvas = Canvas(
            width = SCALED_MAZE_VIEW_WIDTH,
            height = SCALED_MAZE_VIEW_HEIGHT,
            background = BLACK
        )

        var world = World()
        canvas.drawWorld(world)

        canvas.onKeyPressed { key ->
            world = when (key.code) {
                KeyEvent.VK_UP -> world.copy(hero = world.hero.face(Direction.UP))
                KeyEvent.VK_DOWN -> world.copy(hero = world.hero.face(Direction.DOWN))
                KeyEvent.VK_LEFT -> world.copy(hero = world.hero.face(Direction.LEFT))
                KeyEvent.VK_RIGHT -> world.copy(hero = world.hero.face(Direction.RIGHT))
                else -> world
            }
            canvas.redrawWorld(world)
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