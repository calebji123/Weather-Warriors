package use_case.attack;

import entity.Board;
import entity.Card;

public interface AttackDataAccessInterface {

    Board getBoard();

    void saveToLog(String message);

}
