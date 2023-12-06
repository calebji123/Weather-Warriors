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
        System.out.println("active: " + this.active.getCardName());
        System.out.println("next: " + this.next.getCardName());
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
            System.out.println(deck);
            System.out.println(deck.size());
            while (this.active == this.next && count < 100){
                System.out.println("Shuffling");
                Random ran = new Random();
                Card candidate = this.deck.get(ran.nextInt(this.deck.size()));
                System.out.println("trying: " + candidate.getCardName() + " death: " + candidate.getDeathStatus() + " active: " + candidate.getActiveStatus());
                if (!candidate.getDeathStatus() && !candidate.getActiveStatus()) {
                    this.next = candidate;
                    this.next.makeNext();
                }
                count += 1;
            }
            System.out.println("active: " + this.active.getCardName());
            System.out.println("next: " + this.next.getCardName());
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
