package assignment2a;

public class Pawn extends GamePiece {
    
    public Pawn(boolean player1) {
        super(player1);
    }
    
    @Override
    public String getType(){
        return "Pawn";
    }
    
    @Override
    public boolean isValidMove(Tile from, Tile to) {
        int fromX = from.getXCoord();
        int fromY = from.getYCoord();
        int toX = to.getXCoord();
        int toY = to.getYCoord();
    
        // normal movement
        if(to.getPiece() == null) {
            // white moves north
            if(isPlayer1()) {
                if(fromX == toX && fromY - toY == 1) {
                    return true;
                }
            } 
            // black mvoes south
            else {
                if(fromX == toX && fromY - toY == -1) {
                    return true;
                }
            }
        }
        //capturing movement
        else if(to.getPiece().isPlayer1() != isPlayer1()) {
            // white captures NW, NE
            if(isPlayer1()) {
                if((fromX-toX == 1 && fromY-toY == 1) ||
                   (fromX-toX == -1 && fromY-toY == 1)) {
                    return true;
                }
            }
            // black captures SW, SE
            else {
                if((fromX-toX == 1 && fromY-toY == -1) ||
                   (fromX-toX == -1 && fromY-toY == -1)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
