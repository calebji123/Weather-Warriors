package entity;

public class Board {
    private boolean gameover = false;
    private Deck deck;
    private Opponent opponent;
    public String logFilename;

    private Location location;
    public Board(Deck deck, Opponent enemy, Location location){
        this.deck = deck;
        this.opponent = enemy;
        this.location = location;
    }

}
