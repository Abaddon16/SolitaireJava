package com.abaddon16;

import java.util.ArrayDeque;
import java.util.Queue;

public class MoveHistory {
    
    private final int maxSize;
    private final ArrayDeque<PreviousMove> queue;
    
    public MoveHistory(int maxSize) {
        this.maxSize = maxSize;
        queue = new ArrayDeque<>(maxSize);
    }
    
    public void add(PreviousMove t) {
        if (queue.size() == maxSize) queue.removeFirst();
        queue.add(t);
    }
    
    public void add(Card moved, Object movedTo){
        add(new PreviousMove(moved, movedTo));
    }
    
    public boolean remove(PreviousMove t) {
        return queue.remove(t);
    }
    
    public boolean contains(PreviousMove t) {
        return contains(t.moved(), t.movedOnto());
    }
    
    public boolean contains(Card moved, Object movedTo) {
        boolean test1 = queue.contains(new PreviousMove(moved, movedTo));
        boolean test2 = movedTo instanceof Card secondCard && queue.contains(new PreviousMove(secondCard, moved));
        return test1 || test2;
    }
    
    @Override
    public String toString() {
        return queue.toString();
    }
}
