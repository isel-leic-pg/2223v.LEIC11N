package pacman.view

import kotlin.test.Test
import pacman.domain.Step
import kotlin.test.assertEquals

class AnimationTests {

    @Test
    fun `computeMovementStepDelta on first step returns a single delta from the starting point`() {
        val totalSteps = 2
        val step = Step(current = 0, total = totalSteps)
        val result = computeMovementStepDelta(step)

        assertEquals(expected = CELL_SIZE - CELL_SIZE / totalSteps, actual = result)
    }

    @Test
    fun `computeMovementStepDelta on second step returns a double delta from the starting point`() {
        val totalSteps = 2
        val step = Step(current = 1, total = totalSteps)
        val result = computeMovementStepDelta(step)

        assertEquals(expected = CELL_SIZE - 2 * CELL_SIZE / totalSteps, actual = result)
    }

    @Test
    fun `computeMovementStepDelta should return 0 when step is the last one`() {
        val step = Step(current = 1, total = 2)
        val result = computeMovementStepDelta(step)

        assertEquals(expected = 0, actual = result)
    }
}
