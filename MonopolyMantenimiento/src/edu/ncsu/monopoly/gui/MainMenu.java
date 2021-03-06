/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncsu.monopoly.gui;

import edu.ncsu.monopoly.GameSystem;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Guillermo
 */
public class MainMenu extends javax.swing.JFrame {

    GameSystem system;

    public MainMenu(GameSystem system) {
        initComponents();
        this.system = system;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnPlay = new javax.swing.JButton();
        btnAddUserProfile = new javax.swing.JButton();
        btnViewProfiles = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblTitle.setText("MONOPOLY");

        btnPlay.setText("PLAY");
        btnPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayMouseClicked(evt);
            }
        });

        btnAddUserProfile.setText("ADD USER PROFILE");
        btnAddUserProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddUserProfileMouseClicked(evt);
            }
        });

        btnViewProfiles.setText("VIEW PROFILES");
        btnViewProfiles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewProfilesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPlay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddUserProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnViewProfiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(27, 27, 27)
                .addComponent(btnPlay)
                .addGap(28, 28, 28)
                .addComponent(btnAddUserProfile)
                .addGap(29, 29, 29)
                .addComponent(btnViewProfiles)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayMouseClicked
        GameSetUp gameSetUpWindow = new GameSetUp(this,system);
        gameSetUpWindow.setVisible(true);
        this.setEnabled(false);
        this.setVisible(false);
    }//GEN-LAST:event_btnPlayMouseClicked

    private void btnAddUserProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddUserProfileMouseClicked
        AddUser addUserWindow = new AddUser(this, system);
        addUserWindow.setVisible(true);
        this.setEnabled(false);
        this.setVisible(false);
    }//GEN-LAST:event_btnAddUserProfileMouseClicked

    private void btnViewProfilesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewProfilesMouseClicked
        if (system.getProfiles().isEmpty()) {
            JOptionPane.showMessageDialog(null, "There are no profiles on the system");
        } else {
            ViewProfiles viewProfilesWindow = new ViewProfiles(this, system);
            viewProfilesWindow.setVisible(true);
            this.setEnabled(false);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnViewProfilesMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //save data before closing the window
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream("savedFiles.txt");
            BufferedOutputStream bufferOut = new BufferedOutputStream(fileOut);
            try (ObjectOutputStream out = new ObjectOutputStream(bufferOut)) {
                out.writeObject(system);
                out.flush();
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "An error has ocurred while saving the system data, information could have been lost");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error has ocurred while saving the system data, information could have been lost");
        }
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUserProfile;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnViewProfiles;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
