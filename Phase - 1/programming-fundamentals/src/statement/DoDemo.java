package statement;

import java.util.Scanner;

public class DoDemo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num;
        do {
            System.out.print("Enter a positive number : ");
            num = scanner.nextInt();
            if (num <= 0 ) System.out.println("Invalid number!");
        } while (num <= 0);

        System.out.printf("Positive number is : %s", num);
    }
}
