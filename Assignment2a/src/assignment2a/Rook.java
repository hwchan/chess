package assignment2a;

public class Rook extends GamePiece {
    
    public Rook(boolean player1) {
        super(player1);
    }
    
    @Override
    public String getType(){
        return "Rook";
    }
}
