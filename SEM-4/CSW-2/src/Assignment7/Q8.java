package Assignment7;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Q8 {
    public static void main(String[] args) {
        System.out.println("Before formatting:- ");
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Formatted result:- ");
        System.out.println(dt.format(formatter));
    }
}
