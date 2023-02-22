package lk.ijse.dep10.oop;

public class Overriding2 {
    public static void main(String[] args) {
        T t = new S();
        t.myMethod();
        t.myStaticMethod();


    }
}

class T {
    public static void myStaticMethod() {          //Hide
        System.out.println("T's static method");
    }

    public void myMethod() {                      // override (non-static method)
        System.out.println("T's myMethod");
    }
}

class S extends T {
    public static void myStaticMethod() {
        System.out.println("S's static method");
    }

    public void myMethod() {
        System.out.println("S's myMethod");
    }
}
