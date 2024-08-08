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

    public boolean canStackOn(Card other){
        if(value == CardValue.ACE) return false;
        if(other == null) return value==CardValue.KING;
        return !getColor().equals(other.getColor()) && (other.getValue() - getValue())==1;
    }
    
    public boolean canStackOnFoundation(Foundation foundation){
        return foundation.canCardStack(this);
    }

    @Override
    public String toString(){
        return "{" + this.value + " of "+ this.suit+"}";
    }
}
