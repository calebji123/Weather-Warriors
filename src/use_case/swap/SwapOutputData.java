package use_case.swap;

import entity.Card;
import interface_adaptor.swap.SwapState;

public class SwapOutputData {
    private String message;
    private String activeCardName;
    private Integer activeCardHealth;
    private String nextCardName;

    public SwapOutputData(String message, String nextCardName, Integer nextCardHealth, String nextNextCardName) {
        this.message = message;
        this.activeCardName = nextCardName;
        this.activeCardHealth = nextCardHealth;
        this.nextCardName = nextNextCardName;
    }

    public String getMessage() {return this.message;}
    public void setMessage(String message) {this.message = message;}
    public String getActiveCardName() {return this.activeCardName;}
    public void setActiveCardName(String name) {this.activeCardName = name;}
    public Integer getActiveCardHealth() {return this.activeCardHealth;}
    public void setActiveCardHealth(Integer health) {this.activeCardHealth = health;}
    public String getNextCardName() {return this.nextCardName;}
    public void setNextCardName(String name) {this.nextCardName = name;}
}
