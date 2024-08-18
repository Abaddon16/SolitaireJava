package com.abaddon16;

public class Card implements ICard {
    private final CardValue value;
    private final CardSuit suit;
    

    public Card(CardSuit suit, CardValue value){
        this.suit = suit;
        this.value = value;
    }
    
    public int getValue(){
        return value.getValue();
    }
    
    public CardSuit getSuit(){
        return suit;
    }
    
    public CardValue getCardValue(){
        return value;
    }
    
    public String getColor(){
        return suit.getColor();
    }

    @Override
    public String toString(){
        return "{" + this.value + " of "+ this.suit+"}";
    }
}
