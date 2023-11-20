package use_case.end_turn;

public class EndTurnOutputData {
    private String message;

    private Integer activeCardHealth;

    private Integer bossHealth;

    private Boolean gameEnded;

    public EndTurnOutputData(String message, Integer activeCardHealth, Integer bossHealth, Boolean gameEnded) {
        this.message = message;
        this.activeCardHealth = activeCardHealth;
        this.bossHealth = bossHealth;
        this.gameEnded = gameEnded;
    }

    public String getMessage() {
        return message;
    }

    public Integer getActiveCardHealth() {
        return activeCardHealth;
    }

    public Integer getBossHealth() {
        return bossHealth;
    }

    public Boolean getGameEnded() {
        return gameEnded;
    }
}
