package Assign_5;

public class Q1 {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        String str4 = new String("Hello");
        System.out.println("Using == operator: ");
        System.out.println("str1 == str2: "+(str1 == str2));
        System.out.println("str2 == str3: "+(str2 == str3));
        System.out.println("str2 == str3: "+(str3 == str4));
        System.out.println("Using .equals() method:- ");
        System.out.println("str1.equals(str2): "+str1.equals(str2));
        System.out.println("str2.equals(str3): "+str2.equals(str3));
        System.out.println("str3.equals(str4): "+str3.equals(str4));
    }
}
