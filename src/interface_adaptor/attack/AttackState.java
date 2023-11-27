package interface_adaptor.attack;

public class AttackState {
    private String message;
    private String activeCardName;
    private Integer activeCardHealth;
    private Integer bossHealth;
    private Boolean gameOver;

    public AttackState(AttackState copy) {
        message = copy.message;
        activeCardName = copy.activeCardName;
        activeCardHealth = copy.activeCardHealth;
        bossHealth = copy.bossHealth;
        gameOver = copy.gameOver;
    }
    public AttackState() {}

    public String getActiveCardName() {return this.activeCardName;}
    public void setActiveCardName(String name) {this.activeCardName = name;}
    public Integer getActiveCardHealth() {return this.activeCardHealth;}
    public void setActiveCardHealth(Integer health) {this.activeCardHealth = health;}
    public Integer getBossHealth() {return this.bossHealth;}
    public void setBossHealth(Integer health) {this.bossHealth = health;}
    public Boolean getGameOver() {return this.gameOver;}
    public void setGameOver(Boolean gameOver) {this.gameOver = gameOver;}
    public String getMessage() {return this.message;}
    public void setMessage(String message) {this.message = message;}
}
