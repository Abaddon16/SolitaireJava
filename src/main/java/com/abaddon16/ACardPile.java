package com.abaddon16;

import java.util.ArrayList;
import java.util.List;

public abstract class ACardPile implements ICardPile {
    protected List<Card> cards = new ArrayList<>(52);
    
    protected ACardPile(){}
    
    public int size(){
        return cards.size();
    }
    
    public boolean isEmpty(){
        return cards.isEmpty();
    }
    
    public void clear(){
        cards.clear();
    }
    
    public Card peekTopCard(){
        return cards.isEmpty() ? null : cards.get(cards.size()-1);
    }
    
    public List<Card> getCards(){
        return cards.stream().toList();
    }
    
    public Card getTopCard(){
        return cards.remove(cards.size()-1);
    }
    
    public List<Card> getTopCards(int count){
        List<Card> ret = new ArrayList<>();
        for(int i = 0; i<count; i++) ret.add(cards.remove(0));
        return ret;
    }
    
    public void addCard(Card card){
        cards.add(card);
    }
    
    public void addCards(List<Card> newCards){
        cards.addAll(newCards);
    }
    
    protected void setCards(List<Card> newCards){
        cards.clear();
        cards.addAll(newCards);
    }
    
    public abstract boolean canStack(Card card, ICardPile source);
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        cards.forEach(sb::append);
        return sb.toString();
    }
}
