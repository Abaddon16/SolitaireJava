package com.abaddon16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Table{
    private final List<Foundation> foundations = new ArrayList<>(4);
    private final Deck deck = new Deck();
    private final Waste waste = new Waste();
    private final List<Pile> piles= new ArrayList<>(7);
    private TableState currentState;
    
    public Table(){
        for(int i = 0; i< 7; i++){
            piles.add(new Pile());
            List<Card> tempPile = new ArrayList<>(i+1);
            for(int j = 0; j<=i; j++) tempPile.add(deck.getTopCard());
            piles.get(i).addCards(tempPile);
        }
        updateTableState();
    }
    
    public void dealCard(){
        Card card = deck.getTopCard();
        waste.addCard(card);
    }
    
    public void recycleWaste(){
        List<Card> wasteCards = new ArrayList<>(waste.getCards());
        Collections.reverse(wasteCards);
        deck.addCards(wasteCards);
        waste.clear();
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Foundations:\n");
        foundations.forEach(f->sb.append("\t").append(f).append("\n"));
        
        sb.append("\nDeck:\n").append(shapeCardStack(deck));
        sb.append("\nWaste:\n").append(shapeCardStack(waste));
        
        sb.append("\nPiles:\n");
        piles.forEach(p->sb.append("\t").append(p).append("\n"));
        
        return sb.toString();
    }
    
    private String shapeCardStack(ICardPile cardPile){
        List<Card> cards = new ArrayList<>(cardPile.getCards());
        int cardsPerRow = 8;
        StringBuilder sb = new StringBuilder();
        
        while(!cards.isEmpty()){
            sb.append("\t");
            for(int i = 0; i<cardsPerRow; i++)
            {
                if(cards.isEmpty()) break;
                sb.append(cards.remove(0));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
    private void updateTableState(){
        currentState = new TableState(foundations, deck, waste, piles);
    }
    
    private record TableState(List<Foundation> foundations, Deck deck, Waste waste, List<Pile> piles){}
}


