package Assign_2.Part1.Q7;

import java.util.Arrays;
import java.util.Scanner;

public class Student {
    private String name;
    private int rollNo;
    private int age;

    public Student(String name, int rollNo, int age) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Students you want to enter:- ");
        int n = sc.nextInt();
        Student[] arr = new Student[n];
        for(int i = 0; i < n; i++) {
            System.out.println("Enter the Student details:- ");
            Student s = new Student(sc.next(),sc.nextInt(),sc.nextInt());
            arr[i] = s;
        }
        //Sorting based on age:-
        Arrays.sort(arr, new sortByAge());
        System.out.println("Sorting based on age:- ");
        for(int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }

        //Sorting based on roll:-
        Arrays.sort(arr, new sortByRoll());
        System.out.println("Sorting based on roll:- ");
        for(int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
