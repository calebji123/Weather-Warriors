package entity;

import java.util.List;
import java.util.Random;
public class Deck {
    private List<Card> deck;
    private Card active;
    private Card next;

    public Deck(List<Card> deck){
        this.deck = deck;
        this.active = deck.get(0);
        this.next = deck.get(1);
    }

    public int getDeckSize(){return this.deck.size();}
    public Card getActive(){return this.active;}
    public Card getNext(){return this.next;}
    public void shuffle(){
        if (this.next != null) {
            this.active.deactivate();
            this.active = this.next;
            this.active.activate();
            while (this.active == this.next){
                Random ran = new Random();
                this.next = this.deck.get(ran.nextInt(this.deck.size()));
                this.next.makeNext();
            }
        }
    }
    public void activeDeath(){
        this.active.die();
        this.deck.remove(active);
        this.shuffle();
    }

}
