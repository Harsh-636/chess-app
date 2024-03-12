package chess.app;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Square {
    private int x;
    private int y;
    private Colour colour;
}
