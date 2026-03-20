package Assignment7.Q6;

import java.util.function.Function;

public class Q6 {
    static Function<Integer,Integer> getFactorial() {
        return n -> {
            if(n < 0) {
                throw new IllegalArgumentException("Error: Factorial can't be calculated for number less than 0");
            }
            int result = 1;
            for(int i = 2; i <= n; i++) {
                result = result * i;
            }
            return result;
        };
    }
    public static void main(String[] args) {

    }
}
