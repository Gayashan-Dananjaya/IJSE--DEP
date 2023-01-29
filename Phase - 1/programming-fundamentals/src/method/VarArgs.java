package method;

public class VarArgs {
    public static void main(String[] args) {
        String[] array = {"true"};
        myMethod(10,array);
        myMethod(10,"name", "age", "city");


    }

    public static void myMethod(int x, String... name) {

    }
}
