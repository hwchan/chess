package assignment2a;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class GameBoard extends JFrame implements ActionListener {
    
    static Tile[][] tiles = new Tile[8][8];
    private Tile selectedTile = null;
    private boolean player1Turn = true;
    
    public GameBoard() {
        this.setTitle("WHITE's move");
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
                tile.setPreferredSize(new Dimension(60,60));
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
                if(tile.getPiece() != null && tile.getPiece().isPlayer1() == player1Turn) {
                    selectedTile = tile;
                    selectedTile.setBackground(Color.GRAY);
                }
            } 
            // if placing in original lcoation
            else if(selectedTile == tile) {
                selectedTile.setBackground(selectedTile.tileColor);
                selectedTile = null;
            }
            // move/place the selected piece
            else if(selectedTile.getPiece().isValidMove(selectedTile, tile)){
                tile.setPiece(selectedTile.getPiece());
                selectedTile.setPiece(null);
                selectedTile.setBackground(selectedTile.tileColor);
                selectedTile = null;
                player1Turn = !player1Turn;
            }
            //System.out.println(tile.xCoord + ":" + tile.yCoord + "\t" + tile.getPiece().getType());
            if(player1Turn) {
                this.setTitle("WHITE's move");
            } else {
                this.setTitle("BLACK's move");
            }
        }
    }
    
    public void addPiece(GamePiece gp, int x, int y) {
        tiles[x][y].setPiece(gp);
    }
}
