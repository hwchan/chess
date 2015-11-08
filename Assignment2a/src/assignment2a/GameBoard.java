package assignment2a;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class GameBoard extends JFrame implements ActionListener {
    
    Tile[][] tiles = new Tile[8][8];
    Tile selectedTile = null;
    
    public GameBoard() {
        this.setTitle("Chess");
        this.setLayout(new GridLayout(8,8));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void initializeBoard() {
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                // Get tile color
                Color c;
                if((j%2==0 && i%2 == 0) || (j%2==1 && i%2==1))
                    c = new Color(255,206,158);
                else
                    c = new Color(209, 139, 71);
                // Create the tile
                Tile tile = new Tile(c, j, i); 
                tile.setPreferredSize(new Dimension(70,70));
                tile.setBackground(tile.tileColor);
                tile.addActionListener(this);
                tiles[j][i] = tile;
                this.add(tile);
            }
        }
        this.pack();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof Tile) {
            Tile tile = (Tile) e.getSource();
            // select a game piece
            if(selectedTile == null) {
                if(tile.getPiece() != null) {
                    selectedTile = tiles[tile.getXCoord()][tile.getYCoord()];
                }
            } 
            // if placing in original lcoation
            else if(selectedTile == tile) {
                selectedTile = null;
            }
            // move/place the selected piece
            else {
                tiles[tile.getXCoord()][tile.getYCoord()].setPiece(selectedTile.getPiece());
                selectedTile.setPiece(null);
                selectedTile = null;
            }
            //System.out.println(tile.xCoord + ":" + tile.yCoord + "\t" + tile.getPiece().getType());
        }
    }
    
    public void addPiece(GamePiece gp, int x, int y) {
        tiles[x][y].setPiece(gp);
    }
}
