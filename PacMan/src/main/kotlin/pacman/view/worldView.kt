package pacman.view

import pacman.domain.Hero
import pt.isel.canvas.Canvas


fun Canvas.drawWorld(hero: Hero, step: AnimationStep) {
    println("Drawing frame")
    erase()
    drawMaze()
    drawHero(hero, step)
}