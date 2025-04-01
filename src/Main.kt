fun isBoardValid(board: Array<IntArray>): Boolean {
    for (row in 0 until 9) {
        val seen = mutableSetOf<Int>()
        for (col in 0 until 9) {
            val num = board[row][col]
            if (num != 0 && !seen.add(num)) {
                return false
            }
        }
    }

    // Check all columns
    for (col in 0 until 9) {
        val seen = mutableSetOf<Int>()
        for (row in 0 until 9) {
            val num = board[row][col]
            if (num != 0 && !seen.add(num)) {
                return false
            }
        }
    }

    // Check all 3x3 subgrids
    for (box in 0 until 9) {
        val seen = mutableSetOf<Int>()
        val startRow = (box / 3) * 3
        val startCol = (box % 3) * 3
        for (row in startRow until startRow + 3) {
            for (col in startCol until startCol + 3) {
                val num = board[row][col]
                if (num != 0 && !seen.add(num)) {
                    return false
                }
            }
        }
    }

    return true
}

fun check(name: String , result:Boolean , correctResult:Boolean){
    if (result == correctResult){
        println("success - $name")
    }else{
        println("failed - $name")
    }
}

fun main() {
    val board = arrayOf(
        intArrayOf(5, 3, 3, 0, 7, 0, 0, 0, 0),
        intArrayOf(6, 0, 0, 1, 9, 5, 0, 0, 0),
        intArrayOf(0, 9, 8, 0, 0, 0, 0, 6, 0),
        intArrayOf(8, 0, 0, 0, 6, 0, 0, 0, 3),
        intArrayOf(4, 0, 0, 8, 0, 3, 0, 0, 1),
        intArrayOf(7, 0, 0, 0, 2, 0, 0, 0, 6),
        intArrayOf(0, 6, 0, 0, 0, 0, 2, 8, 0),
        intArrayOf(0, 0, 0, 4, 1, 9, 0, 0, 5),
        intArrayOf(0, 0, 0, 0, 8, 0, 0, 7, 9)
    )
    val fullValidBoard = arrayOf(
        intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
        intArrayOf(4, 5, 6, 7, 8, 9, 1, 2, 3),
        intArrayOf(7, 8, 9, 1, 2, 3, 4, 5, 6),
        intArrayOf(2, 3, 4, 5, 6, 7, 8, 9, 1),
        intArrayOf(5, 6, 7, 8, 9, 1, 2, 3, 4),
        intArrayOf(8, 9, 1, 2, 3, 4, 5, 6, 7),
        intArrayOf(3, 4, 5, 6, 7, 8, 9, 1, 2),
        intArrayOf(6, 7, 8, 9, 1, 2, 3, 4, 5),
        intArrayOf(9, 1, 2, 3, 4, 5, 6, 7, 8)
    )
    val empty = Array(9) { IntArray(9) { 0 } }

    check(name = "when a subgrid has a duplicated numbers ",
        result =isBoardValid(empty) ,
        correctResult = true
    )

    check(name = "when a subgrid has a duplicated numbers ",
        result =isBoardValid(board) ,
        correctResult = false
    )
    check(name = "when a row has a duplicated numbers ",
        result =isBoardValid(board) ,
        correctResult = false
    )
    check(name = "when a column has a duplicated numbers ",
        result =isBoardValid(board) ,
        correctResult = false
    )
    check(name = "when a subgrid has a  no duplicated numbers ",
        result =isBoardValid(fullValidBoard) ,
        correctResult = true
    )
    check(name = "when a column has a no duplicated numbers ",
        result =isBoardValid(fullValidBoard) ,
        correctResult = true
    )
    check(name = "when a row has a no duplicated numbers ",
        result =isBoardValid(fullValidBoard) ,
        correctResult = true
    )



}