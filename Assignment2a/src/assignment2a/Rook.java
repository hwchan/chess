package assignment2a;

public class Rook extends GamePiece {
    
    public Rook(boolean player1) {
        super(player1);
    }
    
    @Override
    public String getType(){
        return "Rook";
    }
    
    @Override
    public boolean isValidMove(Tile[][] tiles, Tile from, Tile to) {
        
        int fromX = from.getXCoord();
        int fromY = from.getYCoord();
        int toX = to.getXCoord();
        int toY = to.getYCoord();
        
        System.out.printf("%d,%d to %d,%d\n", fromX, fromY, toX, toY);
        
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
        }
        return false;
    }
}
