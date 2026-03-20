package Assign_3.Q4;

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive Num:- ");
        try {
            int num = sc.nextInt();
            if (num < 0) {
                throw new ArithmeticException("Error: cannot find the square root of a negative number");
            }
            double sqrRt = Math.sqrt(num);
            System.out.println("Square root of num "+num+" is: "+sqrRt);
        }catch(ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
