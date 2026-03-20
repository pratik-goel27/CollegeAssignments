package Assign_3.Q2;

class CustomNullPointerException extends Exception {
    CustomNullPointerException(String msg) {
        super(msg);
    }
}

public class CustomNullPointException {
    public static void main(String[] args) {
        try {
            String str = null;
            if(str == null) {
                throw new CustomNullPointerException("String cannot be null");
            }
        }catch (CustomNullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}

