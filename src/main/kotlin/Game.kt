

// Game constants.
const val CELL_SIDE = 32
const val FIVE_CELLS = CELL_SIDE * 5
const val GRID_WIDTH = 20
const val GRID_HEIGHT = 16
const val SPRITE_DIV = 64
const val BLOCK_SPAWN_TIMER = 5000
const val QUART_OF_A_SEC = 250
const val STATUS_BAR = 40
const val TEXT_BASE = 10
const val FONT_SIZE = 25
//const val LEVEL_ONE_WIN = 60
const val INIT_SIZE = 5


/**
 * The three possible game states.
 */
enum class Status { RUN, WIN, LOSE }


/**
 * Class that defines the whole game.
 * @property snake object with movement in the game.
 * @property wall obstacles that stop movement of the [snake].
 * @property apple fruit that makes [snake] grow bigger.
 * @property score numbers of apples eaten.
 * @property status current state of the game.
 */
data class Game(val snake: Snake, val wall: List<Position>, val apple: Position?, val score: Int, val status: Status)


fun Game.isPossible() : Game {
    val rightPos = snake.body[0] + Direction.RIGHT
    val upPos = snake.body[0] + Direction.UP
    val downPos = snake.body[0] + Direction.DOWN
    val leftPos = snake.body[0] + Direction.LEFT
    //all unavailable Position
    val impPos = snake.body + wall
    val newStatus = if (rightPos in impPos && upPos in impPos && downPos in impPos && leftPos in impPos) when {
        snake.body.size > 60 -> Status.WIN
        else -> Status.LOSE
    }
        else Status.RUN
    return this.copy(status = newStatus)

}

