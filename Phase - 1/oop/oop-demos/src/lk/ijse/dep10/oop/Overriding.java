package lk.ijse.dep10.oop;

public class Overriding {
    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.myStaticMethod();
        Super mySuper = sub;
        mySuper.myStaticMethod();

    }
}

class Super {
    public static void myStaticMethod() {
        System.out.println("Super: myStatic Method");
    }
}

class Sub extends Super {
    public static void myStaticMethod() {
        System.out.println("Sub: myStatic Method");
    }
}
