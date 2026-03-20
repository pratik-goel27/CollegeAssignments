package Assign_3.Q3;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        stringToInteger();
    }

    public static void stringToInteger() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Enter a valid numeric value: ");
            String input = sc.nextLine();
            try {
                int a = Integer.parseInt(input);   //this line might give error if the string does not contain any valid integer.
                System.out.println("Successfully converted String to Integer:- "+a);
                break;
            }catch(NumberFormatException e) {
                System.out.println("Invalid input try again");
            }
        }
    }
}
