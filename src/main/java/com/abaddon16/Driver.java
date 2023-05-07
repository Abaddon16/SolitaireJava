package com.abaddon16;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Solitaire here we come");

        Table z = new Table();
        z.fillFoundations();
        z.fillFoundations();
        z.fillFoundations();
        z.fillFoundations();
        z.fillFoundations();
        z.fillFoundations();
        System.out.println(z);
    }
}
