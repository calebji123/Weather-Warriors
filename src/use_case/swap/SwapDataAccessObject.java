package use_case.swap;

import entity.Card;

public interface SwapDataAccessObject {
    Card getCard(String name);
    Card getNextCard();
    Boolean nextCardExists();
    void saveToLog(String message);
}
