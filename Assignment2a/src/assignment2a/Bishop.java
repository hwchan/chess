package assignment2a;

public class Bishop extends GamePiece {
    
    public Bishop(boolean player1) {
        super(player1);
    }
    
    @Override
    public String getType(){
        return "Bishop";
    }
}
