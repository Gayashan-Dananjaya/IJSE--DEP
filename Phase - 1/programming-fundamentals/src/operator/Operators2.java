package operator;

public class Operators2 {
    public static void main(String[] args) {

        /*Binary operators*/
        int a =10;
        int b = 5;
         if (a++ < 5 & b++ > 2) {}

        System.out.println(a);
        System.out.println(b);

        /*Logical operators*/
        int c =10;
        int d = 5;
         if (c++ < 5 && d++ > 2) {}

        System.out.println(c);
        System.out.println(d);

        /*Ternary operators*/
        int e = 10;
        String value = (a < 5) ? "IJSE " + (10 + 15) : "Something " + (2 + 5);
        System.out.println(value);

    }
}
