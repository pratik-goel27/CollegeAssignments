package Assign_3.Q1;

public class NullPointException {
    public static void main(String[] args) {
        String str = "pratik12345";
        String str2 = "pratik";
        String str3 = null;
        try {
            extractAndDisplayNum(str);
            extractAndDisplayNum(str2);
            extractAndDisplayNum(str3);
        }catch(NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void extractAndDisplayNum(String str) {
        if(str == null || str.length() == 0) {
            throw new NullPointerException("String is either empty or null");
        }

        StringBuilder nstr = new StringBuilder();
        for(char ch : str.toCharArray()) {
            if(ch >= '0' && ch <= '9') {
                nstr.append(ch);
            }
        }

        if(nstr.length() > 0) {
            System.out.println("The numeric values in the string: "+nstr.toString());
        } else {
            System.out.println("No numeric values found in the String.");
        }
    }
}