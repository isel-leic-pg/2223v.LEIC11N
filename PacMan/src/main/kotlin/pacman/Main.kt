package pacman

import pacman.domain.Coordinate
import pacman.domain.Direction
import pacman.domain.Hero
import pacman.domain.MAZE_HEIGHT
import pacman.domain.MAZE_WIDTH
import pacman.view.SCALE
import pacman.view.SCALED_MAZE_VIEW_HEIGHT
import pacman.view.SCALED_MAZE_VIEW_WIDTH
import pacman.view.drawHero
import pacman.view.drawMaze
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
        drawHero(canvas, hero)
        drawMaze(canvas)

        canvas.onKeyPressed { key ->
            hero = when (key.code) {
                KeyEvent.VK_UP -> hero.copy(facing = Direction.UP)
                KeyEvent.VK_DOWN -> hero.copy(facing = Direction.DOWN)
                KeyEvent.VK_LEFT -> hero.copy(facing = Direction.LEFT)
                KeyEvent.VK_RIGHT -> hero.copy(facing = Direction.RIGHT)
                else -> hero
            }
            drawHero(canvas, hero)
        }
    }

    onFinish {
        println("Bye!")
    }

    println("Main ends")
}