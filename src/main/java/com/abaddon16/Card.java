package com.abaddon16;

public class Card {
    private final CardValue value;
    private final CardSuit suit;
    

    public Card(CardSuit suit, CardValue value){
        this.suit = suit;
        this.value = value;
    }

    public String getColor(){
        return suit.getColor();
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

    @Override
    public String toString(){
        return "{" + this.value + " of "+ this.suit+"}";
    }
}
