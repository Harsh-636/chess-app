package chess.app;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Piece {

    protected Colour colour;
    
    public abstract boolean validateMove(Piece[][] board, Square from, Square to);
}
