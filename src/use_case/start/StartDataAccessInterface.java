package use_case.start;

import entity.Board;
import entity.Card;

public interface StartDataAccessInterface {
    void initializeBoard();
    Board getBoard();
}
