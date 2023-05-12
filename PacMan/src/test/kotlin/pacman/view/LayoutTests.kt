package pacman.view

import pacman.domain.MAZE_LAYOUT
import pacman.domain.MAZE_WIDTH
import kotlin.test.Test
import kotlin.test.assertEquals

class LayoutTests {

    @Test
    fun `layoutIndexToArenaPosition on the first line should return the correct position`() {
        val index = MAZE_WIDTH - 1
        val result = layoutIndexToArenaPosition(index)
        assertEquals(expected = Point(x = CELL_SIZE * index, y = 0), actual = result)
    }

    @Test
    fun `layoutIndexToArenaPosition on the last line should return the correct position`() {
        val index = MAZE_LAYOUT.length - 1
        val result = layoutIndexToArenaPosition(index)
        assertEquals(
            expected = Point(
                x = CELL_SIZE * (MAZE_WIDTH - 1),
                y = CELL_SIZE * (index / MAZE_WIDTH)
            ),
            actual = result
        )
    }

    @Test
    fun `layoutSpriteIndexToPoint on the first line should return the correct position`() {
        val index = SPRITE_SHEET_ROW_SIZE - 1
        val result = layoutSpriteIndexToPoint(index)
        assertEquals(
            expected = Point(x = (LAYOUT_SPRITE_SIZE + 1) * index, y = 0),
            actual = result
        )
    }

    @Test
    fun `layoutSpriteIndexToPoint on the second line should return the correct position`() {
        val index = SPRITE_SHEET_ROW_SIZE
        val result = layoutSpriteIndexToPoint(index)
        assertEquals(
            expected = Point(x = 0 , y = (index / SPRITE_SHEET_ROW_SIZE) * (1 + LAYOUT_SPRITE_SIZE)),
            actual = result
        )
    }

}