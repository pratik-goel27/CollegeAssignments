package Assign_4;

public class AnonymousObject {
    private String name;

    public AnonymousObject(String name) {
        this.name = name;
    }

    protected void finalize() throws Throwable {
        System.out.println(this.name);
    }
    public static void main(String[] args) {
        AnonymousObject ao = new AnonymousObject("Lassi");
        System.gc();
    }
}