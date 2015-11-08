package assignment2a;

public class Knight extends GamePiece {
    
    public Knight(boolean player1) {
        super(player1);
    }
    
    @Override
    public String getType(){
        return "Knight";
    }
    
    @Override
    public boolean isValidMove(Tile from, Tile to) {
        int fromX = from.getXCoord();
        int fromY = from.getYCoord();
        int toX = to.getXCoord();
        int toY = to.getYCoord();
        
        if(to.getPiece() == null || to.getPiece().isPlayer1() != isPlayer1()) {
            // jumping L shape movement
            if (fromX+2 == toX && fromY+1 == toY ||
                fromX-2 == toX && fromY+1 == toY ||
                fromX+1 == toX && fromY+2 == toY ||
                fromX-1 == toX && fromY+2 == toY ||
                    
                fromX+2 == toX && fromY-1 == toY ||
                fromX-2 == toX && fromY-1 == toY ||
                fromX+1 == toX && fromY-2 == toY ||
                fromX-1 == toX && fromY-2 == toY) {
                return true;
            }
        } 
        return false;
    }
}
