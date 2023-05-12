package pacman.view

import pacman.domain.MAZE_LAYOUT
import pacman.domain.MAZE_WIDTH
import pacman.domain.ghostHouseDoorSymbol
import pacman.domain.isExternalWall
import pacman.domain.isHauntedHouseWall
import pacman.domain.isInternalWall

/**
 * List with the pre-computed coordinates of the layout sprites. The goal is to only compute them once,
 * at application startup. With the current approach we are unable to control the exact moment when this data
 * structure is initiated. What if we need to control it? ;)
 */
internal val layoutSpritesCoordinates: List<LayoutCellInfo> = buildList {

    MAZE_LAYOUT.forEachIndexed { index, _ ->
        val originInArena = layoutIndexToArenaPosition(index)
        val spriteCode = computeSpriteCode(MAZE_LAYOUT, index)
        val originInSprite = layoutSpriteIndexToPoint(spriteCode)
        add(LayoutCellInfo(originInArena, originInSprite))
    }
}

fun layoutIndexToArenaPosition(index: Int) = Point(
        x = (index % MAZE_WIDTH) * CELL_SIZE,
        y = (index / MAZE_WIDTH) * CELL_SIZE
    )

/**
 * Represents information required to draw layout sprites on the screen.
 * @property originInArena  the coordinates where the sprite is to be drawn
 * @property originInArena  the coordinates of the sprite in the sprite sheet
 */
internal data class LayoutCellInfo(val originInArena: Point, val originInSprite: Point)

/**
 * The number of sprites in each row of the sprite sheet
 */
internal const val SPRITE_SHEET_ROW_SIZE = 16

/**
 * The sprite code for the empty cell
 */
private const val EMPTY_SPRITE_CODE = 44

/**
 * The sprite codes for pellets and power pellets
 */
private const val PELLET_SPRITE_CODE = 45
private const val POWER_PELLET_SPRITE_CODE = 47

/**
 * Computes the sprite number that corresponds to the symbol at [index] of [layoutDescription].
 * The layout sprite sheet contains 48 sprites. The returned code is the symbol's sprite index number.
 */
internal fun computeSpriteCode(layoutDescription: String, index: Int): Int {
    val symbol = layoutDescription[index]
    return when {
        isExternalWall(symbol) -> computeExternalWallCode(layoutDescription, index)
        isInternalWall(symbol) -> computeInternalWallCode(layoutDescription, index)
        isHauntedHouseWall(symbol) -> computeHauntedHouseWallCode(layoutDescription, index)
        else -> EMPTY_SPRITE_CODE
    }
}

/**
 * Computes the coordinates of a sprite in the layout sprite sheet, given its index.
 */
internal fun layoutSpriteIndexToPoint(index: Int): Point {
    val row = index / SPRITE_SHEET_ROW_SIZE
    val column = index % SPRITE_SHEET_ROW_SIZE
    return Point(x = column * (LAYOUT_SPRITE_SIZE + 1), y = row * (LAYOUT_SPRITE_SIZE + 1))
}

private fun computeExternalWallCode(layoutDescription: String, index: Int): Int {
    val wallColumn = index % MAZE_WIDTH
    val wallRow = index / MAZE_WIDTH
    return when (layoutDescription[index]) {
        '┃' -> if (wallColumn == 0 || wallColumn == 5) 3 else 2
        '━' -> if (wallRow == 0 || wallRow == 13 || wallRow == 19) 10 else 12
        '┓' -> if (wallRow == 0 || wallRow == 19) 0 else SPRITE_SHEET_ROW_SIZE + 6
        '┏' -> if (wallRow == 0 || wallRow == 19) 1 else SPRITE_SHEET_ROW_SIZE + 7
        '┛' -> if (wallRow == 9 || wallRow == 30) 4 else SPRITE_SHEET_ROW_SIZE + 10
        '┗' -> if (wallRow == 9 || wallRow == 30) 5 else SPRITE_SHEET_ROW_SIZE + 11
        '┲' -> SPRITE_SHEET_ROW_SIZE * 2 + 10
        '┱' -> SPRITE_SHEET_ROW_SIZE * 2 + 11
        '┩' -> 6
        '┡' -> 7
        '┪' -> 8
        '┢' -> 9
        else -> EMPTY_SPRITE_CODE
    }
}

private fun computeInternalWallCode(layoutDescription: String, index: Int): Int {
    // Note that in the following code we are not checking if the arena bounds are respected
    // We do this because we presume this function is ONLY called for symbols pertaining to internal walls and those
    // are ALWAYS inside the arena.
    return when (layoutDescription[index]) {
        '─' -> layoutDescription[index - MAZE_WIDTH].let {
            if (isInternalWall(it)) SPRITE_SHEET_ROW_SIZE + 4 else 14
        }
        '│' -> layoutDescription[index - 1].let {
            if (isInternalWall(it)) SPRITE_SHEET_ROW_SIZE + 8 else SPRITE_SHEET_ROW_SIZE + 9
        }
        '╮' -> SPRITE_SHEET_ROW_SIZE + 6
        '╭' -> SPRITE_SHEET_ROW_SIZE + 7
        '╯' -> SPRITE_SHEET_ROW_SIZE + 10
        '╰' -> SPRITE_SHEET_ROW_SIZE + 11
        '┌' -> 2 * SPRITE_SHEET_ROW_SIZE + 2
        '┐' -> 2 * SPRITE_SHEET_ROW_SIZE + 3
        '└' -> 2 * SPRITE_SHEET_ROW_SIZE + 4
        '┘' -> 2 * SPRITE_SHEET_ROW_SIZE + 5
        else -> EMPTY_SPRITE_CODE
    }
}

private fun computeHauntedHouseWallCode(layoutDescription: String, index: Int): Int {
    val wallColumn = index % MAZE_WIDTH
    val wallRow = index / MAZE_WIDTH
    val code = when (layoutDescription[index]) {
        '╗' -> SPRITE_SHEET_ROW_SIZE + 12
        '╔' -> SPRITE_SHEET_ROW_SIZE + 13
        '╝' -> SPRITE_SHEET_ROW_SIZE + 14
        '╚' -> SPRITE_SHEET_ROW_SIZE + 15
        '║' -> if (wallColumn == 10) 2 else 3
        '═' ->
            when {
                wallRow == 16 -> 10
                layoutDescription[index - 1] == ghostHouseDoorSymbol -> 2 * SPRITE_SHEET_ROW_SIZE
                layoutDescription[index + 1] == ghostHouseDoorSymbol -> 2 * SPRITE_SHEET_ROW_SIZE + 1
                else -> 12
            }
        else -> EMPTY_SPRITE_CODE
    }
    return code
}
