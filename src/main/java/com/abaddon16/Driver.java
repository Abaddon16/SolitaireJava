package com.abaddon16;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Solitaire here we come");
        
        Table t = new Table();
        System.out.println(t);
        System.out.println();
        t.dealCard();
        t.dealCard();
        t.dealCard();
        t.dealCard();
        System.out.println(t);
        System.out.println();
        t.recycleWaste();
        System.out.println(t);
    }
}
