package entity;

import java.util.List;
import java.util.Random;
//make this an abstract class then hardcode in bosses I think
public class TimeTravelingPoacher extends Opponent {
    private List<Attack> bossMoves;
    private Integer HP;

    public TimeTravelingPoacher(Integer hp, List<Attack> bossMoves){
        super(bossMoves, hp);
        this.HP = hp;
        this.bossMoves = bossMoves;
    }
    public Attack getAttack(){
        Random rand = new Random();
        return bossMoves.get(rand.nextInt(bossMoves.size()));
    }

    public Integer getHP(){return HP;}
    public void changeHP(Integer dmg){HP -= dmg;}



}
