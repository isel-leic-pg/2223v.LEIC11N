package pacman.domain

enum class Cell {
    WALL, EMPTY
}

/**
 * The hero's starting position in the maze.
 * Whenever Pac-Man spawns, he does it at the exact same location.
 */
val pacManStartingPosition = Coordinate(row = 23, column = 13)

data class Arena(val pacMan: Hero, val maze: List<Cell>)

fun createArena() = Arena(
    pacMan = Hero(at = pacManStartingPosition, facing = Direction.RIGHT),
    maze = buildMaze()
)

private fun buildMaze(): List<Cell> {
    return MAZE_LAYOUT.map {
        if(isObstacle(it)) Cell.WALL
        else Cell.EMPTY
    }
}

fun Arena.moveHero() = copy(pacMan = spacMan.move(this.maze))
