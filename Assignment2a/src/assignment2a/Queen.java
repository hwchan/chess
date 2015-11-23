package assignment2a;

public class Queen extends GamePiece {
    
    public Queen(boolean player1) {
        super(player1);
    }
    
    @Override
    public String getType(){
        return "Queen";
    }
    
    @Override
    public boolean isValidMove(Tile[][] tiles, Tile from, Tile to) {
        int fromX = from.getXCoord();
        int fromY = from.getYCoord();
        int toX = to.getXCoord();
        int toY = to.getYCoord();
        
        //System.out.println(fromX + ":" + fromY + " to " + toX + ":" + toY);
        
        if(to.getPiece() == null || to.getPiece().isPlayer1() != isPlayer1()) {
            // vertical movement
            if(fromX == toX) {
                // N movement
                if(fromY > toY) {
                    return checkBlock(tiles, 0,-1,fromX,fromY,toX,toY);
                }
                // S movement
                else {
                    return checkBlock(tiles, 0,1,fromX,fromY,toX,toY);
                }
            }
            // horizontal movement
            else if(fromY == toY) {
                // W movement
                if(fromX > toX) {
                    return checkBlock(tiles, -1,0,fromX,fromY,toX,toY);
                }
                // E movement
                else {
                    return checkBlock(tiles, 1,0,fromX,fromY,toX,toY);
                }
            }
            // NW movement
            else if(fromX - toX == fromY - toY && fromX - toX > 0) {
                return checkBlock(tiles, -1,-1,fromX,fromY,toX,toY);
            }
            // SE movement
            else if(fromX - toX == fromY - toY && fromX - toX < 0) {
                return checkBlock(tiles, 1,1,fromX,fromY,toX,toY);
            }
            // NE movement
            else if(fromX - toX == (fromY - toY) * -1 && fromX - toX < 0) {
                return checkBlock(tiles, 1,-1,fromX,fromY,toX,toY);
            }
            // SW movement
            else if(fromX - toX == (fromY - toY) * -1 && fromX - toX > 0) {
                return checkBlock(tiles, -1,1,fromX,fromY,toX,toY);
            }
 
        } 
        return false;
    }
}
