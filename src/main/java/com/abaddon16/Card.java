package com.abaddon16;

public class Card {
    CardValue value;
    CardSuit suit;

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

    public boolean canStackOn(Card other){
        if(other == null && value==CardValue.ACE) return true;
        else if (other == null) return false;
        return !getColor().equals(other.getColor()) && (getValue()-other.getValue())==1;
    }

    @Override
    public String toString(){
        return "{" + this.value + " of "+ this.suit+"}";
    }
}
