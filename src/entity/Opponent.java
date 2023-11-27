package entity;

import java.util.List;
import java.util.Random;

public interface Opponent {
    final List<Attack> bossMoves = null;
    Attack getAttack();

    Integer getHP();
    void changeHP(Integer dmg);

    }



