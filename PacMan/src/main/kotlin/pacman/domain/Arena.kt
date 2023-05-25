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
    EMPTY,
    PELLET,
    POWER_PELLET
}

/**
 * Represents the game arena
 */
data class Arena(
    val pacMan: Hero,
    val maze: List<Cell>,
    val powerPelletsLocations: List<Coordinate>,
    val ghosts: List<Ghost> = listOf(
        Ghost(id = GhostId.SHADOW, at = ghostsStartingPosition, facing = ghostsStartingFacing),
    )
)

/**
 * Represents the arena state, which is composed of the arena contents and the last action performed by the hero.
 */
data class ArenaState(val arena: Arena, val action: HeroAction)

/**
 * Creates a new arena, with all the participants in their initial positions
 */
fun createArena() = Arena(
        pacMan = Hero(at = pacManStartingPosition, facing = Direction.RIGHT),
        maze = MAZE_LAYOUT.map {
            when {
                isPellet(it) -> Cell.PELLET
                isPowerPellet(it) -> Cell.POWER_PELLET
                isObstacle(it) -> Cell.WALL
                else -> Cell.EMPTY
            }
        },
        powerPelletsLocations = MAZE_LAYOUT
            .mapIndexed { index, symbol ->
                if (isPowerPellet(symbol)) index.toCoordinate()
                else null
            }
            .filterNotNull()
    )

/**
 * Moves the hero in the direction he is facing
 */
fun ArenaState.moveHero(): ArenaState {
    val newHeroActionResult = arena.pacMan.move(arena.maze)
    return ArenaState(
        arena = arena.copy(
            pacMan = newHeroActionResult.hero,
            maze = arena.maze.mapIndexed { index, elem ->
                if (newHeroActionResult.hero.at == index.toCoordinate()) Cell.EMPTY
                else elem
            },
            powerPelletsLocations =
                if (newHeroActionResult.action != HeroAction.EAT_POWER_PELLET) arena.powerPelletsLocations
                else arena.powerPelletsLocations.filter { it != newHeroActionResult.hero.at }
        ),
        action = newHeroActionResult.action
    )
}

/**
 * Moves the ghosts in the arena, according to the maze's rules.
 */
fun ArenaState.moveGhosts(): ArenaState {
    val newGhosts = arena.ghosts.map { it.move(arena) }
    return copy(arena = arena.copy(ghosts = newGhosts))
}

/**
 * Checks if there is a wall on the given position of the arena.
 */
fun List<Cell>.hasWall(at: Coordinate) = this[at.toInt()] == Cell.WALL

/**
 * Checks if there is a pellet on the given position of the arena.
 */
fun List<Cell>.hasPellet(at: Coordinate) = this[at.toInt()] == Cell.PELLET

/**
 * Checks if there is a power pellet on the given position of the arena.
 */
fun List<Cell>.hasPowerPellet(at: Coordinate) = this[at.toInt()] == Cell.POWER_PELLET