package use_case.attack;

public class AttackOutputData {
    private String message;
    private String activeCardName;
    private Integer activeCardHealth;
    private Integer bossHealth;
    private Boolean gameOver;


    public AttackOutputData(String message, String activeCardName, Integer activeCardHealth, Integer bossHealth, Boolean gameOver) {
        this.message = message;
        this.activeCardName = activeCardName;
        this.activeCardHealth = activeCardHealth;
        this.bossHealth = bossHealth;
        this.gameOver = false;
    }

    public Boolean getGameOver() {return this.gameOver;}
    public String getActiveCardName() {return this.activeCardName;}
    public Integer getActiveCardHealth() {return this.activeCardHealth;}
    public void setActiveCardHealth(Integer health) {this.activeCardHealth = health;}
    public Integer getBossHealth() {return this.bossHealth;}
    public void setBossHealth(Integer health) {this.bossHealth = health;}
    public void gameOver() {this.gameOver = true;}
    public String getMessage() {return this.message;}
    public void setMessage(String message) {this.message = message;}

}
