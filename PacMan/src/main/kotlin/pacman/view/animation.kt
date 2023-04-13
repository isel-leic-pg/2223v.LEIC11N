package pacman.view

data class AnimationStep(val current: Int, val total: Int)

fun AnimationStep.next() = copy(current = (current + 1) % total)

fun AnimationStep.isLast(): Boolean = current == total - 1

fun AnimationStep.isFirst(): Boolean = current == 0


