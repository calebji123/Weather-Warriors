package use_case.attack;

public class AttackOutputData {
    private String message;
    private Integer bossHealth;
    private Boolean gameOver;

    public AttackOutputData(String message,  Integer bossHealth ) {
        this.message = message;
        this.bossHealth = bossHealth;
        this.gameOver = false;
    }

    public Integer getBossHealth() {return this.bossHealth;}
    public void setBossHealth(Integer health) {this.bossHealth = health;}
    public void setGameOver() {this.gameOver = true;}
    public Boolean gameOver() {return gameOver;}
    public String getMessage() {return this.message;}
    public void setMessage(String message) {this.message = message;}

}
