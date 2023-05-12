package pacman.domain

/**
 * The maze dimensions
 */
const val MAZE_WIDTH = 28
const val MAZE_HEIGHT = 31

/**
 * The maze layout, in a human-readable form.
 */
const val MAZE_LAYOUT =
    "" +
        "┏━━━━━━━━━━━━┱┲━━━━━━━━━━━━┓" +
        "┃............││............┃" +
        "┃.╭──╮.╭───╮.││.╭───╮.╭──╮.┃" +
        "┃●│xx│.│xxx│.││.│xxx│.│xx│●┃" +
        "┃.╰──╯.╰───╯.╰╯.╰───╯.╰──╯.┃" +
        "┃..........................┃" +
        "┃.╭──╮.╭╮.╭──────╮.╭╮.╭──╮.┃" +
        "┃.╰──╯.││.╰──┐┌──╯.││.╰──╯.┃" +
        "┃......││....││....││......┃" +
        "┗━━━━┓.│└──╮ ││ ╭──┘│.┏━━━━┛" +
        "     ┃.│┌──╯ ╰╯ ╰──┐│.┃     " +
        "     ┃.││          ││.┃     " +
        "     ┃.││ ╔══--══╗ ││.┃     " +
        "━━━━━┛.╰╯ ║      ║ ╰╯.┗━━━━━" +
        "      .   ║      ║   .      " +
        "━━━━━┓.╭╮ ║      ║ ╭╮.┏━━━━━" +
        "     ┃.││ ╚══════╝ ││.┃     " +
        "     ┃.││          ││.┃     " +
        "     ┃.││ ╭──────╮ ││.┃     " +
        "┏━━━━┛.╰╯ ╰──┐┌──╯ ╰╯.┗━━━━┓" +
        "┃............││............┃" +
        "┃.╭──╮.╭───╮.││.╭───╮.╭──╮.┃" +
        "┃.╰─┐│.╰───╯.╰╯.╰───╯.│┌─╯.┃" +
        "┃●..││.......  .......││..●┃" +
        "┡─╮.││.╭╮.╭──────╮.╭╮.││.╭─┩" +
        "┢─╯.╰╯.││.╰──┐┌──╯.││.╰╯.╰─┪" +
        "┃......││....││....││......┃" +
        "┃.╭────┘└──╮.││.╭──┘└────╮.┃" +
        "┃.╰────────╯.╰╯.╰────────╯.┃" +
        "┃..........................┃" +
        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━┛"

/**
 * The lists of symbols used to obstacles in the arena's layout
 */
val externalWallSymbols: List<Char> = listOf('┏', '┃', '┓', '┱', '┲', '┗', '┛', '━', '┢', '┡', '┩', '┪')
val innerWallSymbols: List<Char> = listOf('╭', '╮', '╰', '╯', '─', '│', '┐', '┌', '┘', '└', 'x')

/**
 * The symbol used to represent the ghost house doors, the rectangle at the center of the layout where
 * ghosts spawn from.
 */
const val ghostHouseDoorSymbol: Char = '-'
val ghostHouseWallSymbols: List<Char> = listOf('║', '╔', '═', '╗', '╚', '╝')

/**
 * Checks whether the given symbol corresponds to a wall that delimits the arena's bounds, that is,
 * an external wall
 */
fun isExternalWall(symbol: Char) = symbol in externalWallSymbols

/**
 * Checks whether the given symbol corresponds to a wall inside the arena
 */
fun isInternalWall(symbol: Char) = symbol in innerWallSymbols

/**
 * Checks whether the given symbol corresponds to a wall ghost house wall
 */
fun isHauntedHouseWall(symbol: Char) = symbol in ghostHouseWallSymbols

/**
 * Checks whether the given symbol is an obstacle, that is, unpassable by the hero or the villains (in their normal mode)
 */
fun isObstacle(symbol: Char) =
    isExternalWall(symbol) || isInternalWall(symbol) || isHauntedHouseWall(symbol) || symbol == ghostHouseDoorSymbol

/**
 * Checks whether the given symbol is a pellet, that is, a small point that the hero can eat to score points
 */
fun isPellet(symbol: Char) = symbol == '.'

/**
 * Checks whether the given symbol is a power pellet, that is, a big point that the hero can eat to score points and
 * temporarily put the villains in a vulnerable state
 */
fun isPowerPellet(symbol: Char) = symbol == '●'
