package use_case.attack;

public class AttackOutputData {
    private final String message;
    private Integer damage;
    private Integer activeCardHealth;
    private Integer bossHealth;


    public AttackOutputData(String message, Integer damage, Integer activeCardHealth, Integer bossHealth, Boolean cardDefeated) {
        this.message = message;
        this.damage = damage;
        this.activeCardHealth = activeCardHealth;
        this.bossHealth = bossHealth;
    }
    public Integer getDamage() {return this.damage;}
    public void setDamage(Integer damage) {this.damage = damage;}
    public Integer getActiveCardHealth() {return this.activeCardHealth;}
    public void setActiveCardHealth(Integer health) {this.activeCardHealth = health;}
    public Integer getBossHealth() {return this.bossHealth;}
    public void setBossHealth(Integer health) {this.bossHealth = health;}
    public String getMessage() {return this.message;}

}
