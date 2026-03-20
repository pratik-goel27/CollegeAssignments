package Assign_4;

public class ReassigningReference {
    private String name;

    public ReassigningReference(String name) {
        this.name = name;
    }

    protected void finalize() throws Throwable {
        System.out.println("Object destroyed successfully");
    }

    public static void main(String[] args) {
        ReassigningReference r1 = new ReassigningReference("Pratik");
        ReassigningReference r2 = new ReassigningReference("Abhishek");
        r1 = r2;
        System.gc();
    }
}
