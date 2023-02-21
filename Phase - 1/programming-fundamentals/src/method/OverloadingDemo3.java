package method;

public class OverloadingDemo3 {
    public static void main(String[] args) {
        short x = 10;
        int y = 20;
//        myMethod(x,y);
    }

//    public static void myMethod(int x, int y) {
//        System.out.println("myMethod (int, int)");
//    }
    public static void myMethod(int x, long y) {
        System.out.println("myMethod (int, long)");
    }
    public static void myMethod(long x, int y) {
        System.out.println("myMethod (long, int)");
    }
    public static void myMethod(int x, double y) {
        System.out.println("myMethod (int, double)");
    }
}
