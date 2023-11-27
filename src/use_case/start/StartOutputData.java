package use_case.start;

import entity.GameState;

public class StartOutputData {
    private String activeCardName;
    private Integer activeCardHealth;
    private Integer opponentCardHealth;
    private String nextCardName;
    private String location;
    private Integer temperature;
    private String nextLocation;

    public StartOutputData(String activeCardName, Integer activeCardHealth, Integer opponentCardHealth, String nextCardName, String location, Integer temperature, String nextLocation) {
        this.activeCardName = activeCardName;
        this.activeCardHealth = activeCardHealth;
        this.opponentCardHealth = opponentCardHealth;
        this.nextCardName = nextCardName;
        this.location = location;
        this.temperature = temperature;
        this.nextLocation = nextLocation;
    }

    public String getActiveCardName() {
        return activeCardName;
    }

    public Integer getActiveCardHealth() {
        return activeCardHealth;
    }

    public Integer getOpponentCardHealth() {
        return opponentCardHealth;
    }

    public String getNextCardName() {
        return nextCardName;
    }

    public String getLocation() {
        return location;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public String getNextLocation() {
        return nextLocation;
    }

}
