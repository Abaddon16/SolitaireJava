package com.abaddon16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
    private final Map<CardSuit, Foundation> foundations = new HashMap<>(4);
    private final Deck deck = new Deck();
    private final List<Card> waste = new ArrayList<>(24);
    private final List<Pile> piles = new ArrayList<>(7);
    private final MoveHistory previousMoves = new MoveHistory(25);
    
    public Table(){
        for(CardSuit x:CardSuit.values()) foundations.put(x, new Foundation(x));
        for(int i = 0; i<7; i++){
            List<Card> pile = new ArrayList<>();
            for(int j = 0; j<i+1; j++) pile.add(deck.pop());
            piles.add(i, new Pile(pile));
        }
//        for(Pile pile:piles) System.out.println(pile);
    }
    
    /**
     * Move a card from the {@link Deck} to the waste pile, recycle if necessary
     */
    private void cycleDeckToWaste(){
        if(deck.isEmpty()){
            deck.resetWaste(waste);
            waste.clear();
        }
        if(!deck.isEmpty()) waste.add(deck.pop());
    }
    
    public void fillFoundationsFromPiles(){
        boolean stillLooking = true;
        while(stillLooking){
            stillLooking = false;
            for(Pile pile:piles){
                if (pile.isEmpty()) continue;
                Card x = pile.peekTopCard();
                Foundation foundation = foundations.get(x.getSuit());
                if(x.canStackOnFoundation(foundation)){
                    foundation.add(pile.pop());
                    previousMoves.add(x, foundation);
                }
            }
        }
    }
    
    public void rearrangePiles(){
        boolean stillLooking = true;
        while(stillLooking){
            stillLooking = false;
            for(Pile pile:piles) stillLooking = moveFromStack(pile);
        }
    }
    
    public void checkNextDeckCard(){
        cycleDeckToWaste();
        if(waste.isEmpty()) return;
        Card x = waste.get(waste.size()-1);
        Foundation foundation = foundations.get(x.getSuit());
        if(x.canStackOnFoundation(foundation)){
            foundation.add(x);
            waste.remove(x);
            previousMoves.add(x, foundation);
            return;
        }
        for(Pile pile:piles){
            Card top = pile.isEmpty() ? null : pile.peekTopCard();
            if(x.canStackOn(top) && !previousMoves.contains(x, top)){
                pile.add(x);
                waste.remove(x);
                previousMoves.add(x, top);
                break;
            }
        }
    }
    
    public void tryAndWin()
    {
        for(int i=0; i<5000; i++)
        {
            if(hasWon()) return;
            while(!deck.isEmpty()){
                checkNextDeckCard();
                rearrangePiles();
            }
            checkNextDeckCard();
            fillFoundationsFromPiles();
            rearrangePiles();
        }
    }
    
    private boolean moveFromStack(Pile currentPile){
        if (currentPile.isEmpty()) return false;
        
        for(int i = 0; i<currentPile.size()-1; i++){
            boolean nonStack = false;
            List<Card> subPileReversed = currentPile.getTopCards(i+1);
            List<Card> subPile = new ArrayList<>(subPileReversed.size());
            for(int pain = subPileReversed.size()-1; pain>=0; pain--) subPile.add(subPileReversed.get(i));
            for(int j = 0; j < subPile.size() - 1; j++){
                if(!subPile.get(j).canStackOn(subPile.get(j+1))) {
                    nonStack=true;
                    break;
                }
            }
            if(nonStack) break;
            // viable subPile
            Card bottomMostCard = subPile.get(subPile.size()-1);
            for(Foundation foundation: foundations.values()){
                if(!bottomMostCard.canStackOnFoundation(foundation)) continue;
                foundation.addAll(subPile);
                currentPile.removeAll(subPile);
                return true;
            }
            
            for(Pile pile:piles){
                if(pile == currentPile) continue;
                Card top = pile.isEmpty() ? null : pile.peekTopCard();
                if(bottomMostCard.canStackOn(top) && !previousMoves.contains(bottomMostCard, top)){
                    pile.addAll(subPile);
                    currentPile.removeAll(subPile);
                    previousMoves.add(bottomMostCard, top);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean hasWon(){
        return deck.isEmpty() && waste.isEmpty() && piles.stream().allMatch(Pile::isEmpty);
    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();

        ret.append("FOUNDATIONS:\n");
        for(Map.Entry<CardSuit, Foundation> foundation:foundations.entrySet()){
            ret.append("\t").append(foundation.getKey()).append(": ");
            ret.append(foundation.getValue());
            ret.append("\n");
        }
        
        ret.append("PILES:\n");
        for(Pile pile: piles){
            ret.append("\tPile ").append(piles.indexOf(pile)+1).append(": ");
            ret.append(pile);
            ret.append("\n");
        }
        
        ret.append("DECK:\n\t");
        for(Card c: deck.getCards()) ret.append(c);
        ret.append("\n");
        
        ret.append("WASTE:\n\t");
        for(Card c: waste) ret.append(c);
        ret.append("\n");
        return ret.toString();
    }
}
