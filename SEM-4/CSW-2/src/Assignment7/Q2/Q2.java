package Assignment7.Q2;

interface Calculator {
    double operate(double a, double b);
}

public class Q2 {
    public static void main(String[] args) {
        Calculator add = (a,b) -> a+b;
        Calculator subtract = (a,b) -> a-b;
        Calculator multiply = (a,b) -> a*b;
        Calculator divide = (a,b) -> {
            try {
                return a/b;
            }catch (ArithmeticException e) {
                System.out.println("Error: Cannot divide a number by 0");
                return 0;
            }
        };

        System.out.println("Addition:- "+add.operate(5,10));
        System.out.println("Subtraction:- "+subtract.operate(5,10));
        System.out.println("Multiplication:- "+multiply.operate(5,10));
        System.out.println("Division:- "+divide.operate(5,10));
    }
}