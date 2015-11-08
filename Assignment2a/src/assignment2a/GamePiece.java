package assignment2a;

import java.awt.*;

public abstract class GamePiece {
    public abstract String getType();
    public void removeMe(){}
    private final boolean player1;
    private final Color color;
    
    public GamePiece(boolean isPlayer1) {
        player1 = isPlayer1;
        if(player1) {
            color = Color.WHITE;
        } else {
            color = Color.BLACK;
        }
    }
    
    public boolean isValidMove(Tile from, Tile to) {
        return false;
    }

    
    public Color getColor() {
        return color;
    }
    
    public boolean isPlayer1() {
        return player1;
    }
}
