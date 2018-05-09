package com.oca;

public class RopeSwing {

    public static Rope rope1 = new Rope();

    public static Rope rope2 = new Rope();

    {
        System.out.println(Rope.length);
    }

    public static void main(String args[]) {

        RopeSwing ropeSwing = new RopeSwing();
        rope1.length = 2;
        rope2.length = 8;

        System.out.println(Rope.length);

        Rope.length = 10;

        System.out.println(rope1.length);

    }
}

class Rope {

    public static int length = 0;

}