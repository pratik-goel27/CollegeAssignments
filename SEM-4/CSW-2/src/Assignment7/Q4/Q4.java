package Assignment7.Q4;

import java.util.Scanner;

interface Shape {
    double area();

    default void printArea() {
        System.out.println("Area:- "+area());
    }
}

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double radius = 5;
        Shape circle = () -> Math.PI * radius * radius;
        System.out.print("Circle ->");
        circle.printArea();

        double l = 10;
        double b = 15;
        Shape rectangle = () -> l*b;
        System.out.print("Rectangle ->");
        rectangle.printArea();

        double s = 10;
        Shape square = () -> s*s;
        System.out.print("Square ->");
        square.printArea();
    }
}