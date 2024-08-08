package com.abaddon16;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Solitaire here we come");
        
        boolean hasWon = false;
        int round = 0;
        while(!hasWon){
            Table z = new Table();
            round++;
//            System.out.println("Start=================================================================");
//            System.out.println("New Table...");
//            System.out.println(z);
            z.tryAndWin();
//            System.out.println(z);
//            System.out.println("End  =================================================================");
            hasWon = z.hasWon();
            System.out.println("Round "+round+": "+(hasWon?"SUCCESS!!!":"Failure"));
        }
    }
}
