package com.oca;

public class InitializationOrderSimple {

    private String name = "Filip";

    {
        System.out.println("Ovo je prvi");
    }

    private static int COUNT = 0;

    static {
        System.out.println("Ovo je drugi" + COUNT);
    }

    static {
        COUNT += 10;
        System.out.println("Ovo je treci" + COUNT);
    }

    public InitializationOrderSimple() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
//        InitializationOrderSimple initializationOrderSimple = new InitializationOrderSimple();
    }

}

