/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncsu.monopoly.test;

import edu.ncsu.monopoly.UserProfile;
import javax.swing.ImageIcon;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guillermo
 */
public class UserProfileTest extends TestCase{
    public void testConstructorNoParameters(){
        UserProfile user = new UserProfile();
        assertEquals("", user.getName());
    }
    
    public void testConstructorParameters(){
        UserProfile user = new UserProfile("Juan", null);
        assertEquals("Juan", user.getName());
    }
    
    public void testName(){
        UserProfile user = new UserProfile();
        user.setName("Juan");
        assertEquals("Juan", user.getName());
    }
    
    public void testGamesPlayed(){
        UserProfile user = new UserProfile();
        user.setGamesPlayed(2);
        assertEquals(2, user.getGamesPlayed());
    }
    
    public void testGamesWon(){
        UserProfile user = new UserProfile();
        user.setGamesWon(2);
        assertEquals(2, user.getGamesWon());
    }
    
    public void testImage(){
        UserProfile user = new UserProfile();
        user.setImage(null);
        assertNull( user.getImage());
    }
    
    public void testEquals(){
        UserProfile user = new UserProfile("Juan", null);
        UserProfile user2 = new UserProfile();
        user2.setName("Juan");
        assertTrue(user.equals(user2));
    }
} 
