package use_case.attack;

public class AttackOutputData {
    private final Integer damage;
    private Boolean cardDefeated;


    public AttackOutputData(Integer damage, Boolean cardDefeated) {
        this.damage = damage;
        this.cardDefeated = cardDefeated;
    }
    public Integer getDamage() {return this.damage;}
}
