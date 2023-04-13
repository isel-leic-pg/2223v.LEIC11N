package pacman.view

import pacman.domain.Hero
import pt.isel.canvas.Canvas


fun Canvas.drawWorld(hero: Hero, step: AnimationStep) {
    erase()
    drawMaze()
    drawHero(hero, step)
}