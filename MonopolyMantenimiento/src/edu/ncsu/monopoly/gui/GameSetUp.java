/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncsu.monopoly.gui;

import edu.ncsu.monopoly.GameBoard;
import edu.ncsu.monopoly.GameMaster;
import edu.ncsu.monopoly.GameSystem;
import edu.ncsu.monopoly.Player;
import edu.ncsu.monopoly.UserProfile;
import edu.ncsu.monopoly.test.boardScenarios.GameBoardFull;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Guillermo
 */
public class GameSetUp extends javax.swing.JFrame {

    private final JFrame parent;
    private final GameSystem system;
    private int numberOfPlayers;
    private int playerNumber;
    private ArrayList<Player> players;
    private Color currentColor;
    private ImageIcon currentImage;

    public GameSetUp(JFrame parent, GameSystem system) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.parent = parent;
        this.system = system;
        this.playerNumber = 1;
        this.numberOfPlayers = 2;
        this.players = new ArrayList<>();
        this.currentColor = null;
        this.currentImage = null;

        btnGrpIdentifier.add(rdBtnChooseColor);
        btnGrpIdentifier.add(rdBtnChooseImage);
        btnGrpName.add(rdBtnNewPlayer);
        btnGrpName.add(rdBtnRegisteredPlayer);
        rdBtnNewPlayer.setSelected(true);
        cmbBxUserProfiles.setEnabled(false);
        setUpComboBox();
        lblIdentifierChosen.setOpaque(true);

    }

    private void setUpComboBox() {
        String[] profilesInfo = new String[system.getProfiles().size()];
        for (int i = 0; i < profilesInfo.length; i++) {
            profilesInfo[i] = system.getProfiles().get(i).getName();
        }
        cmbBxUserProfiles.setModel(new DefaultComboBoxModel(profilesInfo));
    }

    public void startGame() {
        //opens game window and starts game
        GameMaster master = GameMaster.instance();
        MainWindow window = new MainWindow(parent);
        GameBoard gameBoard = new GameBoardFull();
        master.setGameBoard(gameBoard);
        master.setNumberOfPlayers(numberOfPlayers);
        //meto los jugadores
        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = master.getPlayer(i);
            player.setName((String) players.get(i).getName());
            player.setPlayerColor(players.get(i).getPlayerColor());
            player.setPlayerImage(players.get(i).getPlayerImage());
            player.setPlaysWithImage(players.get(i).isPlaysWithImage());
            player.setUserProfile(players.get(i).getUserProfile());
        }
        window.setupGameBoard(gameBoard);
        window.show();
        master.setGUI(window);
        master.startGame();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrpIdentifier = new javax.swing.ButtonGroup();
        btnGrpName = new javax.swing.ButtonGroup();
        lblGameSetUp = new javax.swing.JLabel();
        lblNumPlayers = new javax.swing.JLabel();
        cmbBxNumPlayers = new javax.swing.JComboBox();
        lblPlayerName = new javax.swing.JLabel();
        txtFldPlayerName = new javax.swing.JTextField();
        lblPlayerInfo = new javax.swing.JLabel();
        btnInputInfo = new javax.swing.JButton();
        rdBtnChooseColor = new javax.swing.JRadioButton();
        rdBtnChooseImage = new javax.swing.JRadioButton();
        lblIdentifierChosen = new javax.swing.JLabel();
        lblOrIdentifier = new javax.swing.JLabel();
        rdBtnNewPlayer = new javax.swing.JRadioButton();
        rdBtnRegisteredPlayer = new javax.swing.JRadioButton();
        lblOrName = new javax.swing.JLabel();
        cmbBxUserProfiles = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblGameSetUp.setText("GAME SETUP");

        lblNumPlayers.setText("Number of Players:");

        cmbBxNumPlayers.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "3", "4", "5", "6", "7", "8" }));
        cmbBxNumPlayers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbBxNumPlayersMouseClicked(evt);
            }
        });
        cmbBxNumPlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBxNumPlayersActionPerformed(evt);
            }
        });

        lblPlayerName.setText("Player Name: ");

        lblPlayerInfo.setText("Player 1 Info");

        btnInputInfo.setText("OK");
        btnInputInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInputInfoMouseClicked(evt);
            }
        });

        rdBtnChooseColor.setText("Choose Color");
        rdBtnChooseColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdBtnChooseColorActionPerformed(evt);
            }
        });

        rdBtnChooseImage.setText("Choose Image");
        rdBtnChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdBtnChooseImageActionPerformed(evt);
            }
        });

        lblOrIdentifier.setText("or");

        rdBtnNewPlayer.setText("Play As New Player ");
        rdBtnNewPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdBtnNewPlayerActionPerformed(evt);
            }
        });

        rdBtnRegisteredPlayer.setText("Play With A Registered Profile");
        rdBtnRegisteredPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdBtnRegisteredPlayerActionPerformed(evt);
            }
        });

        lblOrName.setText("or");

        cmbBxUserProfiles.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbBxUserProfiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBxUserProfilesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdBtnChooseImage)
                    .addComponent(rdBtnChooseColor))
                .addGap(145, 145, 145))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIdentifierChosen, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInputInfo)
                .addGap(173, 173, 173))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblOrIdentifier)
                .addGap(192, 192, 192))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(lblGameSetUp))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(lblPlayerInfo)))
                .addContainerGap(163, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdBtnNewPlayer)
                .addGap(125, 125, 125))
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(lblNumPlayers)
                .addGap(34, 34, 34)
                .addComponent(cmbBxNumPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(lblPlayerName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFldPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblOrName)
                .addGap(193, 193, 193))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(rdBtnRegisteredPlayer)
                .addGap(94, 94, 94))
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(cmbBxUserProfiles, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGameSetUp)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumPlayers)
                    .addComponent(cmbBxNumPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPlayerInfo)
                .addGap(7, 7, 7)
                .addComponent(rdBtnNewPlayer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlayerName)
                    .addComponent(txtFldPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(lblOrName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdBtnRegisteredPlayer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbBxUserProfiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(rdBtnChooseColor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOrIdentifier)
                .addGap(2, 2, 2)
                .addComponent(rdBtnChooseImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIdentifierChosen, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInputInfo)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.parent.setVisible(true);
        this.parent.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void cmbBxNumPlayersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbBxNumPlayersMouseClicked

    }//GEN-LAST:event_cmbBxNumPlayersMouseClicked

    private void btnInputInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInputInfoMouseClicked
        String name;
        boolean inputsAreValid = false;
        Player player = new Player();
        if (rdBtnRegisteredPlayer.isSelected()) {
            int userNumber = cmbBxUserProfiles.getSelectedIndex();
            UserProfile userSelected = system.getProfiles().get(userNumber);
            player.setUserProfile(userSelected);
            name = userSelected.getName();
            inputsAreValid = true;
        } else {
            name = txtFldPlayerName.getText();
            player.setUserProfile(new UserProfile());
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name must not be empty");
                inputsAreValid = false;
            } else {
                inputsAreValid = true;
            }
        }
        if (rdBtnChooseImage.isSelected() || rdBtnChooseColor.isSelected()) {

        } else {
            JOptionPane.showMessageDialog(null, "You must choose a color or an image to identify yourself with");
            inputsAreValid = false;
        }
        if (inputsAreValid) {
            player.setName(name);
            if (isAlreadyChosen(player)) {
                JOptionPane.showMessageDialog(null, "Name and/or User profile already chosen for this game, please chose another");
            } else {
                player.setPlayerColor(currentColor);
                player.setPlayerImage(currentImage);
                if (currentImage == null) {
                    player.setPlaysWithImage(false);
                } else {
                    player.setPlaysWithImage(true);
                }

                players.add(player);
                if (playerNumber == numberOfPlayers) {
                    startGame();
                    this.dispose();
                } else {
                    prepareInputForNextPlayer();
                }
            }
        }


    }//GEN-LAST:event_btnInputInfoMouseClicked

    public void prepareInputForNextPlayer() {
        //input info for next player
        playerNumber++;
        lblPlayerInfo.setText("Player " + playerNumber + " Info");
        txtFldPlayerName.setText("");
        currentImage = null;
        currentColor = null;
        lblIdentifierChosen.setIcon(null);
        txtFldPlayerName.setEnabled(true);
        cmbBxUserProfiles.setEnabled(false);
        rdBtnNewPlayer.setSelected(true);
        resetIdentifier();
    }
    private void cmbBxNumPlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBxNumPlayersActionPerformed
        //Reset the input of player's info
        playerNumber = 0;
        numberOfPlayers = Integer.parseInt((String) cmbBxNumPlayers.getSelectedItem());
        prepareInputForNextPlayer();
        players = new ArrayList<>();
    }//GEN-LAST:event_cmbBxNumPlayersActionPerformed

    private void rdBtnChooseColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBtnChooseColorActionPerformed
        currentColor = JColorChooser.showDialog(null, "Choose a color", Color.yellow);
        currentImage = null;
        lblIdentifierChosen.setIcon(null);
        lblIdentifierChosen.setBackground(currentColor);
        if (currentColor == null) {
            resetIdentifier();
        }
    }//GEN-LAST:event_rdBtnChooseColorActionPerformed

    private void rdBtnChooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBtnChooseImageActionPerformed
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
        //setup new filechooser so that only images can be selected
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.showOpenDialog(this);
        File imageFile = fileChooser.getSelectedFile();
        try {
            //try to read image, store it and save it
            BufferedImage image = ImageIO.read(imageFile);
            currentImage = new ImageIcon(image.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
            lblIdentifierChosen.setIcon(currentImage);
            currentColor = null;
        } catch (RuntimeException ex) {
            resetIdentifier();
        } catch (Exception ex) {
            resetIdentifier();
        }
    }//GEN-LAST:event_rdBtnChooseImageActionPerformed

    private void rdBtnNewPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBtnNewPlayerActionPerformed
        txtFldPlayerName.setEnabled(true);
        cmbBxUserProfiles.setEnabled(false);
    }//GEN-LAST:event_rdBtnNewPlayerActionPerformed

    private void rdBtnRegisteredPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBtnRegisteredPlayerActionPerformed
        if (system.getProfiles().size() == 0) {
            JOptionPane.showMessageDialog(null, "There are no registered user profiles on the system, select to play as a New Player");
            txtFldPlayerName.setEnabled(true);
            cmbBxUserProfiles.setEnabled(false);
        } else {
            txtFldPlayerName.setEnabled(false);
            cmbBxUserProfiles.setEnabled(true);
        }
    }//GEN-LAST:event_rdBtnRegisteredPlayerActionPerformed

    private void cmbBxUserProfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBxUserProfilesActionPerformed
        int userNumber = cmbBxUserProfiles.getSelectedIndex();
        UserProfile user = system.getProfiles().get(userNumber);
        rdBtnChooseImage.setSelected(true);
        rdBtnChooseColor.setSelected(false);
        currentImage = user.getImage();
        currentColor = null;
        lblIdentifierChosen.setIcon(currentImage);
    }//GEN-LAST:event_cmbBxUserProfilesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGrpIdentifier;
    private javax.swing.ButtonGroup btnGrpName;
    private javax.swing.JButton btnInputInfo;
    private javax.swing.JComboBox cmbBxNumPlayers;
    private javax.swing.JComboBox cmbBxUserProfiles;
    private javax.swing.JLabel lblGameSetUp;
    private javax.swing.JLabel lblIdentifierChosen;
    private javax.swing.JLabel lblNumPlayers;
    private javax.swing.JLabel lblOrIdentifier;
    private javax.swing.JLabel lblOrName;
    private javax.swing.JLabel lblPlayerInfo;
    private javax.swing.JLabel lblPlayerName;
    private javax.swing.JRadioButton rdBtnChooseColor;
    private javax.swing.JRadioButton rdBtnChooseImage;
    private javax.swing.JRadioButton rdBtnNewPlayer;
    private javax.swing.JRadioButton rdBtnRegisteredPlayer;
    private javax.swing.JTextField txtFldPlayerName;
    // End of variables declaration//GEN-END:variables

    private boolean isAlreadyChosen(Player player) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(player.getName())) {
                return true;
            }
        }
        return false;
    }

    private void resetIdentifier() {
        btnGrpIdentifier.clearSelection();
        lblIdentifierChosen.setBackground(null);
        lblIdentifierChosen.setIcon(null);
    }
}
