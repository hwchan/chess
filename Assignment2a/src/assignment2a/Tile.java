package assignment2a;

import java.awt.*;
import javax.swing.*;

public class Tile extends JButton {
    public Color tileColor;
    public int xCoord;
    public int yCoord;
    private GamePiece piece;
    
    public Tile(Color c, int x, int y) {
        tileColor = c;
        xCoord = x;
        yCoord = y;
    }
    
    public void setPiece(GamePiece gp) {
        piece = gp;
        if(piece != null) {
            this.setText(gp.getType());
            this.setForeground(gp.getColor());
        }
        else {
            this.setText("");
        }
    }
    public GamePiece getPiece() {
        return piece;
    }
}
