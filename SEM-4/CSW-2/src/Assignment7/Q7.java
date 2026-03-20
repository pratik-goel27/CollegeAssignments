package Assignment7;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Q7 {
    public static void main(String[] args) {
        LocalDate currDate = LocalDate.now();
        LocalTime currTime = LocalTime.now();
        System.out.println("Today's date:- "+currDate);
        System.out.println("Current time:- "+currTime);
        System.out.println("Date that is 2 weeks from today:- "+currDate.plusWeeks(2));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(currDate.format(formatter));
    }
}
