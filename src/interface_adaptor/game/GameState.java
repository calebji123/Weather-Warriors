package interface_adaptor.game;

public class GameState {
    private String activeCardName;
    private Integer activeCardHealth;
    private Integer opponentCardHealth;
    private String nextCardName;
    private String location;
    private Integer temperature;
    private Integer humidity;
    private String nextLocation;
    private String log;
    public Boolean gameOver;

    public GameState(GameState copy) {
        activeCardName = copy.activeCardName;
        activeCardHealth = copy.activeCardHealth;
        opponentCardHealth = copy.opponentCardHealth;
        nextCardName = copy.nextCardName;
        location = copy.location;
        temperature = copy.temperature;
        humidity = copy.humidity;
        nextLocation = copy.nextLocation;
        log = copy.log;
        gameOver = copy.gameOver;
    }

    public GameState() {
        activeCardName = "";
        activeCardHealth = 0;
        opponentCardHealth = 0;
        nextCardName = "";
        location = "";
        temperature = 0;
        humidity = 0;
        nextLocation = "";
        log = "";
        gameOver = false;
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

    public String getLog() {
        return log;
    }

    public Boolean getGameOver() {
        return gameOver;
    }

    public void setActiveCardName(String activeCardName) {
        this.activeCardName = activeCardName;
    }

    public void setActiveCardHealth(Integer activeCardHealth) {
        this.activeCardHealth = activeCardHealth;
    }

    public void setOpponentCardHealth(Integer opponentCardHealth) {
        this.opponentCardHealth = opponentCardHealth;
    }

    public void setNextCardName(String nextCardName) {
        this.nextCardName = nextCardName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public void setNextLocation(String nextLocation) {
        this.nextLocation = nextLocation;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public void setGameOver(Boolean gameOver) {
        this.gameOver = gameOver;
    }
}
