import pacman.domain.Direction
import pacman.view.AnimationStep
import pacman.view.Point
import pacman.view.SCALED_CELL_SIZE
import pacman.view.computeAnimationDelta
import kotlin.test.Test
import kotlin.test.assertEquals

class AnimationTests {

    @Test
    fun `computeAnimationDelta on last step returns a zero delta`() {

        val step = AnimationStep(current = 3, total = 4)
        val result = computeAnimationDelta(step)

        assertEquals(expected = 0, actual = result)
    }

    @Test
    fun `computeAnimationDelta on first step returns a single delta from the starting point`() {
        val totalSteps = 4
        val step = AnimationStep(current = 0, total = totalSteps)
        val result = computeAnimationDelta(step)

        assertEquals(expected = SCALED_CELL_SIZE - SCALED_CELL_SIZE / totalSteps, actual = result)
    }

    @Test
    fun `computeAnimationDelta on second step returns a double delta from the starting point`() {
        val totalSteps = 4
        val step = AnimationStep(current = 1, total = totalSteps)
        val result = computeAnimationDelta(step)

        assertEquals(expected = SCALED_CELL_SIZE - 2 * SCALED_CELL_SIZE / totalSteps, actual = result)
    }

    @Test
    fun `computeAnimationDelta with hero facing right returns a negative delta`() {
        val totalSteps = 4
        val step = AnimationStep(current = 1, total = totalSteps)
        val result = computeAnimationDelta(step, facing = Direction.RIGHT)

        assertEquals(
            expected = Point(x = -(2 * SCALED_CELL_SIZE / totalSteps), y = 0),
            actual = result
        )
    }

    @Test
    fun `computeAnimationDelta with hero facing left returns a positive delta`() {
        val totalSteps = 4
        val step = AnimationStep(current = 0, total = totalSteps)
        val result = computeAnimationDelta(step, facing = Direction.LEFT)

        assertEquals(
            expected = Point(x = 3 * SCALED_CELL_SIZE / totalSteps, y = 0),
            actual = result
        )
    }

    @Test
    fun `computeAnimationDelta with hero facing up returns a positive delta`() {
        val totalSteps = 4
        val step = AnimationStep(current = 2, total = totalSteps)
        val result = computeAnimationDelta(step, facing = Direction.UP)

        assertEquals(
            expected = Point(x = 0, y = SCALED_CELL_SIZE / totalSteps),
            actual = result
        )
    }

    @Test
    fun `computeAnimationDelta with hero facing down on last step returns a zero delta`() {
        val totalSteps = 4
        val step = AnimationStep(current = 3, total = totalSteps)
        val result = computeAnimationDelta(step, facing = Direction.DOWN)

        assertEquals(expected = Point(x = 0, y = 0), actual = result)
    }

    @Test
    fun `computeAnimationDelta with hero facing down on first step returns a negative delta`() {
        val totalSteps = 4
        val step = AnimationStep(current = 0, total = totalSteps)
        val result = computeAnimationDelta(step, facing = Direction.DOWN)

        assertEquals(
            expected = Point(x = 0, y = -3 * SCALED_CELL_SIZE / totalSteps),
            actual = result
        )
    }
}