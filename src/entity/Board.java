package entity;

public class Board {
    private Deck deck;
    private Opponent opponent;
    private Integer turn;

    private Location location;
    public Board(Deck deck, Opponent enemy, Location location){
        this.deck = deck;
        this.opponent = enemy;
        this.location = location;
        this.turn = 0;
    }

    public Deck getDeck(){
        return this.deck;
    }

    public Opponent getOpponent(){
        return opponent;
    }

    public Location getLocation(){
        return location;
    }

    public void setLocation(Location nextLocation){
        this.location = nextLocation;
    }

    public Integer getTurn(){
        return this.turn;
    }

    public void setTurn(Integer turn){
        this.turn = turn;
    }

    public void changeCardHealth(Integer health){
        this.deck.getActive().setHP(health);
    }
    public void changeOpponentHealth(Integer health){
        this.opponent.changeHP(health);
    }
    public void getModifiedHumidity(){
        this.location.getModifiedHumidity();
    }
    public void getModifiedTemperature(){
        this.location.getModifiedTemperature();
    }
    public String getCardsLog(){
        StringBuilder log = new StringBuilder("Cards in dexk:\r\n");
        for (Card card : this.deck){
            log.append(card.getCardName());
            log.append("\r\n");
        }
        return log.toString();
    }


}
