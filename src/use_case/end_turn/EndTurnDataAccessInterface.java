package use_case.end_turn;

import entity.Board;

public interface EndTurnDataAccessInterface {
    Board getBoard();

    void saveToLog(String message);
}
