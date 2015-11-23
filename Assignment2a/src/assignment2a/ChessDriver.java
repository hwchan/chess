package assignment2a;

public class ChessDriver {

    public static void main(String[] args) {

        GameBoard game = new GameBoard();
        game.initializeBoard();
        game.initializeGUI();
        
        Rook r1w = new Rook(false);
        Knight n1w = new Knight(false);
        Bishop b1w = new Bishop(false);
        King k1w = new King(false);
        Queen q1w = new Queen(false);
        Rook r2w = new Rook(false);
        Knight n2w = new Knight(false);
        Bishop b2w = new Bishop(false);
        
        game.addPiece(r1w, 0, 0);
        game.addPiece(n1w, 1, 0);
        game.addPiece(b1w, 2, 0);
        game.addPiece(q1w, 3, 0);
        game.addPiece(k1w, 4, 0);
        game.addPiece(b2w, 5, 0);
        game.addPiece(n2w, 6, 0);
        game.addPiece(r2w, 7, 0);
        
        for(int i=0; i<8; i++)
            game.addPiece(new Pawn(false), i, 1);
        
        game.addPiece(new Rook(true), 0, 7);
        game.addPiece(new Knight(true), 1, 7);
        game.addPiece(new Bishop(true), 2, 7);
        game.addPiece(new Queen(true), 3, 7);
        game.addPiece(new King(true), 4, 7);
        game.addPiece(new Bishop(true), 5, 7);
        game.addPiece(new Knight(true), 6, 7);
        game.addPiece(new Rook(true), 7, 7);
        
        for(int i=0; i<8; i++)
            game.addPiece(new Pawn(true), i, 6);
    }
    
}
