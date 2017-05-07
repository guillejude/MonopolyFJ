package edu.ncsu.monopoly.test;

import edu.ncsu.monopoly.Cell;
import edu.ncsu.monopoly.GameBoard;
import edu.ncsu.monopoly.GameMaster;
import edu.ncsu.monopoly.Player;
import edu.ncsu.monopoly.PropertyCell;
import edu.ncsu.monopoly.SimpleGameBoard;
import edu.ncsu.monopoly.UserProfile;
import java.awt.Color;
import javax.swing.ImageIcon;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;

public class PlayerTest extends TestCase {

    GameMaster gameMaster;

    protected void setUp() throws Exception {
        gameMaster = GameMaster.instance();
        gameMaster.setGameBoard(new SimpleGameBoard());
        gameMaster.setGUI(new MockGUI());
        gameMaster.setTestMode(true);
        gameMaster.reset();
    }

    public void testPurchaseProperty() {
        gameMaster.setNumberOfPlayers(1);
        gameMaster.movePlayer(0, 3);
        Player player = gameMaster.getPlayer(0);
        player.purchase();
        assertEquals(1380, player.getMoney());
        assertEquals("Blue 3", player.getProperty(0).getName());
        PropertyCell cell
                = (PropertyCell) gameMaster.getGameBoard().queryCell("Blue 3");
        assertSame(player, cell.getOwner());
    }

    public void testSameGoCell() {
        GameBoard gameboard = gameMaster.getGameBoard();
        Player player1 = new Player();
        Player player2 = new Player();
        Cell go = gameboard.queryCell("Go");
        assertSame(go, player1.getPosition());
        assertSame(go, player2.getPosition());
    }

    public void testPayRentTo() {
        gameMaster.setNumberOfPlayers(2);
        gameMaster.movePlayer(0, 4);
        gameMaster.getCurrentPlayer().purchase();
        gameMaster.btnEndTurnClicked();
        gameMaster.movePlayer(1, 4);
        gameMaster.btnEndTurnClicked();
        assertTrue(gameMaster.getPlayer(1).isBankrupt());
        assertEquals(2800, gameMaster.getPlayer(0).getMoney());
    }

    public void testExchangeProperty() {
        gameMaster.setNumberOfPlayers(2);
        gameMaster.movePlayer(0, 3);
        gameMaster.getCurrentPlayer().purchase();
        gameMaster.btnEndTurnClicked();
        gameMaster.getPlayer(0).exchangeProperty(gameMaster.getPlayer(1));
        assertEquals(1, gameMaster.getCurrentPlayer().getPropertyNumber());
    }

    public void testPurchaseHouse() {
        gameMaster.setNumberOfPlayers(1);
        gameMaster.startGame();
        gameMaster.movePlayer(gameMaster.getCurrentPlayerIndex(), 1);
        gameMaster.getCurrentPlayer().purchase();
        gameMaster.btnEndTurnClicked();
        gameMaster.movePlayer(0, 1);
        gameMaster.getCurrentPlayer().purchase();
        gameMaster.btnEndTurnClicked();
        gameMaster.movePlayer(0, 1);
        gameMaster.getCurrentPlayer().purchase();
        gameMaster.btnEndTurnClicked();
        gameMaster.getCurrentPlayer().purchaseHouse("blue", 2);
        assertEquals("blue", gameMaster.getCurrentPlayer().getMonopolies()[0]);
        assertEquals(880, gameMaster.getCurrentPlayer().getMoney());
    }

    public void testResetProperty() {
        gameMaster.setNumberOfPlayers(1);
        gameMaster.movePlayer(0, 1);
        gameMaster.getCurrentPlayer().purchase();
        assertEquals(gameMaster.getGameBoard().getCell(1), gameMaster.getCurrentPlayer().getAllProperties()[0]);
        gameMaster.getCurrentPlayer().resetProperty();
        assertEquals(0, gameMaster.getCurrentPlayer().getAllProperties().length);
    }

    public void testPayRentToBank() {
        gameMaster.setNumberOfPlayers(1);
        int amount = 50;
        gameMaster.getCurrentPlayer().payRentToBank(amount);
        assertEquals(1450, gameMaster.getCurrentPlayer().getMoney());
    }
    
    public void testPlayerColor(){
        gameMaster.setNumberOfPlayers(1);
        gameMaster.getCurrentPlayer().setPlayerColor(Color.yellow);
        assertEquals(Color.yellow, gameMaster.getCurrentPlayer().getPlayerColor());
    }
    
    public void testPlayerImage(){
        gameMaster.setNumberOfPlayers(1);
        gameMaster.getCurrentPlayer().setPlayerImage(null);
        assertNull(gameMaster.getCurrentPlayer().getPlayerImage());
    }
    
    public void testPlayesWithImage(){
        gameMaster.setNumberOfPlayers(1);
        gameMaster.getCurrentPlayer().setPlaysWithImage(true);
        assertTrue(gameMaster.getCurrentPlayer().isPlaysWithImage());
    }
    
    public void testGetOutOfJail(){
        gameMaster.setNumberOfPlayers(1);
        gameMaster.getCurrentPlayer().setInJail(true);
        gameMaster.getCurrentPlayer().getOutOfJail();
        assertFalse(gameMaster.getCurrentPlayer().isInJail());
        assertEquals(1450, gameMaster.getCurrentPlayer().getMoney());
    }
    
    public void testGetOutOfJailBankruot(){
        gameMaster.setNumberOfPlayers(1);
        gameMaster.getCurrentPlayer().setInJail(true);
        gameMaster.getCurrentPlayer().setMoney(40);
        gameMaster.getCurrentPlayer().getOutOfJail();
        assertFalse(gameMaster.getCurrentPlayer().isInJail());
        assertTrue(gameMaster.getCurrentPlayer().isBankrupt());
    }
    
    public void testExchangePropertyNull() {
        gameMaster.setNumberOfPlayers(1);
        gameMaster.movePlayer(0, 3);
        gameMaster.getCurrentPlayer().purchase();
        gameMaster.btnEndTurnClicked();
        gameMaster.getPlayer(0).exchangeProperty(null);
        assertEquals(0, gameMaster.getPlayer(0).getAllProperties().length);
    }
    
    public void testUserProfile(){
        Player player = new Player();
        UserProfile userProfile = new UserProfile();
        player.setUserProfile(userProfile);
        assertEquals(userProfile, player.getUserProfile());
    }
}
