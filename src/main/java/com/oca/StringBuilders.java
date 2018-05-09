package com.oca;

public class StringBuilders {

    public static StringBuilder work(StringBuilder a, StringBuilder b) {
        a = new StringBuilder();
        b.append("b");
        return a;
    }

    void add(int integer) {

    }

    private StringBuilders() {

    }

    void doX(Integer... i) {

    }

    public static void main(String args[]) {

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        StringBuilder s3 = work(s1, s2);

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);

        StringBuilders sb = new StringBuilders();

        sb.add(100);

        sb.doX(5);
    }
}