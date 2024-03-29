package entity;

import java.util.ArrayList;

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
    public void printCards(){
        for(Card card : deck){
            System.out.println(card);
        }
    }
}
