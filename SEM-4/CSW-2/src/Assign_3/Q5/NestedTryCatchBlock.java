package Assign_3.Q5;

import java.util.Scanner;

public class NestedTryCatchBlock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numerical characters:- ");
        String str = sc.nextLine();
        int num;
        try {
            num = Integer.parseInt(str);
            System.out.println("Converted String to Integer:- "+num);
            System.out.print("Enter the Num to divide with "+num+":- ");
            int num2 = sc.nextInt();
            try {
                double result = (double)num/num2;
                System.out.println("The result of the division: "+result);
            }catch (ArithmeticException e) {
                System.out.println("Error: Tried dividing a Number by 0.");
            }
        }catch(NumberFormatException e) {
            System.out.println("Error: The String does not contain a valid Integer.");
        }

    }
}
