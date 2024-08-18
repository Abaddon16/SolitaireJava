package com.abaddon16;

public class Waste extends ACardPile {
    @Override
    public boolean canStack(Card card, ICardPile source){
        return source instanceof Deck;
    }
}
