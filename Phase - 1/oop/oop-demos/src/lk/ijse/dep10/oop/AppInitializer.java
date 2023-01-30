package lk.ijse.dep10.oop;

public class AppInitializer {

    static int x = 14;

    public AppInitializer() {
        System.out.println("This is constructor");
    }

    static {
        System.out.println("Static initializer 1");
        System.out.println(x);
//        System.out.println(y);    // Illegal forward referencing
    }


    public static void main(String[] args) {
//        new AppInitializer();
    }

    static int y = 20;

    static {
        System.out.println("Static initializer 2");
    }


}
