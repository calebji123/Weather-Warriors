package interface_adaptor.end_turn;

public class EndTurnState {
    private String message;

    private Integer activeCardHealth;

    private Integer bossHealth;

    private Boolean gameEnded;

    public EndTurnState(EndTurnState copy) {
        message = copy.message;
        activeCardHealth = copy.activeCardHealth;
        bossHealth = copy.bossHealth;
        gameEnded = copy.gameEnded;
    }

    public EndTurnState() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getActiveCardHealth() {
        return activeCardHealth;
    }

    public void setActiveCardHealth(Integer activeCardHealth) {
        this.activeCardHealth = activeCardHealth;
    }

    public Integer getBossHealth() {
        return bossHealth;
    }

    public void setBossHealth(Integer bossHealth) {
        this.bossHealth = bossHealth;
    }

    public Boolean getGameEnded() {
        return gameEnded;
    }

    public void setGameEnded(Boolean gameEnded) {
        this.gameEnded = gameEnded;
    }
}
