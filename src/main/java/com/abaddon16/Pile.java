package com.abaddon16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pile implements ICardPile{
    private final List<Card> cardList = new ArrayList<>(24);
    
    public Pile(){
    }
    
    @Override
    public int size(){
        return cardList.size();
    }
    
    @Override
    public boolean isEmpty(){
        return cardList.isEmpty();
    }
    
    @Override
    public List<Card> peekCards(){
        return Collections.unmodifiableList(cardList);
    }
    
    @Override
    public Card peekTopCard(){
        return cardList.isEmpty() ? null : cardList.get(0);
    }
    
    public List<Card> getTopCards(int num){
        return Collections.unmodifiableList(cardList.subList(0, num));
    }
    
    @Override
    public void add(Card card){
        if(canCardStack(card)) cardList.add(0, card);
    }
    
    @Override
    public void addAll(List<Card> cards){
        for(Card card:cards) add(card);
    }
    
    public void setCardList(List<Card> cards){
        cardList.clear();
        cardList.addAll(cards);
    }
    
    @Override
    public boolean canCardStack(Card card){
        return false;
    }
    
    @Override
    public Card pop(){
        return cardList.isEmpty() ? null : cardList.remove(0);
    }
    
    public void removeAll(List<Card> cards){
        cardList.removeAll(cards);
    }
    
    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        for(int i = cardList.size()-1; i>=0; i--) ret.append(cardList.get(i));
        return ret.toString();
    }
}
