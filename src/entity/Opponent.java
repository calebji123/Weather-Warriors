package entity;

import java.util.List;
import java.util.Random;

public interface Opponent {
    SpecialAttack getAttack();

    Integer getHP();
    void changeHP(Integer dmg);

    }



