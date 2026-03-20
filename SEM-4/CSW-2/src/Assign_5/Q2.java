package Assign_5;

import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        String originalStr = "Hello";
        String modifiedStr = originalStr.concat("World");
        System.out.println("String immutability:- ");
        System.out.println(originalStr);
        System.out.println(modifiedStr);

        CharSequence seq = "Hello World";
        System.out.println(seq.length());
        System.out.println(seq.charAt(4));
        System.out.println(seq.subSequence(0,5));
    }
}
