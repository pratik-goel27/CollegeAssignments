package Assign_2.Part2.Q6;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> t = new TreeSet<>();
        t.add(41);
        t.add(19);
        t.add(25);
        t.add(36);

        //Display the elements of the tree set:-
        System.out.println(t);

        //Checks the presence of a num in the list:-
        System.out.println("Enter a num: ");
        Integer num = sc.nextInt();
        boolean ans = t.contains(num);
        if(ans) {
            System.out.println("The Num "+num+" is present in the set");
        }else {
            System.out.println("The Num "+num+" is not present in the set");
        }

        //Remove a specified element from the tree set:-
        System.out.println("Enter the number which is to be deleted:- ");
        Integer a = sc.nextInt();
        t.remove(a);
        System.out.println(t);
    }
}