package com.abaddon16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ACardPile implements ICardPile {
    protected List<Card> cards = new ArrayList<>(52);
    
    @Override
    public int size(){
        return cards.size();
    }
    
    @Override
    public boolean isEmpty(){
        return cards.isEmpty();
    }
    
    @Override
    public Card peekTopCard(){
        return cards.get(0);
    }
    
    @Override
    public List<Card> peekCards(){
        return Collections.unmodifiableList(cards);
    }
    
    @Override
    public Card pop(){
        return isEmpty() ? null : cards.remove(0);
    }
    
    @Override
    public void add(List<Card> cards){
        cards.forEach(this::add);
    }
    
    @Override
    public abstract boolean canCardStack(Card card);
    
    @Override
    public abstract void add(Card card);
    
    @Override
    public abstract String toString();
}
