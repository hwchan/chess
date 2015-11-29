package assignment2a;

import java.awt.*;

public abstract class GamePiece implements java.io.Serializable {
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
    
    /**
     * Check whether the piece can reach the destination tile without getting blocked.
     * @param tiles Array of current tiles
     * @param dirX X direction
     * @param dirY Y direction
     * @param fromX X start coordinate
     * @param fromY Y start coordinate
     * @param toX X destination coordinate
     * @param toY Y destination coordinate
     * @return false if the piece is blocked, true if the piece can reach the destination
     */
    protected boolean checkBlock(Tile[][] tiles, int dirX, int dirY, int fromX, int fromY, int toX, int toY) {
        // start checking every tile that might be blocked
        while(toY != fromY+dirY || toX != fromX+dirX) {
            fromY += dirY;
            fromX += dirX;
            //System.out.println(fromX + ":" + fromY);
            if(tiles[fromX][fromY].getPiece() != null) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isValidMove(Tile[][] tiles, Tile from, Tile to) {
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
