/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncsu.monopoly.test;

import edu.ncsu.monopoly.TaxiCard;
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
public class TaxiCardTest extends TestCase{
    public void testMovement(){
        TaxiCard card = new TaxiCard(1);
        card.setMovement(4);
        assertEquals(4, card.getMovement());
    }
    
    public void testGetLabel(){
        TaxiCard card = new TaxiCard(1);
        card.setMovement(4);
        assertEquals("The Taxi moved you 4 places", card.getLabel());
    }
    
    public void testSetType(){
        TaxiCard card = new TaxiCard(1);
        card.setType(2);
        assertEquals(2, card.getCardType());
    }
}
