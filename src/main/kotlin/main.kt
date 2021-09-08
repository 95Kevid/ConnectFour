fun main() {
      val boardService = BoardService()
      val board = boardService.createBoard()
      boardService.placePiece(board, 1, Piece.RED)
      boardService.placePiece(board, 1, Piece.RED)
      boardService.placePiece(board, 1, Piece.RED)
      boardService.renderBoard(board)
}
