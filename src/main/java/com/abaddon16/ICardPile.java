package com.abaddon16;

import java.util.List;

public interface ICardPile{
    int size();
    boolean isEmpty();
    boolean canStack(Card card, ICardPile source);
    void clear();
    
    Card peekTopCard();
    List<Card> getCards();
    
    Card getTopCard();
    List<Card> getTopCards(int count);
    
    void addCard(Card card);
    void addCards(List<Card> newCards);
}
