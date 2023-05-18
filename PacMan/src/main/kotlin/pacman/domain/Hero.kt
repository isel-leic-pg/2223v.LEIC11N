package pacman.domain

/**
 * Represents the hero, Pac-Man
 */
data class Hero(
    val at: Coordinate,
    val facing: Direction,
    val intent: Direction = facing,
    val previouslyAt: Coordinate = at
)

/**
 * Moves the hero in the direction he is facing
 */
fun Hero.move(maze: List<Cell>): HeroMovementResult {

    val nextFacing = if (maze.hasWall(at + intent)) facing else intent
    val nextCoordinate = if (maze.hasWall(at + nextFacing)) at else at + nextFacing

    return if (nextCoordinate == at) {
        HeroMovementResult(hero = copy(previouslyAt = at), action = HeroAction.STOP)
    }
    else {
        val action = when {
            maze.hasPellet(nextCoordinate) -> HeroAction.EAT_PELLET
            maze.hasPowerPellet(nextCoordinate) -> HeroAction.EAT_POWER_PELLET
            else -> HeroAction.MOVE
        }
        HeroMovementResult(
            hero = copy(at = nextCoordinate, facing = nextFacing, previouslyAt = at),
            action = action
        )
    }
}

/**
 * Makes the hero face the specified direction
 */
fun Hero.face(to: Direction) = copy(facing = to)

/**
 * Changes the hero's intent to move in the specified direction
 */
fun Hero.changeIntent(to: Direction) = copy(intent = to)

/**
 * Returns true if the hero is moving. False otherwise.
 */
fun Hero.isMoving() = at != previouslyAt

/**
 * The hero's action.
 */
enum class HeroAction {
    MOVE,
    EAT_PELLET,
    EAT_POWER_PELLET,
    STOP
}

/**
 * The result of moving the hero.
 * @property hero the hero's new state
 * @property action the action the hero performed
 */
data class HeroMovementResult(val hero: Hero, val action: HeroAction)