package chess.app;

public class ChessUtils {
    
    public static boolean validateSquare(Square square) {
        int x = square.getX();
        int y = square.getY();
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}
