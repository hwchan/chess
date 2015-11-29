package assignment2a;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        // save
        if (e.getSource() == saveMenuItem) {
            returnVal = fc.showSaveDialog(this);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                fileName = fc.getCurrentDirectory() + File.separator + fc.getSelectedFile().getName() + ".chess";
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
                    cd.remove(game);
                    game = (GameBoard) in.readObject();
                    in.close();
                    fileIn.close();

                    cd.add(game);
                    cd.pack();
                    cd.repaint();
                    System.out.println("Loading " + fileName);
                } catch (IOException i) {
                    System.out.println("Invalid save file");
                    return;
                } catch (ClassNotFoundException c) {
                    System.out.println("Invalid save file");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {

        cd = new ChessDriver();

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

        game = new GameBoard();
        cd.add(game);
        cd.pack();
        game.initializeBoard();

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

}
