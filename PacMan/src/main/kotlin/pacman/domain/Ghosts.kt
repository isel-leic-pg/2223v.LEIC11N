package pacman.domain

/**
 * Initial properties of the ghosts.
 */
val ghostsStartingPosition = Coordinate(row = 11, column = 13)
val ghostsStartingFacing = Direction.LEFT

/**
 * Represents the ghost's in the maze.
 */
data class Ghost(
    val id: GhostId,
    val at: Coordinate,
    val facing: Direction,
    val previouslyAt: Coordinate = at
)

/**
 * Represents the ghost's id. Each ghost has a different id and a different behaviour. Ghosts are
 * identified by their colour in the original game.
 */
enum class GhostId { SHADOW, SPEEDY, BASHFUL, POKEY }

/**
 * Moves the ghost to the next cell in the direction it's facing. If there's a wall in the way, the ghost changes
 * direction.
 */
fun Ghost.move(arena: Arena): Ghost {

    val nextFacing =
        if (!arena.maze.hasWall(at + facing)) facing
        else Direction
                .values()
                .filter { !arena.maze.hasWall(at + it) }
                .random()

    return copy(facing = nextFacing, at = at + nextFacing, previouslyAt = at)
}
