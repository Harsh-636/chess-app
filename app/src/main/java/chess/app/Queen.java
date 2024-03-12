package chess.app;

public class Queen extends Piece{

    public Queen(Colour colour) {
        super(colour);
    }

    @Override
    public boolean validateMove(Piece[][] board, Square from, Square to) {
        // check if the from and to squares are within bounds
        if (!ChessUtils.validateSquare(from) || !ChessUtils.validateSquare(to)) {
            return false;
        }

        int dx = to.getX() - from.getX();
        int dy = to.getY() - from.getY();

        //case for movement along ranks or files
        if (dx == 0 || dy == 0) {
            return isValidStraightMove(board, from, to, dx, dy);
        }

        //case for movement along diagonal
        if (Math.abs(dx) == Math.abs(dy)) {
            return isValidDiagonalMove(board, from, to, dx, dy);
        }

        return false;
    }

    private boolean isValidStraightMove(Piece[][] board, Square from, Square to, int dx, int dy) {
        // -1 is backwards, 1 is forwards
        int direction;
        if (dx == 0) {
           direction = dy > 0 ? 1 : -1;
        } else {
           direction = dx > 0 ? 1 : -1;
        }

        //we will move this index in the direction of final square and look for obstacles in the way
        int iterator = dx == 0 ? from.getY() : from.getX();

        while((dx == 0 && iterator != to.getY()) || (dy == 0 && iterator != to.getX())) {

            //along x axis (rank), if another piece is found, return false
            if (dx == 0 && board[from.getX()][iterator] != null) {
               return false;
            }

            //along y axis (file), if another piece is found, return false
            if (dy == 0 && board[iterator][from.getY()] != null) {
                return false;
            }

            iterator += direction;
        }

        //no obstacles found, the move is valid
        return true;
    }

    private boolean isValidDiagonalMove(Piece[][] board, Square from, Square to, int dx, int dy) {
        int directionX, directionY;

        directionX = dx > 0 ? 1 : -1;
        directionY = dy > 0 ? 1 : -1;

        int iteratorX = from.getX(), iteratorY = from.getY();

        while(iteratorX != to.getX() && iteratorY != to.getY()) {

            //if another piece found on the movement diagonal, return false
            if (board[iteratorX][iteratorY] != null) {
                return false;
            }

            //move the iterators in the correct directions to reach to square
            iteratorX += directionX;
            iteratorY += directionY;
        }

        return true;
    }

    
    
}
