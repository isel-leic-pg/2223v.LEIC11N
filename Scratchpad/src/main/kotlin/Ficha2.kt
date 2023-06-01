
data class Coordinate(val x: Int = 0, val y: Int = 0)
data class Hero(val at: Coordinate, val prevAt: Coordinate? = null)

val position = Coordinate(x = 5, y = 5)
val hero = Hero(Coordinate(5, 5))

val result = hero.prevAt?.x