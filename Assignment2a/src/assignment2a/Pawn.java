package assignment2a;

public class Pawn extends GamePiece {
    
    public Pawn(boolean player1) {
        super(player1);
    }
    
    @Override
    public String getType(){
        return "Pawn";
    }
}
