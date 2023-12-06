package use_case.end_turn;

import entity.*;

public class EndTurnInteractor implements EndTurnInputBoundary {
    private final EndTurnOutputBoundary endTurnOutputBoundary;

    private final EndTurnDataAccessInterface dataAccessObject;

    public EndTurnInteractor(EndTurnOutputBoundary endTurnOutputBoundary, EndTurnDataAccessInterface endTurnDataAccessInterface) {
        this.endTurnOutputBoundary = endTurnOutputBoundary;
        this.dataAccessObject = endTurnDataAccessInterface;
    }

    @Override
    public void execute() {
        Board board = dataAccessObject.getBoard();
        Opponent opponent = board.getOpponent();
        SpecialAttack attack = opponent.getAttack();
        Integer damage = attack.modified(dataAccessObject.getBoard().getLocation());
        Deck deck = board.getDeck();
        deck.getActive().setHP(damage);
        String message = "Boss attacked " + deck.getActive().getCardName() + "! " + deck.getActive().getCardName() +  " took " + Integer.toString(damage) + " damage!";
        Boolean gameOver = false;
        if (deck.getActive().getHP() <= 0) {
            String deathMessage = deck.getActive().getCardName() + " has been defeated!";
            deck.activeDeath();
            message += "\r\n" + deathMessage;
        }
        if (deck.getDeckSize() <= 0) {
            String gameOverMessage = "You have been defeated!";
            message += "\r\n" + gameOverMessage;
            gameOver = true;
        }
        dataAccessObject.saveToLog(message);
        String nextCardName = "No cards left";
        if (deck.hasNext()) {
            nextCardName = deck.getNext().getCardName();
        }
        dataAccessObject.addTurn();
        EndTurnOutputData endTurnOutputData = new EndTurnOutputData(message, deck.getActive().getCardName(), deck.getActive().getHP(), nextCardName, opponent.getHP(), gameOver, deck.getDeckSize());
        endTurnOutputBoundary.prepareSuccessView(endTurnOutputData);
    }
}
