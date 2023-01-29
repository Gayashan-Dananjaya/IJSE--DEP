package operator;

public class Operators3 {
    public static void main(String[] args) {

        int a = 5;
        int b = 2;
        int result = 120;

        a += a++ + b + --b + ~a + a * b + 10;
        b = (a > (a + ++b)) ? a++ : (b+=10) + ++b;
        result %= ((a++ + ++b) * 2);

        System.out.println(result);


    }
}
