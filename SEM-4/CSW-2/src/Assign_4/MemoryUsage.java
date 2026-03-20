package Assign_4;

public class MemoryUsage {
    private int intVal;
    private double dblVal;

    public MemoryUsage(int intVal, double dblVal) {
        this.intVal = intVal;
        this.dblVal = dblVal;
    }

    public int getA() {
        return intVal;
    }

    public void setA(int intVal) {
        this.intVal = intVal;
    }

    public double getB() {
        return dblVal;
    }

    public void setB(double dblVal) {
        this.dblVal = dblVal;
    }

    public static void main(String[] args) {
        MemoryUsage obj1 = new MemoryUsage(10,20);
        MemoryUsage obj2 = new MemoryUsage(30,40);
        System.out.println("Before making objects eligible for GC:- ");
        Runtime r = Runtime.getRuntime();
        long totalMem = r.totalMemory();
        long freeMem = r.freeMemory();
        long occupiedMem = totalMem - freeMem;
        System.out.println("Total Memory:- "+totalMem+", Occupied Memory:- "+occupiedMem);
        obj1 = null;
        obj2 = null;
        System.gc();
        System.out.println("After making objects eligible for gc:- ");
        totalMem = r.totalMemory();
        freeMem = r.freeMemory();
        occupiedMem = totalMem - freeMem;
        System.out.println("Total Memory:- "+totalMem+", Occupied Memory:- "+occupiedMem);
    }
}
