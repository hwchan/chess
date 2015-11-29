package assignment2a;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ChessDriver extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem saveMenuItem, loadMenuItem;
    static GameBoard game;
    static ChessDriver cd;
    final JFileChooser fc = new JFileChooser();
    int returnVal;
    String fileName;

    
    public static void main(String[] args) {
        cd = new ChessDriver();
        cd.setUpFrame(cd);
        game = new GameBoard();
        cd.add(game);
        cd.pack();
        cd.setUpBoard();
    }
    
    private void setUpFrame(ChessDriver cd) {
        cd.setTitle("Chess");
        cd.setPreferredSize(new Dimension(480, 480));
        cd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cd.setVisible(true);
        cd.menuBar = new JMenuBar();
        cd.menu = new JMenu("File");
        cd.menuBar.add(cd.menu);
        cd.setJMenuBar(cd.menuBar);
        cd.saveMenuItem = new JMenuItem("Save");
        cd.saveMenuItem.addActionListener(cd);
        cd.loadMenuItem = new JMenuItem("Load");
        cd.loadMenuItem.addActionListener(cd);
        cd.menu.add(cd.saveMenuItem);
        cd.menu.add(cd.loadMenuItem);
    }
    
    private void setUpBoard() {
        game.initializeBoard();

        game.addPiece(new Rook(false), 0, 0);
        game.addPiece(new Knight(false), 1, 0);
        game.addPiece(new Bishop(false), 2, 0);
        game.addPiece(new Queen(false), 3, 0);
        game.addPiece(new King(false), 4, 0);
        game.addPiece(new Bishop(false), 5, 0);
        game.addPiece(new Knight(false), 6, 0);
        game.addPiece(new Rook(false), 7, 0);

        for (int i = 0; i < 8; i++) {
            game.addPiece(new Pawn(false), i, 1);
        }

        game.addPiece(new Rook(true), 0, 7);
        game.addPiece(new Knight(true), 1, 7);
        game.addPiece(new Bishop(true), 2, 7);
        game.addPiece(new Queen(true), 3, 7);
        game.addPiece(new King(true), 4, 7);
        game.addPiece(new Bishop(true), 5, 7);
        game.addPiece(new Knight(true), 6, 7);
        game.addPiece(new Rook(true), 7, 7);

        for (int i = 0; i < 8; i++) {
            game.addPiece(new Pawn(true), i, 6);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // save
        if (e.getSource() == saveMenuItem) {
            returnVal = fc.showSaveDialog(this);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                // check if extension is already .chess
                fileName = fc.getSelectedFile().getAbsolutePath();
                if(fileName.lastIndexOf(".") == -1 || !fileName.substring(fileName.lastIndexOf("."), fileName.length()).equals(".chess")) {
                    fileName = fileName + ".chess";
                } 
                // save it
                try {
                    FileOutputStream fileOut = new FileOutputStream(fileName);
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(game);
                    out.close();
                    fileOut.close();
                    System.out.println("Game saved to " + fileName);
                } catch (IOException i) {
                    
                }
            }
            
        } // load
        else if (e.getSource() == loadMenuItem) {
            FileFilter filter = new FileNameExtensionFilter("Chess file", new String[] {"chess"});
            fc.addChoosableFileFilter(filter);
            fc.setAcceptAllFileFilterUsed(false);
            returnVal = fc.showOpenDialog(this);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                fileName = fc.getCurrentDirectory() + File.separator + fc.getSelectedFile().getName();
                try {
                    FileInputStream fileIn = new FileInputStream(fileName);
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    GameBoard loadGame = (GameBoard) in.readObject();
                    in.close();
                    fileIn.close();
                    // replace the GameBoard
                    cd.remove(game);
                    cd.add(loadGame);
                    game = loadGame;
                    cd.pack();
                    cd.repaint();
                    System.out.println("Loading " + fileName);
                    // print the turn
                    if(game.isPlayer1Turn()) {
                        System.out.println("WHITE's move");
                    } else {
                        System.out.println("BLACK's move");
                    }
                } catch (IOException i) {
                    System.out.println("Error reading file");
                } catch (ClassNotFoundException c) {
                    System.out.println("Invalid save file");
                }
            }
        }
    }

}
