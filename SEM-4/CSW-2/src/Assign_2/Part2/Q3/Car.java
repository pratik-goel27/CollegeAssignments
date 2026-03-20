package Assign_2.Part2.Q3;

public class Car implements Comparable<Car> {
    private int modelNo;
    private String name;
    private int stock;

    public Car(int modelNo, String name, int stock) {
        this.modelNo = modelNo;
        this.name = name;
        this.stock = stock;
    }

    public String toString() {
        return modelNo+"--"+name+"--"+stock;
    }

    public int compareTo(Car car) {
        int s1 = this.stock;
        int s2 = car.stock;
        if(s1 < s2) {
            return -1;
        }else if(s1 > s2) {
            return +1;
        }else {
            return 0;
        }
    }
}