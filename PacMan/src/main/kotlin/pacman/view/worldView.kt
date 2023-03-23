package pacman.view

import pacman.domain.Hero
import pt.isel.canvas.Canvas


fun drawWorld(canvas: Canvas, hero: Hero) {
    canvas.erase()
    drawMaze(canvas)
    drawHero(canvas, hero)
}