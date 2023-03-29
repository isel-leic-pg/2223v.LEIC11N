package pacman

import pacman.domain.Coordinate
import pacman.domain.Direction
import pacman.domain.Hero
import pacman.domain.MAZE_HEIGHT
import pacman.domain.MAZE_WIDTH
import pacman.domain.face
import pacman.domain.move
import pacman.view.AnimationStep
import pacman.view.SCALED_MAZE_VIEW_HEIGHT
import pacman.view.SCALED_MAZE_VIEW_WIDTH
import pacman.view.drawWorld
import pacman.view.isLast
import pacman.view.next
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

        var hero = Hero(at = Coordinate(row = MAZE_HEIGHT / 2, column = MAZE_WIDTH / 2), facing = Direction.UP)
        var step = AnimationStep(current = 0, total = 4)

        canvas.drawWorld(hero, step)

        canvas.onKeyPressed { key ->
            hero = when (key.code) {
                KeyEvent.VK_UP -> hero.face(Direction.UP)
                KeyEvent.VK_DOWN -> hero.face(Direction.DOWN)
                KeyEvent.VK_LEFT -> hero.face(Direction.LEFT)
                KeyEvent.VK_RIGHT -> hero.face(Direction.RIGHT)
                else -> hero
            }
            canvas.drawWorld(hero, step)
        }

        canvas.onTimeProgress(period = 1000 / step.total)  {
            if (step.isLast())
                hero = hero.move()

            canvas.drawWorld(hero, step)
            step = step.next()
        }
    }

    onFinish {
        println("Bye!")
    }

    println("Main ends")
}