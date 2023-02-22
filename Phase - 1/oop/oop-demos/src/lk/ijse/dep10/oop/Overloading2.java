package lk.ijse.dep10.oop;

public class Overloading2 {
    public static void main(String[] args) {
        B.myMethod(10L);
        B.myMethod("ABC");
        new B().myMethod();
        new B().myMethod(100);
        new B().myMethod(50L);
        new B().myMethod("sgh");
    }


}

class A {
    public static void myMethod(String something) {
        System.out.println("myMethod(string)");
    }
    public void myMethod(int something) {
        System.out.println("myMethod(string)");
    }
    public void myMethod() {
        System.out.println("myMethod(string)");
    }
}

class B extends  A{
    public static void myMethod(long something) {
        System.out.println("myMethod(int)");
    }
}
