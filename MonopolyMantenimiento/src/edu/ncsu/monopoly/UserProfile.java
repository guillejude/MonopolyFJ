/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncsu.monopoly;

import java.awt.image.BufferedImage;
import java.util.Objects;

/**
 *
 * @author Guillermo
 */
public class UserProfile {
    private String name;
    private int gamesPlayed;
    private int gamesWon;
    private BufferedImage image;

    public UserProfile() {
        this.name = "";
        this.gamesPlayed = 0;
        this.gamesWon = 0;
    }
    
    public UserProfile(String name, BufferedImage image) {
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

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((UserProfile)obj).name);
    }
    
    
}
