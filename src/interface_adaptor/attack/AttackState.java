package interface_adaptor.attack;

public class AttackState {
    private String message;
    private Integer bossHealth;
    private Boolean gameOver;

    public AttackState(AttackState copy) {
        message = copy.message;
        bossHealth = copy.bossHealth;
        gameOver = copy.gameOver;
    }
    public AttackState() {}

    public Integer getBossHealth() {return this.bossHealth;}
    public void setBossHealth(Integer health) {this.bossHealth = health;}
    public void setGameOver() {this.gameOver = true;}
    public Boolean gameOver() {return gameOver;}
    public String getMessage() {return this.message;}
    public void setMessage(String message) {this.message = message;}
}
