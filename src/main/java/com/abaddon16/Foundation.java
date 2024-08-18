package com.abaddon16;

public class Foundation extends ACardPile {
    
    @Override
    public boolean canStack(Card card, ICardPile source){
        Card topCard = peekTopCard();
        if (card.getCardValue() == CardValue.ACE) return topCard == null;
        boolean sameSuit = card.getSuit() == topCard.getSuit();
        boolean newCardOneAbove = card.getValue() - topCard.getValue() == 1;
        return sameSuit && newCardOneAbove;
    }
}
