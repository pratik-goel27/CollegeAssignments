package Assign_1.Q1;

public class Car {
    private String model;
    private String name;

    public Car(String name , String model) {
        this.model = model;
        this.name = name;
    }

    public Car() {}

    public void setModel(String model) {
        this.model = model;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return this.model;
    }

    public String getName() {
        return this.name;
    }
}
