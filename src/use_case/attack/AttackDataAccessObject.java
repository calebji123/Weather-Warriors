package use_case.attack;

import entity.Card;

public interface AttackDataAccessObject {

    void change_hp(Card card, Integer damage);
}
