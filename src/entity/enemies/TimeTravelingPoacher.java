package entity.enemies;

import entity.Attack;
import entity.Opponent;
import entity.SpecialAttack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//make this an abstract class then hardcode in bosses I think
public class TimeTravelingPoacher implements Opponent {
    private List<Attack> bossMoves = new ArrayList<>();
    private Attack lastMove;
    private Integer HP = 30;
    private final String imageFilePath = ".jpg";

    public TimeTravelingPoacher(){
        Attack pass = new SpecialAttack(0, 1);
        this.bossMoves.add(pass);
        Attack heal = new SpecialAttack(1, 1);
        this.bossMoves.add(heal);
        Attack bigAttack = new Attack(20);
        this.bossMoves.add(bigAttack);
        Attack smallAttack = new Attack(5);
        this.bossMoves.add(smallAttack);
        Attack fireball = new SpecialAttack(1, 1);
        this.bossMoves.add(fireball);
        Attack iceStorm = new SpecialAttack(1, 1);
        this.bossMoves.add(iceStorm);
        Attack gustBlast = new SpecialAttack(1, 1);
        this.bossMoves.add(gustBlast);
    }
    public Attack getAttack(){
        Random rand = new Random();
        Attack atk = bossMoves.get(rand.nextInt(bossMoves.size()));
        this.lastMove = atk;
        return atk;
    }

    public Integer getHP(){return HP;}
    public void changeHP(Integer dmg){HP -= dmg;}
    public String getImageFilePath(){return imageFilePath;}

}
