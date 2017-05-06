/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncsu.monopoly.test;

import edu.ncsu.monopoly.GameSystem;
import edu.ncsu.monopoly.UserProfile;
import java.util.ArrayList;
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
public class GameSystemTest extends TestCase{
   public void testConstructor(){
       GameSystem system = new GameSystem();
       assertEquals(0, system.getProfiles().size());
   }
    
   public void testSetProfiles(){
       GameSystem system = new GameSystem();
       ArrayList profiles = new ArrayList<>();
       UserProfile user = new UserProfile();
       profiles.add(user);
       system.setProfiles(profiles);
       assertEquals(1, system.getProfiles().size());
   }
   
   public void testAddProfileTrue(){
       GameSystem system = new GameSystem();
       UserProfile user = new UserProfile();
       assertTrue(system.addProfile(user));
   }
   
   public void testAddProfilefalse(){
       GameSystem system = new GameSystem();
       UserProfile user = new UserProfile();
       system.addProfile(user);
       assertFalse(system.addProfile(user));
   }
}
