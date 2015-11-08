package assignment2a;

public class Knight extends GamePiece {
    
    public Knight(boolean player1) {
        super(player1);
    }
    
    @Override
    public String getType(){
        return "Knight";
    }
}
