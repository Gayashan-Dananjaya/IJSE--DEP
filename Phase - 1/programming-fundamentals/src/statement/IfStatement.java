package statement;

import java.util.Scanner;

public class IfStatement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter an integergreater than 25 : ");
        int num = scanner.nextInt();

        if (num > 25) System.out.println("Valid number is " + num);
        else if (num > 15) System.out.println("greater than 15");
        else System.out.println("Small number");
        int number = (25>20) ? 10:20;
        System.out.println(number);
    }
}
