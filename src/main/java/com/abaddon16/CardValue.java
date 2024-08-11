package com.abaddon16;

public enum CardValue {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING;
    
    public int getValue(){
        return ordinal();
    }
    
    @Override
    public String toString() {
        return name();
    }
}
