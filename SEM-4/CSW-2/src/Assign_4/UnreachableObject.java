package Assign_4;
public class UnreachableObject {
    private String name;

    public UnreachableObject(String name) {
        this.name = name;
        System.out.println(name + " created.");
    }

    public void show() {
        UnreachableObject obj = new UnreachableObject("InnerObject1");
        obj.display(); obj = null;
    } 

    public void display() {
        UnreachableObject obj = new UnreachableObject("InnerObject2");
        obj = null; } protected void finalize() throws Throwable {
        System.out.println(name + " is garbage collected.");
        super.finalize();
    }

    public static void main(String[] args) {
        UnreachableObject obj = new UnreachableObject("OuterObject");
        obj.show();
        obj = null; System.gc();
    }
}