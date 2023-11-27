package use_case.end_turn;

public class EndTurnOutputData {
    private String message;
    private String activeCardName;
    private Integer activeCardHealth;
    private Integer bossHealth;
    private Boolean gameEnded;

    public EndTurnOutputData(String message, String activeCardName, Integer activeCardHealth, Integer bossHealth, Boolean gameEnded) {
        this.message = message;
        this.activeCardName = activeCardName;
        this.activeCardHealth = activeCardHealth;
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

    public Integer getBossHealth() {
        return bossHealth;
    }

    public Boolean getGameEnded() {
        return gameEnded;
    }
}
