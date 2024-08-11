package com.abaddon16;

import java.util.List;

public class Pile extends ACardPile {
    public Pile(){}
    
    @Override
    public void add(Card card){
    
    }
    
    @Override
    public boolean canCardStack(Card card){
        return false;
    }
    
    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        for(int i = cards.size()-1; i>=0; i--) ret.append(cards.get(i));
        return ret.toString();
    }
}
