package interface_adaptor.attack;

public class AttackState {
    private String message = "";
    private Integer damage = 0;
    private Integer activeCardHealth = 0;
    private Integer bossHealth = 0;
    private Boolean gameOver = false;

    public AttackState(AttackState copy) {
        message = copy.message;
        damage = copy.damage;
        activeCardHealth = copy.activeCardHealth;
        bossHealth = copy.bossHealth;
        gameOver = copy.gameOver;
    }
    public AttackState() {}

    public Integer getDamage() {return this.damage;}
    public void setDamage(Integer damage) {this.damage = damage;}
    public Integer getActiveCardHealth() {return this.activeCardHealth;}
    public void setActiveCardHealth(Integer health) {this.activeCardHealth = health;}
    public Integer getBossHealth() {return this.bossHealth;}
    public void setBossHealth(Integer health) {this.bossHealth = health;}
    public void setGameOver() {this.gameOver = true;}
    public Boolean gameOver() {return gameOver;}
    public String getMessage() {return this.message;}
    public void setMessage(String message) {this.message = message;}
}
