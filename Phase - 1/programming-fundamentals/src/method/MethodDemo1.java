package method;

public class MethodDemo1 {
    public static void main(String[] args) {
        myMethod();
        myMethod();
        myMethod();
        print("ijse");
    }

    public static void myMethod () {
        System.out.println("IJSE");
        System.out.println("_____________");
        System.out.println("IJSE");
        System.out.println("_____________");

    }

    public static void print(String something) {
        System.out.println("###################");
        System.out.println(something.toUpperCase());
        System.out.println("###################");
    }

}
