import java.lang.IllegalArgumentException
import java.util.ArrayList

class BoardService {

    fun createBoard(): Board {
        var rows = arrayOf<Array<Position>>()
        repeat(Board.boardSize.SIZE) {
            var column = arrayOf<Position>()
            repeat(Board.boardSize.SIZE) {
                column += Position()
            }
            rows += column

        }
        return Board(rows)
    }

    fun placePiece(board: Board, slotNumber: Int, piece: Piece): Boolean {
        if (slotNumber > Board.boardSize.SIZE) {
            println("Move is out side allowable slot range. " +
                      "Please select a slot within the range of 1 and ${Board.boardSize.SIZE}.")
            return false
        }

        var column = arrayOf<Position>()
        board.rows.forEach { column += it[slotNumber - 1] }
        column.reverse()
        column.forEachIndexed { index, position ->
            if (position.piece == null && index < column.size - 1) {
                board.rows[Board.boardSize.SIZE -1][index] = Position(piece)
                return true
            }
            else if (index > column.size - 1) {
                println("This slot is completely filled. Please select another slot")
            }
            board.rows[(Board.boardSize.SIZE -1) - (index + 1)][index] = Position(piece)
            return true
        }

        return false
    }

    fun renderBoard(board: Board) {
        println("1   2   3   4   5   6   7   8")
        board.rows.forEach {
            var pieces = arrayOf<String>()
            it.forEach { position ->
                pieces += when (position.piece) {
                    null -> "  "
                    Piece.RED -> "X "
                    Piece.YELLOW -> "0 "
                }
            }
            val outputRow = pieces.asList().toString()
                .replace(",", "|")  //remove the commas
                .replace("[", "")  //remove the right bracket
                .replace("]", "")  //remove the left bracket
            println(outputRow)
        }
    }

}
