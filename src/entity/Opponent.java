package entity;

import java.util.List;
import java.util.Random;

public abstract class Opponent {
    private final List<Attack> bossMoves;
    private Integer HP;

    public Opponent(List<Attack> bossMoves, Integer hp){
        this.bossMoves = bossMoves;
        this.HP = hp;
    }
    public Attack getAttack(){
        Random rand = new Random();
        return bossMoves.get(rand.nextInt(bossMoves.size()));
    }

    public Integer getHP(){return HP;}
    public void changeHP(Integer dmg){HP -= dmg;}

    }



