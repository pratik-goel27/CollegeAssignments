package Assignment7;

import java.time.LocalDate;
import java.util.Scanner;

public class Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the start date in the format of (dd/MM/yyyy):- ");
        String startDate = sc.nextLine();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ld = LocalDate.parse(sc.nextLine());
        System.out.println(ld);
        System.out.println("Initial amount:- ");
        double initAmt = sc.nextDouble();

    }
}
