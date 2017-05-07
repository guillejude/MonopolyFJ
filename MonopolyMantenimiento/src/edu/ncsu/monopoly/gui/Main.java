package edu.ncsu.monopoly.gui;

import javax.swing.JOptionPane;

import edu.ncsu.monopoly.*;
import edu.ncsu.monopoly.test.boardScenarios.GameBoardFull;
import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        GameSystem system = new GameSystem();
        try {
            //try reading the saved data for the system
            FileInputStream fileIn = new FileInputStream("savedFiles.txt");
            BufferedInputStream bufferIn = new BufferedInputStream(fileIn);
            ObjectInputStream in = new ObjectInputStream(bufferIn);
            system = ((GameSystem) in.readObject());
        } catch (IOException | ClassNotFoundException e1) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e1);
        }
        MainMenu mainMenuWindow = new MainMenu(system);
        mainMenuWindow.setVisible(true);
    }
}
