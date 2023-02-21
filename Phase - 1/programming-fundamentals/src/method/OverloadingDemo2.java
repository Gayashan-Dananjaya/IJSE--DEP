package method;

public class OverloadingDemo2 {
    public static void main(String[] args) {
        long x = 10;
        myMethod(x);
    }

    public static void myMethod(int x) {
        System.out.println("myMethod (int)");
    }
//    public static void myMethod(long x) {
//        System.out.println("myMethod (long)");
//    }
//    public static void myMethod(float x) {
//        System.out.println("myMethod (float)");
//    }
    public static void myMethod(double x) {
        System.out.println("myMethod (double)");
    }
}
