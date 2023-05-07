package com.abaddon16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
    Map<CardSuit, List<Card>> foundations = new HashMap<>(4);
    Deck deck = new Deck();
    List<Card> waste = new ArrayList<>(24);
    List<List<Card>> piles = new ArrayList<>(7);

    public Table(){
        for(CardSuit x:CardSuit.values()) foundations.put(x, new ArrayList<>(13));
        for(int i=0; i<7; i++) piles.add(i, new ArrayList<>(20));
        for(int i = 0; i<7; i++){
            for(int j = 0; j<i+1; j++) piles.get(i).add(deck.pop());
        }
    }

    private void cycleDeckToWaste(){
        Card x = deck.pop();
        if(x!=null) waste.add(x);
    }
    private void recycleWaste(){
        deck.resetWaste(waste);
        waste.clear();
    }
    public void fillFoundations(){
        boolean stillLooking = true;
        while(stillLooking){
            stillLooking = false;
            for(List<Card> pile:piles){
                Card x = pile.isEmpty()?null:pile.get(pile.size()-1);
                if(x==null) continue;
                stillLooking = checkCardCanMove(x, pile);
            }

            Card x = waste.isEmpty()?null:waste.get(waste.size()-1);
            if(x==null){
                cycleDeckToWaste();
                x = waste.isEmpty()?null:waste.get(waste.size()-1);
            }
            if(x==null) continue;
            stillLooking = checkCardCanMove(x, waste);
        }
    }

    private boolean checkCardCanMove(Card x, List<Card> collection){
        boolean stillLooking = false;
        List<Card> foundation = foundations.get(x.suit);
        if((foundation.isEmpty() && x.canStackOn(null)) || (!foundation.isEmpty() && x.canStackOn(foundation.get(foundation.size()-1)))){
            foundation.add(x);
            collection.remove(x);
            stillLooking = true;
        }
        return stillLooking;
    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();

        ret.append("FOUNDATIONS:\n");
        for(Map.Entry<CardSuit, List<Card>> foundation:foundations.entrySet()){
            ret.append("\t").append(foundation.getKey()).append(": ");
            for(Card c:foundation.getValue()) ret.append(c);
            ret.append("\n");
        }
        ret.append("PILES:\n");
        for(List<Card> pile: piles){
            ret.append("\tPile ").append(piles.indexOf(pile)+1).append(": ");
            for(Card c:pile) ret.append(c);
            ret.append("\n");
        }
        ret.append("DECK:\n\t");
        for(Card c: deck.getCards()) ret.append(c);
        ret.append("\n");
        ret.append("WASTE:\n\t");
        for(Card c: waste) ret.append(c);
        return ret.toString();
    }
}
