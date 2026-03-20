package Assignment7.Q1;

interface StringProcessor {
    int method(String str);
}

public class Q1 {
    public static void main(String[] args) {
//        StringProcessor lengthCalc = (str) -> {
//          return str.length();
//        };
        //or
        StringProcessor lengthCalc = (str) -> str.length();
        String str1 = "Hello World!";
        int length = lengthCalc.method(str1);
        System.out.println("The length of the string "+str1+" is: "+length);
    }
}
