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
//        random.setSeed(3);
        for(CardSuit x:CardSuit.values()){
            for(CardValue y:CardValue.values()) cards.add(new Card(x, y));
        }
        shuffle();
    }

    /**
     * Shuffle the deck into a random order
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
    
    /**
     * @return The list of {@link Card Cards} of the Deck
     */
    public List<Card> getCards(){
        return cards;
    }
    
    /**
     * @return The top {@link Card} of the Deck
     */
    public Card pop(){
        return !cards.isEmpty() ? cards.remove(0) : null;
    }
    
    /**
     * Set this Deck to the given list of {@link Card Cards}, specifically taken from the {@link Table} waste pile
     * @param cards the Cards in the Table waste pile
     */
    public void resetWaste(List<Card> cards){
        this.cards.addAll(cards);
    }
    
    public boolean isEmpty(){
        return cards.isEmpty();
    }
}
