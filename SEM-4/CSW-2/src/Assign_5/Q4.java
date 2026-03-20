package Assign_5;

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the inital String:- ");
        StringBuilder sb = new StringBuilder(sc.nextLine());
        while (true) {
            System.out.println("1. Add a substring at a specified position.");
            System.out.println("2. Remove a range of characters from the string.");
            System.out.println("3. Modify a character at a specified index.");
            System.out.println("4. Concatenate another string at the end.");
            System.out.println("5. Display the current String after each operation.");
            System.out.println("6. Exit");
            System.out.print("Enter your choice:- ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 1:
                    System.out.print("Enter the sub string:- ");
                    String subStr = sc.nextLine();
                    System.out.print("Enter the index:- ");
                    int pos = sc.nextInt();
                    try {
                        sb.insert(pos, subStr);
                    } catch (StringIndexOutOfBoundsException e) {
                        System.out.println("Error: Invalid index.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the starting index:- ");
                    int s = sc.nextInt();
                    System.out.println("Enter the ending index:- ");
                    int e = sc.nextInt();
                    try {
                        sb.delete(s,e);
                    }catch(StringIndexOutOfBoundsException err) {
                        System.out.println("Error: Invalid index.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the index:- ");
                    int idx = sc.nextInt();
                    System.out.print("Enter the character:- ");
                    char ch = sc.next().charAt(0);
                    try {
                        sb.setCharAt(idx,ch);
                    }catch (StringIndexOutOfBoundsException err) {
                        System.out.println("Error: Invalid index.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the String to concatenate:- ");
                    String str = sc.nextLine();
                    sb.append(str);
                    break;
                case 5:
                    System.out.println("Current String: \""+ sb.toString() +"\"");
                    break;
                case 6:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice please try again.");
                    break;
            }
        }
    }
}