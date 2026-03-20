package Assign_5;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        while(true) {
            System.out.println("Current Text: \"" + sb + "\"");
            System.out.println("Length: "+sb.length()+", Capacity: "+sb.capacity());
            System.out.println("1. Append a given String to the existing text.");
            System.out.println("2. Insert a given String at a specified index withing the existing text.");
            System.out.println("3. Delete a portion of text between two specified indices.");
            System.out.println("4. Reverse the entire text.");
            System.out.println("5. Replace a portion of the text between two specifies indices with a given string.");
            System.out.println("6. Exit");
            System.out.println("Enter your choice:- ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter a String:- ");
                    String appStr = sc.nextLine();
                    sb.append(appStr);
                    break;
                case 2:
                    System.out.println("Enter a String:- ");
                    String insStr = sc.nextLine();
                    System.out.println("Enter the index:- ");
                    int idx = sc.nextInt();
                    try {
                        sb.insert(idx, insStr);
                    }catch (StringIndexOutOfBoundsException e) {
                        System.out.println("Error: Invalid indices.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the starting index:- ");
                    int s = sc.nextInt();
                    System.out.print("Enter the ending index:- ");
                    int e = sc.nextInt();
                    try {
                        sb.delete(s,e);
                    }catch (StringIndexOutOfBoundsException err) {
                        System.out.println("Error: Invalid indices.");
                    }
                    break;
                case 4:
                    sb.reverse();
                    break;
                case 5:
                    System.out.print("Enter the String:- ");
                    String str = sc.nextLine();
                    System.out.print("Enter the start index:- ");
                    int si = sc.nextInt();
                    System.out.print("Enter the ending index:- ");
                    int ei = sc.nextInt();
                    try {
                        sb.replace(si,ei,str);
                    }catch (StringIndexOutOfBoundsException err) {
                        System.out.println("Error: Invalid indices.");
                    }
                    break;
                case 6:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }
}