package Assign_2.Part1.Q4;

import java.util.Scanner;

public class Student implements Comparable<Student>{
    private String name;
    private int rollNumber;
    private float totalMark;

    public Student(String name, int rollNumber, float totalMark) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.totalMark = totalMark;
    }

    public Student() {
        super();
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String toString() {
        return name+"--"+rollNumber+"--"+totalMark;
    }

    public int compareTo(Student obj) {
        int s1 = this.getRollNumber();
        Student s = (Student) obj;
        int s2 = s.getRollNumber();
        if(s1 > s2) {
            return +1;
        }else if(s1 < s2) {
            return -1;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Students you want to enter:- ");
        int n = sc.nextInt();
        Student[] arr = new Student[n];
        for(int i = 0; i < n; i++) {
            System.out.println("Enter the Student details:- ");
            Student s = new Student(sc.next(),sc.nextInt(),sc.nextFloat());
            arr[i] = s;
        }

        System.out.println("Enter the Student details which is to be searched:- ");
        Student s = new Student();
        int roll = sc.nextInt();
        s.setRollNumber(roll);
        for(int i = 0; i < n; i++) {
            if(arr[i].compareTo(s) == 0) {
                System.out.println("The specified Student "+arr[i].getName()+" is present in the list");
            }
        }
    }
}
