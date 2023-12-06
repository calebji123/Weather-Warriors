package entity;

import java.util.List;
import java.util.Random;
public class Deck {
    private List<Card> deck;
    private Card active;
    private Card next;
    private Integer deckSize;

    public Deck(List<Card> deck){
        this.deck = deck;
        this.active = deck.get(0);
        this.active.activate();
        this.next = null;
        this.deckSize = deck.size();
        if (this.deckSize > 1) {
            this.next = deck.get(1);
            this.next.makeNext();
        }
    }

    public int getDeckSize(){return deckSize;}
    public Card getActive(){return this.active;}
    public Card getNext(){return this.next;}
    public Boolean hasNext(){return this.next != null;}
    public void shuffle(){
        if (this.next != null) {
            this.active.deactivate();
            this.active = this.next;
            this.active.activate();
            int count = 0;
            while (this.active == this.next && count < 100){
                Random ran = new Random();
                Card candidate = this.deck.get(ran.nextInt(this.deck.size()));
                if (!candidate.getDeathStatus() && !candidate.getActiveStatus()) {
                    this.next = candidate;
                    this.next.makeNext();
                }
                count += 1;
            }
        }
    }
    public void activeDeath(){
        this.active.die();
        this.deckSize -= 1;
        if (getDeckSize() > 1) {
            this.shuffle();
        }
        else if (getDeckSize() == 1){
            this.next.activate();
            this.active = this.next;
            this.next = null;
        }
    }
}
