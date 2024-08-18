package com.abaddon16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck extends ACardPile {
    private final Random random = new Random();
    
    public Deck(){
        random.setSeed(3);
        List<Card> tempCards = new ArrayList<>(52);
        for(CardSuit x:CardSuit.values()){
            for(CardValue y:CardValue.values())
                tempCards.add(new Card(x, y));
        }
        setCards(tempCards);
        shuffle();
    }
    
    /**
     * Shuffle the deck into a random order
     */
    private void shuffle(){
        int numShuffles = random.nextInt(15);
        for(int i=0; i<numShuffles; i++) Collections.shuffle(cards, random);
    }
    
    @Override
    public boolean canStack(Card card, ICardPile source){
        return false;
    }
}
