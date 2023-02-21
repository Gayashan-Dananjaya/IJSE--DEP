package lk.ijse.dep10.app;

public class Demo1 {
    public static void main(String[] args) {
//        System.out.println(10/0);

//        int x = Integer.parseInt("abc");
//        System.out.println(x);

//        String something = null;
//        System.out.println(something.length());

//        Class.forName("abc");

        myMethod1();

    }

    public static void myMethod1() {
        System.out.println("0");
        myMethod2();
        System.out.println("d");
    }
    public static void myMethod2() {
        try {
            System.out.println("a");
            Class.forName("abc");
            System.out.println("b");
        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
            System.out.println("catch");
        }
        System.out.println("c");
    }
//    public static void myMethod1() {
//        System.out.println("0");
//        try {
//            myMethod2();
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("d");
//    }
//    public static void myMethod2() throws ClassNotFoundException {
//        Class.forName("abc");
//    }
}
