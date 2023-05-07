package com.abaddon16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private int id;
    private final List<Card> cards = new ArrayList<>(52);
    private final Random random = new Random();

    public Deck(){
        for(CardSuit x:CardSuit.values()){
            for(CardValue y:CardValue.values()) cards.add(new Card(x, y));
        }
        shuffle();
    }

    /**
     *
     * @param numShuffles if null, shuffles a random number of times
     */
    private void shuffle(Integer numShuffles){
        numShuffles = numShuffles!=null ? numShuffles : random.nextInt(15);
        for(int i=0; i<numShuffles; i++) Collections.shuffle(cards, random);
    }
    private void shuffle(Random random, int bound){
        shuffle(random.nextInt(bound));
    }
    private void shuffle(){
        shuffle(null);
    }

    public List<Card> getCards(){
        return cards;
    }

    public Card pop(){
        return cards.size()>0 ? cards.remove(0) : null;
    }

    public void resetWaste(List<Card> cards){
        this.cards.addAll(cards);
    }

}
