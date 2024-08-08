package com.abaddon16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Foundation implements ICardPile{
    private final CardSuit suit;
    private final List<Card> cardList = new ArrayList<>(13);
    
    public Foundation(CardSuit suit){
        this.suit = suit;
    }
    
    public void add(Card card){
        if(canCardStack(card)) cardList.add(0, card);
    }
    
    @Override
    public Card pop(){
        return cardList.isEmpty() ? null : cardList.remove(0);
    }
    
    @Override
    public boolean canCardStack(Card card){
        if (cardList.isEmpty()) return card.getCardValue()==CardValue.ACE;
        return card.getSuit()==suit && (card.getValue() - peekTopCard().getValue())==1;
    }
    
    @Override
    public boolean isEmpty()
    {
        return cardList.isEmpty();
    }
    
    @Override
    public Card peekTopCard(){
        return cardList.isEmpty() ? null : cardList.get(0);
    }
    
    @Override
    public List<Card> peekCards(){
        return Collections.unmodifiableList(cardList);
    }
    
    @Override
    public int size()
    {
        return cardList.size();
    }
    
    @Override
    public void addAll(List<Card> cards){
        for(Card card:cards) add(card);
    }
    
    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        for(int i = cardList.size()-1; i>=0; i--) ret.append(cardList.get(i));
        return ret.toString();
    }
}
