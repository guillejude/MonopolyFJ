/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncsu.monopoly;

import java.util.ArrayList;

public class GameSystem {
    private ArrayList<UserProfile> profiles;

    public GameSystem() {
        this.profiles = new ArrayList<>();
    }

    public ArrayList<UserProfile> getProfiles() {
        return profiles;
    }

    public void setProfiles(ArrayList<UserProfile> profiles) {
        this.profiles = profiles;
    }
    
    public boolean addProfile(UserProfile profile){
        boolean returnValue = false;
        if(!profiles.contains(profile)){
            profiles.add(profile);
            returnValue = true;
        }
        return returnValue;
    }
}
