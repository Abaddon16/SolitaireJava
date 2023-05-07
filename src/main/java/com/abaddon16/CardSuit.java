package com.abaddon16;

public enum CardSuit {
    HEARTS(0, "red"),
    CLUBS(1, "black"),
    DIAMONDS(2, "red"),
    SPADES(3, "black");

    private final int id;
    private final String color;

    CardSuit(int id, String color){
        this.id = id;
        this.color = color;
    }

    public int getId() {return id;}
    public String getColor(){return color;}


    @Override
    public String toString() {
        return name();
    }
}
