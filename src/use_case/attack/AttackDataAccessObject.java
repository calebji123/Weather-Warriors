package use_case.attack;

import entity.Attack;
import entity.Card;

public interface AttackDataAccessObject {

    Card getCard(String name);

    void saveToLog(String message);

}
