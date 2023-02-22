package lk.ijse.dep10.app;

public class Demo3 {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("111111");
        myMethod1();
        System.out.println("222222");
    }

    public static void myMethod1() throws ClassNotFoundException{
        System.out.println("Entering myMethod1");
        myMethod2();
        System.out.println("Leaving myMethod1");
        try {
            throw new ClassNotFoundException();
        } catch (ClassNotFoundException e) {
            System.out.println("Exception");
        }
    }
    public static void myMethod2() {
        System.out.println("Entering myMethod2");
        myMethod3();
        System.out.println("Leaving myMethod2");
    }
    public static void myMethod3() {
        System.out.println("Entering myMethod3");
        System.out.println("Leaving myMethod3");
    }
}
