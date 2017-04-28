/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncsu.monopoly;

/**
 *
 * @author Guillermo
 */
public class UserProfile {
    private String name;
    private int gamesPlayed;
    private int gamesWon;
    //images

    public UserProfile() {
        this.name = "";
        this.gamesPlayed = 0;
        this.gamesWon = 0;
    }
    
    public UserProfile(String name) {
        this.name = name;
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
    
    
}
