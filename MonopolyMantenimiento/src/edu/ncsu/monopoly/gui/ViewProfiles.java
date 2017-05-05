/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncsu.monopoly.gui;

import edu.ncsu.monopoly.GameSystem;
import edu.ncsu.monopoly.UserProfile;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Guillermo
 */
public class ViewProfiles extends javax.swing.JFrame {

    private GameSystem system;
    private JFrame parent;
    
    public ViewProfiles(JFrame parent, GameSystem system) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.system = system;
        this.parent = parent;
        setUpComboBox();
        updateProfileInfo(0);
    }
    
    public  void setUpComboBox(){
        String [] profilesInfo = new String [system.getProfiles().size()];
        for(int i = 0; i< profilesInfo.length; i++){
            profilesInfo[i] = system.getProfiles().get(i).getName();
        }
        cmbBxProfiles.setModel(new DefaultComboBoxModel(profilesInfo));
    }
    
    public void updateProfileInfo(int profileNumber){
        UserProfile profile = system.getProfiles().get(profileNumber);
        lblUserNameDisplay.setText(profile.getName());
        lblGamesPlayedDisplay.setText(profile.getGamesPlayed() + "");
        lblGamesWonDisplay.setText(profile.getGamesWon() + "");
        ImageIcon image = new ImageIcon(profile.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
        lblImageDisplay.setIcon(image);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbBxProfiles = new javax.swing.JComboBox();
        lblTitle = new javax.swing.JLabel();
        lblSelectProfile = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblUserNameDisplay = new javax.swing.JLabel();
        lblGamesPlayed = new javax.swing.JLabel();
        lblGamesPlayedDisplay = new javax.swing.JLabel();
        lblGamesWon = new javax.swing.JLabel();
        lblGamesWonDisplay = new javax.swing.JLabel();
        lblImageDisplay = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        cmbBxProfiles.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbBxProfiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBxProfilesActionPerformed(evt);
            }
        });

        lblTitle.setText("VIEW PROFILES");

        lblSelectProfile.setText("Select a Profile To View: ");

        lblUserName.setText("User Name:");

        lblGamesPlayed.setText("Games Played:");

        lblGamesWon.setText("Games Won:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUserName)
                                    .addComponent(lblGamesPlayed)
                                    .addComponent(lblGamesWon))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUserNameDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblGamesPlayedDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblGamesWonDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(lblImageDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSelectProfile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbBxProfiles, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBxProfiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSelectProfile))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUserName)
                            .addComponent(lblUserNameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGamesPlayed)
                            .addComponent(lblGamesPlayedDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGamesWon)
                            .addComponent(lblGamesWonDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblImageDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        parent.setVisible(true);
        parent.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void cmbBxProfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBxProfilesActionPerformed
        int selectedIndex = cmbBxProfiles.getSelectedIndex();
        updateProfileInfo(selectedIndex);
    }//GEN-LAST:event_cmbBxProfilesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbBxProfiles;
    private javax.swing.JLabel lblGamesPlayed;
    private javax.swing.JLabel lblGamesPlayedDisplay;
    private javax.swing.JLabel lblGamesWon;
    private javax.swing.JLabel lblGamesWonDisplay;
    private javax.swing.JLabel lblImageDisplay;
    private javax.swing.JLabel lblSelectProfile;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUserNameDisplay;
    // End of variables declaration//GEN-END:variables
}
