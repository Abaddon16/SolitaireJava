package com.abaddon16;

import java.util.ArrayList;
import java.util.List;

public class Table{
    private final List<Foundation> foundations = new ArrayList<>(4);
    private final Deck deck = new Deck();
    private final Pile waste = new Pile();
    private final List<Pile> stacks = new ArrayList<>(7);
    private TableState currentState;
    
    private record TableState(List<Foundation> foundations, Deck deck, Pile waste, List<Pile> stacks){}
}


