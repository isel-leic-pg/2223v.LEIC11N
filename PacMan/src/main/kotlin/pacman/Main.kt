package pacman

import pacman.domain.Coordinate
import pacman.domain.Hero
import pacman.domain.MAZE_HEIGHT
import pacman.domain.MAZE_WIDTH
import pacman.view.MAZE_VIEW_HEIGHT
import pacman.view.MAZE_VIEW_WIDTH
import pacman.view.SCALE
import pacman.view.drawGrid
import pacman.view.drawHero
import pacman.view.drawMaze
import pt.isel.canvas.BLACK
import pt.isel.canvas.Canvas
import pt.isel.canvas.onFinish
import pt.isel.canvas.onStart

fun main() {
    onStart {
        val canvas = Canvas(
            width = (MAZE_VIEW_WIDTH * SCALE).toInt(),
            height = (MAZE_VIEW_HEIGHT * SCALE).toInt(),
            background = BLACK
        )

        drawHero(canvas, Hero(at = Coordinate(row = MAZE_HEIGHT / 2, column = MAZE_WIDTH / 2)))
        drawMaze(canvas)
    }

    onFinish {
        println("Bye!")
    }

}