package use_case.swap;

import entity.Card;

public class SwapOutputData {
    private final String message;
    private String nextCard;
    private Integer activeCardHealth;
    private Integer bossHealth;

    public SwapOutputData(String message, Integer activeCardHealth, Integer bossHealth) {
        this.message = message;
        this.activeCardHealth = activeCardHealth;
        this.bossHealth = bossHealth;
    }

    public String getMessage() {return this.message;}
    public String getNextCard() {return this.nextCard;}
    public void setNextCard(String name) {this.nextCard = name;}
    public Integer getActiveCardHealth() {return this.activeCardHealth;}
    public void setActiveCardHealth(Integer health) {this.activeCardHealth = health;}
    public Integer getBossHealth() {return this.bossHealth;}
    public void setBossHealth(Integer health) {this.bossHealth = health;}
}
