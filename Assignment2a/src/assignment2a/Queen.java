package assignment2a;

public class Queen extends GamePiece {
    
    public Queen(boolean player1) {
        super(player1);
    }
    
    @Override
    public String getType(){
        return "Queen";
    }
    
    // checks if vertical movement is blocked
    // @param dir -1 for NORTH, 1 for SOUTH
    private boolean checkVBlock(int dir, int fromX, int fromY, int toY) {
        while(toY != fromY + dir) {
            fromY += dir;
            System.out.println(fromX + ":" + fromY);
            if(GameBoard.tiles[fromX][fromY].getPiece() != null) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public boolean isValidMove(Tile from, Tile to) {
        int fromX = from.getXCoord();
        int fromY = from.getYCoord();
        int toX = to.getXCoord();
        int toY = to.getYCoord();
        
        System.out.println(fromX + ":" + fromY + " to " + toX + ":" + toY);
        
        if(to.getPiece() == null || to.getPiece().isPlayer1() != isPlayer1()) {
            // vertical movement
            if(fromX == toX) {
                if(fromY > toY)
                    return checkVBlock(-1,fromX,fromY,toY);
                else
                    return checkVBlock(1,fromX,fromY,toY);
            }
            // horizontal movement
            if(fromY == toY) {
                if(fromX > toX)
                    return true;
                else
                    return true;
            }
            // diagonal movement
            if(Math.abs(toX - fromX) == Math.abs(toY - fromY)) {
                return true;
            }
        } 
        return false;
    }
}
