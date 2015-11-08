package assignment2a;

public class King extends GamePiece {
    
    public King(boolean player1) {
        super(player1);
    }
    
    @Override
    public String getType(){
        return "King";
    }
}
