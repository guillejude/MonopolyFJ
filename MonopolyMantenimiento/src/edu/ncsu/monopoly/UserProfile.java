/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncsu.monopoly;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author Guillermo
 */
public class UserProfile implements Serializable{
    private String name;
    private int gamesPlayed;
    private int gamesWon;
    private ImageIcon image;

    public UserProfile() {
        this.name = "";
        this.gamesPlayed = 0;
        this.gamesWon = 0;
        image = null;
    }
    
    public UserProfile(String name, ImageIcon image) {
        this.name = name;
        this.image = image;
        this.gamesPlayed = 0;
        this.gamesWon = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return this == null;
        }else if(obj instanceof UserProfile){
            return this.name.equals(((UserProfile)obj).name);
        }
        return false;
    }
    
    
}
