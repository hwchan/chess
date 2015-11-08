package assignment2a;

public class Queen extends GamePiece {
    
    public Queen(boolean player1) {
        super(player1);
    }
    
    @Override
    public String getType(){
        return "Queen";
    }
}
