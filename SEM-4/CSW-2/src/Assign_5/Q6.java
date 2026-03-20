package Assign_5;

import java.util.Arrays;
import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String:- ");
        String str = sc.nextLine();
        char[] charArr = str.toCharArray();
        System.out.print("Enter the character to search in the String:- ");
        char ch = sc.next().charAt(0);
        int firstOcurr = -1;
        int lastOccur = -1;
        for(int i = 0; i < charArr.length; i++) {
            if(charArr[i] == ch) {
                if (firstOcurr == -1) {
                    firstOcurr = i;
                }
                lastOccur = i;
            }
        }
        System.out.println("character Array:- ");
        System.out.println(Arrays.toString(charArr));
        if(firstOcurr == -1) {
            System.out.println("The character "+ch+" is present in the String.");
        }else {
            System.out.println("The first occurrence of the character "+ch+" is at the index: "+firstOcurr);
            System.out.println("The last occurrence of the character "+ch+" is at the index: "+lastOccur);
        }
        sc.close();
    }
}