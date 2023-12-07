package entity;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Iterator;

public class Deck implements Iterable<Card> {
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
            while (this.active == this.next){
                Random ran = new Random();
                Card candidate = this.deck.get(ran.nextInt(this.deck.size()));
                if (!candidate.getDeathStatus() && !candidate.getActiveStatus()) {
                    this.next = candidate;
                    this.next.makeNext();
                }
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
    public Card getCard(int i){
        if (i < this.deckSize){
            return this.deck.get(i);
        }
        else {
            return null;
        }
    }

    public Iterator<Card> iterator() {
        return new Deck.Iter(this);
    }
    private class Iter implements Iterator<Card>{
        private int index = 0;
        private final Deck deck;
        private Iter(Deck deck){
            this.deck = deck;
        }
        @Override
        public boolean hasNext() {
            return index < deck.getDeckSize();
        }
        @Override
        public Card next() {
            if (hasNext()) {
                return deck.getCard(index++);
            }
            else {
                throw new NoSuchElementException();
            }
        }
    }

}

