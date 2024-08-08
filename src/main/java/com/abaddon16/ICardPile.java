package com.abaddon16;

import java.util.List;

public interface ICardPile{
    int size();
    boolean isEmpty();
    Card peekTopCard();
    
    /**
     * @return The {@link List} of {@link Card Cards} in this pile
     */
    List<Card> peekCards();
    
    /**
     * @param card the {@link Card} to add to the top of this pile
     */
    void add(Card card);
    
    /**
     * @return get the {@link Card} from the top of this pile
     */
    Card pop();
    
    void addAll(List<Card> cards);
    
    /**
     * Checks if the given {@link Card} can stack onto this CardPile
     * @param card the card to check
     * @return {@code true} if the card can stack onto this CardPile
     */
    boolean canCardStack(Card card);
}
