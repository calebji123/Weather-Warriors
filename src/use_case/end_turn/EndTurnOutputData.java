package use_case.end_turn;

public class EndTurnOutputData {
    private final String message;
    private final String activeCardName;
    private final Integer activeCardHealth;
    private final String nextCardName;
    private final Integer bossHealth;
    private final Boolean gameEnded;

    public EndTurnOutputData(String message, String activeCardName, Integer activeCardHealth, String nextCardName, Integer bossHealth, Boolean gameEnded) {
        this.message = message;
        this.activeCardName = activeCardName;
        this.activeCardHealth = activeCardHealth;
        this.nextCardName = nextCardName;
        this.bossHealth = bossHealth;
        this.gameEnded = gameEnded;
    }

    public String getMessage() {
        return message;
    }

    public String getActiveCardName() {
        return activeCardName;
    }

    public Integer getActiveCardHealth() {
        return activeCardHealth;
    }

    public String getNextCardName() {
        return nextCardName;
    }

    public Integer getBossHealth() {
        return bossHealth;
    }

    public Boolean getGameEnded() {
        return gameEnded;
    }
}
