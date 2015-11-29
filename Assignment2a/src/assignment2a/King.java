package assignment2a;

public class King extends GamePiece {
    
    public King(boolean player1) {
        super(player1);
    }
    
    @Override
    public void removeMe() {
        if(isPlayer1()) {
            System.out.println("BLACK WINS");
        } else {
            System.out.println("WHITE WINS");
        }
    }
    
    @Override
    public String getType(){
        return "King";
    }
    
    @Override
    public boolean isValidMove(Tile[][] tiles, Tile from, Tile to) {
        int fromX = from.getXCoord();
        int fromY = from.getYCoord();
        int toX = to.getXCoord();
        int toY = to.getYCoord();
        
        if(to.getPiece() == null || to.getPiece().isPlayer1() != isPlayer1()) {
            // NESW movement
            if((Math.abs(fromX-toX) == 1 && Math.abs(fromY-toY) == 0) ||
               (Math.abs(fromX-toX) == 0 && Math.abs(fromY-toY) == 1)) {
                return true;
            }
            // diagonal movement
            if((Math.abs(fromX-toX) == 1 && Math.abs(fromY-toY) == 1)) {
                return true;
            }
        }
        return false;
    }
}
