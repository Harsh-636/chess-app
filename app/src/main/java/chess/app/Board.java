package chess.app;

import java.util.HashSet;
import java.util.Set;

public class Board {

    private Piece[][] board;
    private Set<Piece> captured;

    public Board() {

        board = new Piece[8][8];
        captured = new HashSet<>();
    }

    public void movePiece(Square from, Square to) {

        Piece pieceToMove = board[from.getX()][from.getY()];

        if (pieceToMove != null && pieceToMove.validateMove(board, from, to)) {

            // If to square is not empty, check for validity of capture
            if (board[to.getX()][to.getY()] != null) {
                if (validateCapture(board, from, to)) {
                    // store captured piece for reference;
                    captured.add(board[to.getX()][to.getY()]);
                    board[to.getX()][to.getY()] = pieceToMove;
                }
                return;
            }

            // Move the piece to the "to" square
            board[to.getX()][to.getY()] = pieceToMove;
            board[from.getX()][from.getY()] = null;
        }
    }

    private boolean validateCapture(Piece[][] board, Square from, Square to) {

        Piece pieceToMove = board[from.getX()][from.getY()];
        Piece pieceToCapture = board[to.getX()][to.getY()];

        return !(pieceToCapture instanceof King) && pieceToCapture.getColour() != pieceToMove.getColour(); 
    }




    
}
