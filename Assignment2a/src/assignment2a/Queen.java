package assignment2a;

public class Queen extends GamePiece {
    
    public Queen(boolean player1) {
        super(player1);
    }
    
    @Override
    public String getType(){
        return "Queen";
    }
    
    private boolean checkBlock(int dirX, int dirY, int fromX, int fromY, int toX, int toY) {
        while(toY != fromY+dirY || toX != fromX+dirX) {
            fromY += dirY;
            fromX += dirX;
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
                    return checkBlock(0,-1,fromX,fromY,toX,toY);
                else
                    return checkBlock(0,1,fromX,fromY,toX,toY);
            }
            // horizontal movement
            if(fromY == toY) {
                if(fromX > toX)
                    return checkBlock(-1,0,fromX,fromY,toX,toY);
                else
                    return checkBlock(1,0,fromX,fromY,toX,toY);
            }
            // diagonal movement
            if(Math.abs(toX - fromX) == Math.abs(toY - fromY)) {
                return true;
            }
        } 
        return false;
    }
}
