package use_case.swap;

import entity.Board;
import entity.Card;
import entity.Deck;

public interface SwapDataAccessInterface {
    Card getNextCard();
    Boolean nextCardExists();
    Card getActiveCard();
    Deck getDeck();
    void saveToLog(String message);
}
