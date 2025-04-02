fun isBoardValid(board: Array<CharArray>): Boolean {
    for (row in 0 until 9) {
        val seen = mutableSetOf<Char>()
        for (col in 0 until 9) {
            val num = board[row][col]
            if (num != '_') {
                if (seen.contains(num)) {
                    return false
                }
                seen.add(num)
            }
        }
    }

    // Check all columns
    for (col in 0 until 9) {
        val seen = mutableSetOf<Char>()
        for (row in 0 until 9) {
            val num = board[row][col]
            if (num != '_') {
                if (seen.contains(num)) {
                    return false
                }
                seen.add(num)
            }
        }
    }

    // Check all 3x3 subgrids
    for (box in 0 until 9) {
        val seen = mutableSetOf<Char>()
        val startRow = (box / 3) * 3
        val startCol = (box % 3) * 3
        for (row in startRow until startRow + 3) {
            for (col in startCol until startCol + 3) {
                val num = board[row][col]
                if (num != '_') {
                    if (seen.contains(num)) {
                        return false
                    }
                    seen.add(num)
                }
            }
        }
    }

    return true
}

fun check(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("success - $name")
    } else {
        println("failed - $name")
    }
}

fun main() {
    val board = arrayOf(
        charArrayOf('5', '3', '3', '_', '7', '_', '_', '_', '_'),
        charArrayOf('6', '_', '_', '1', '9', '5', '_', '_', '_'),
        charArrayOf('_', '9', '8', '_', '_', '_', '_', '6', '_'),
        charArrayOf('8', '_', '_', '_', '6', '_', '_', '_', '3'),
        charArrayOf('4', '_', '_', '8', '_', '3', '_', '_', '1'),
        charArrayOf('7', '_', '_', '_', '2', '_', '_', '_', '6'),
        charArrayOf('_', '6', '_', '_', '_', '_', '2', '8', '_'),
        charArrayOf('_', '_', '_', '4', '1', '9', '_', '_', '5'),
        charArrayOf('_', '_', '_', '_', '8', '_', '_', '7', '9')
    )
    val fullValidBoard = arrayOf(
        charArrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9'),
        charArrayOf('4', '5', '6', '7', '8', '9', '1', '2', '3'),
        charArrayOf('7', '8', '9', '1', '2', '3', '4', '5', '6'),
        charArrayOf('2', '3', '4', '5', '6', '7', '8', '9', '1'),
        charArrayOf('5', '6', '7', '8', '9', '1', '2', '3', '4'),
        charArrayOf('8', '9', '1', '2', '3', '4', '5', '6', '7'),
        charArrayOf('3', '4', '5', '6', '7', '8', '9', '1', '2'),
        charArrayOf('6', '7', '8', '9', '1', '2', '3', '4', '5'),
        charArrayOf('9', '1', '2', '3', '4', '5', '6', '7', '8')
    )
    val empty = Array(9) { CharArray(9) { '_' } }
    /* How I have implemented empty at first case:

        val empty = Array(9) { row ->
        CharArray(9) { col ->
            '_'
        }
    }

    for (row in empty) {
        for (i in row) {
            print("$i ")
        }
        println()  // New line after each row
    } */

    check(name = "empty board should be valid",
        result = isBoardValid(empty),
        correctResult = true
    )

    check(name = "when a subgrid has duplicated numbers",
        result = isBoardValid(board),
        correctResult = false
    )
    check(name = "when a row has duplicated numbers",
        result = isBoardValid(board),
        correctResult = false
    )
    check(name = "when a column has duplicated numbers",
        result = isBoardValid(board),
        correctResult = false
    )
    check(name = "when a subgrid has no duplicated numbers",
        result = isBoardValid(fullValidBoard),
        correctResult = true
    )
    check(name = "when a column has no duplicated numbers",
        result = isBoardValid(fullValidBoard),
        correctResult = true
    )
    check(name = "when a row has no duplicated numbers",
        result = isBoardValid(fullValidBoard),
        correctResult = true
    )
}