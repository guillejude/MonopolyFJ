package edu.ncsu.monopoly;

public class TaxiCard extends Card {
    private int type;
    private int movement;

    public TaxiCard(int cardType) {
        this.type = cardType;
    }

    public void applyAction() {
        Player currentPlayer = GameMaster.instance().getCurrentPlayer();
        movement = GameMaster.instance().getTaxiMovement();
        GameMaster.instance().movePlayer(currentPlayer, movement);
    }

    public int getCardType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }
    
    public String getLabel() {
        return "The Taxi moved you " + movement + " places";
    }

}
