package Assign_5;

import java.util.Scanner;

public class Case_Conversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first String:- ");
        String str1 = sc.nextLine();
        System.out.print("Enter the second String:- ");
        String str2 = sc.nextLine();
        String str1Lower = str1.toLowerCase();
        String str2Lower = str2.toLowerCase();
        String str1Upper = str1.toUpperCase();
        String str2Upper = str2.toUpperCase();
        boolean areEqual = str1Lower.equals(str2Lower);
        System.out.println("\nConverted Strings:");
        System.out.println("First String -> Lowercase: " + str1Lower + " | Uppercase: " + str1Upper);
        System.out.println("Second String -> Lowercase: " + str2Lower + " | Uppercase: " + str2Upper);
        System.out.println("\nCase-insensitive comparison result: " + (areEqual ? "Equal" : "Not Equal"));
        sc.close();
    }
}