package use_case.swap;

import entity.Card;

public class SwapOutputData {
    private String message;
    private String nextCardName;
    private Integer nextCardHealth;

    public SwapOutputData(String message, String nextCardName, Integer nextCardHealth) {
        this.message = message;
        this.nextCardName = nextCardName;
        this.nextCardHealth = nextCardHealth;
    }

    public String getMessage() {return this.message;}
    public void setMessage(String message) {this.message = message;}
    public String getNextCardName() {return this.nextCardName;}
    public void setNextCardName(String name) {this.nextCardName = name;}
    public Integer getNextCardHealth() {return this.nextCardHealth;}
    public void setNextCardHealth(Integer health) {this.nextCardHealth = health;}
}
