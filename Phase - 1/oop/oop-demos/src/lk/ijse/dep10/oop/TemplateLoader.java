package lk.ijse.dep10.oop;

public class TemplateLoader {

    static {
        System.out.println("Template loader static initializer");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Template Loader Main");

        new MyTemplate();
        new MyTemplate();
        MyTemplate.doSomething();
        Class.forName("lk.ijse.dep10.oop.MyTemplate");


    }

}

class MyTemplate {
    static{
        System.out.println("MyTemplate static initializer");
    }

    public static void main(String[] args) {
        System.out.println("My Template Main()");
    }

    static void doSomething() {

    }

}
