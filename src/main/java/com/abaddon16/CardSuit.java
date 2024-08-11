package com.abaddon16;

public enum CardSuit {
    HEARTS("red"),
    CLUBS("black"),
    DIAMONDS("red"),
    SPADES("black");

    private final String color;

    CardSuit(String color){
        this.color = color;
    }
    
    public String getColor(){
        return color;
    }
    
    @Override
    public String toString() {
        return name();
    }
}
