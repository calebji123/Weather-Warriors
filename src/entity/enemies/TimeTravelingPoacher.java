package entity.enemies;

import entity.Attack;
import entity.Location;
import entity.Opponent;
import entity.SpecialAttack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//make this an abstract class then hardcode in bosses I think
public class TimeTravelingPoacher implements Opponent {
    private List<SpecialAttack> bossMoves = new ArrayList<>();
    private SpecialAttack lastMove;
    private Integer HP = 500;



    public TimeTravelingPoacher(){
        SpecialAttack pass = new SpecialAttack(0, 0);
        this.bossMoves.add(pass);
        this.bossMoves.add(pass);
        SpecialAttack bigAttack = new SpecialAttack(20, 0);
        this.bossMoves.add(bigAttack);
        SpecialAttack smallAttack = new SpecialAttack(5,0);
        this.bossMoves.add(smallAttack);
        this.bossMoves.add(smallAttack);
        this.bossMoves.add(smallAttack);
        SpecialAttack fireball = new SpecialAttack(10, 14);
        this.bossMoves.add(fireball);
        SpecialAttack iceStorm = new SpecialAttack(10, 64);
        this.bossMoves.add(iceStorm);
//        SpecialAttack gustBlast = new SpecialAttack(10, 1);
  //      this.bossMoves.add(gustBlast);
        SpecialAttack waterFall = new SpecialAttack(10, 24);
        this.bossMoves.add(waterFall);
    }
    public SpecialAttack getAttack(){
        Random rand = new Random();
        SpecialAttack atk = bossMoves.get(rand.nextInt(bossMoves.size()));
        this.lastMove = atk;
        return atk;
    }

    public Integer getHP(){return HP;}
    public void changeHP(Integer dmg){HP -= dmg;}

}
