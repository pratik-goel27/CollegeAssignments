package Assignment7.Q5;

import java.util.function.Function;

public class Q5 {
    static Function<Integer,Integer> getSquare() {
        return x -> x*x;
    }

    public static void main(String[] args) {
        Function<Integer,Integer> square = getSquare();
        int[] arr = {2,4,6,8};
        for(int num : arr) {
            int result = square.apply(num);
            System.out.println("Square of "+num+" is: "+result);
        }
    }
}