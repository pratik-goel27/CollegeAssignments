package Assign_4;

public class NullifiedReference {
    private String name;

    public NullifiedReference(String name) {
        this.name = name;
    }

    protected void finalize() {
        System.out.println(this.name);
    }
    public static void main(String[] args) {
        NullifiedReference nr = new NullifiedReference("Hello");
        nr = null;
        System.gc();
    }
}
