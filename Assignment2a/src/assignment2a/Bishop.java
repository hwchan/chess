package assignment2a;

public class Bishop extends GamePiece {
    
    public Bishop(boolean player1) {
        super(player1);
    }
    
    @Override
    public String getType(){
        return "Bishop";
    }
    
    @Override
    public boolean isValidMove(Tile[][] tiles, Tile from, Tile to) {
        int fromX = from.getXCoord();
        int fromY = from.getYCoord();
        int toX = to.getXCoord();
        int toY = to.getYCoord();
        
        if(to.getPiece() == null || to.getPiece().isPlayer1() != isPlayer1()) {
            // NW movement
            if(fromX - toX == fromY - toY && fromX - toX > 0) {
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
