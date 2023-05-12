package pacman.domain

/**
 * The hero's starting position in the maze.
 * Whenever Pac-Man spawns, he does it at the exact same location.
 */
val pacManStartingPosition = Coordinate(row = 23, column = 13)

/**
 * Represents the possible contents of a cell in the maze
 */
enum class Cell {
    WALL,
    EMPTY
}

/**
 * Represents the game arena
 */
data class Arena(val pacMan: Hero, val maze: List<Cell>)

/**
 * Creates a new arena, with all the participants in their initial positions
 */
fun createArena() = Arena(
    pacMan = Hero(at = pacManStartingPosition, facing = Direction.RIGHT),
    maze = MAZE_LAYOUT.map { if(isObstacle(it)) Cell.WALL else Cell.EMPTY }
)

/**
 * Moves the hero in the direction he is facing
 */
fun Arena.moveHero() = copy(pacMan = pacMan.move(this.maze))
