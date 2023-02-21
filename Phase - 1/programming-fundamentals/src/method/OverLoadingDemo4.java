package method;

import com.sun.jdi.FloatValue;

public class OverLoadingDemo4 {
    public static void main(String[] args) {
        byte x = 10;
        short y = 11;
        int z = 15;
        float a = 30;

        myMethod(x,y,z,a);
    }

    public static void myMethod(Short x, float y, float z, float a) {
        System.out.println("A");
    }
    public static void myMethod(int x, float y, Double z, float a) {
        System.out.println("B");
    }
    public static void myMethod(short x, Float y, double z, float a) {
        System.out.println("C");
    }
    public static void myMethod(short x, short y, Integer z, float a) {
        System.out.println("D");
    }
//    public static void myMethod(Byte x, Short y, Integer z, Float a) {
//        System.out.println("E");
//    }
}
