package entity;

import java.util.List;
import java.util.Random;

public interface Opponent {
    final List<Attack> bossMoves = null;
    SpecialAttack getAttack();

    Integer getHP();
    void changeHP(Integer dmg);

    }



