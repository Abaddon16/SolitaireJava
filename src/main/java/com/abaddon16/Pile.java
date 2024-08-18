package com.abaddon16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pile extends ACardPile {
    
    @Override
    public boolean canStack(Card card, ICardPile source){
        Card topCard = peekTopCard();
        if(topCard == null) return card.getCardValue() == CardValue.KING;
        boolean differentColor = !topCard.getColor().equals(card.getColor());
        boolean pileTopCardOneAbove = topCard.getValue() - card.getValue() == 1;
        return differentColor && pileTopCardOneAbove;
    }
    
    public List<Card> largestStack(){
        List<Card> ret = new ArrayList<>();
        while(!isEmpty()){
            Card topCard = getTopCard();
            if(canStack(topCard, this)) ret.add(topCard);
            else break;
        }
        Collections.reverse(ret);
        return ret;
    }
}
