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
    val at: Coordinate = ghostsStartingPosition,
    val facing: Direction = ghostsStartingFacing,
    val previouslyAt: Coordinate = at,
    val movement: (Arena, Ghost) -> Ghost = ::randomSelectionWhenFacingWall
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
fun Ghost.move(arena: Arena): Ghost = this.movement(arena, this)

fun randomSelectionWhenFacingWall(arena: Arena, ghost: Ghost): Ghost {
    val nextFacing =
        if (!arena.maze.hasWall(ghost.at + ghost.facing)) ghost.facing
        else Direction
            .values()
            .filter { !arena.maze.hasWall(ghost.at + it) }
            .random()

    return ghost.copy(facing = nextFacing, at = ghost.at + nextFacing, previouslyAt = ghost.at)
}

fun randomSelection(arena: Arena, ghost: Ghost): Ghost {
    val nextFacing = Direction
        .values()
        .filter { !arena.maze.hasWall(ghost.at + it) }
        .random()

    return ghost.copy(facing = nextFacing, at = ghost.at + nextFacing, previouslyAt = ghost.at)
}
