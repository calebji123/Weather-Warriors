package use_case.end_turn;

import entity.Board;
import entity.Attack;
import entity.Deck;
import entity.Opponent;

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
        Attack attack = opponent.getAttack();
        Integer damage = attack.getDmg();
        Deck deck = board.getDeck();
        deck.getActive().setHP(damage);
        String message = "Boss attacked you! You took " + Integer.toString(damage) + " damage!";
        Boolean gameOver = false;
        if (deck.getActive().getHP() <= 0) {
            String deathMessage = "Card has been defeated!";
            deck.activeDeath();
            message += "\n" + deathMessage;
        }
        if (deck.getDeckSize() <= 0) {
            String gameOverMessage = "You have been defeated!";
            message += "\n" + gameOverMessage;
            gameOver = true;
        }
        dataAccessObject.saveToLog(message);

        EndTurnOutputData endTurnOutputData = new EndTurnOutputData(message, deck.getActive().getCardName(), deck.getActive().getHP(), deck.getNext().getCardName(), opponent.getHP(), gameOver);
        endTurnOutputBoundary.prepareSuccessView(endTurnOutputData);
    }
}
