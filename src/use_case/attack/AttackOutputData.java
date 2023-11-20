package use_case.attack;

public class AttackOutputData {
    private String message;
    private Integer damage;
    private Integer activeCardHealth;
    private Integer bossHealth;
    private Boolean gameOver;


    public AttackOutputData(String message, Integer damage, Integer activeCardHealth, Integer bossHealth, Boolean gameOver) {
        this.message = message;
        this.damage = damage;
        this.activeCardHealth = activeCardHealth;
        this.bossHealth = bossHealth;
        this.gameOver = false;
    }
    public Integer getDamage() {return this.damage;}
    public void setDamage(Integer damage) {this.damage = damage;}
    public Integer getActiveCardHealth() {return this.activeCardHealth;}
    public void setActiveCardHealth(Integer health) {this.activeCardHealth = health;}
    public Integer getBossHealth() {return this.bossHealth;}
    public void setBossHealth(Integer health) {this.bossHealth = health;}
    public void gameOver() {this.gameOver = true;}
    public String getMessage() {return this.message;}
    public void setMessage(String message) {this.message = message;}

}
