package Assign_3.Q6;

import java.util.Arrays;
import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {2,4,2,4,68,43,4,6,3};
        //Sorting:-
        System.out.println("Original array:- ");
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Array after sorting:- ");
        System.out.println(Arrays.toString(arr));
        //Searching:-
        System.out.print("Enter the Num which is to be searched:- ");
        int num = sc.nextInt();
        int ele = Arrays.binarySearch(arr,num);
        if(ele >= 0) {
            System.out.println("The num "+num+" is at the index: "+ele);
        }else {
            System.out.println("The num "+num+" is not present in the array");
        }
        //Accessing:-
        System.out.print("Enter the index which is to accessed:- ");
        int idx = sc.nextInt();
        try {
            System.out.println("Element at the index "+idx+" is: "+arr[idx]);
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: tried to access an index out of bounds");
        }

        System.out.println("Program execution complete");
        sc.close();
    }
}
