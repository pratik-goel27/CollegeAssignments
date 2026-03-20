package Assign_3.Q9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an Integer value:- ");
        try {
            int num = sc.nextInt();
            System.out.println("Your input: "+num);
        }catch(InputMismatchException e) {
            System.out.println("Error: You should have entered Integer value.");
        }

        System.out.println("End of program.");
    }
}