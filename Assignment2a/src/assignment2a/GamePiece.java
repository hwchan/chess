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
    
    protected boolean checkBlock(int dirX, int dirY, int fromX, int fromY, int toX, int toY) {
        while(toY != fromY+dirY || toX != fromX+dirX) {
            fromY += dirY;
            fromX += dirX;
            //System.out.println(fromX + ":" + fromY);
            if(GameBoard.tiles[fromX][fromY].getPiece() != null) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isValidMove(Tile from, Tile to) {
        if(to.getPiece() == null || to.getPiece().isPlayer1() != isPlayer1()) {
            return true;
        } else {
            return false;
        }
    }

    
    public Color getColor() {
        return color;
    }
    
    public boolean isPlayer1() {
        return player1;
    }
}
