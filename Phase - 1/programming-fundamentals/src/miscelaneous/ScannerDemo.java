package miscelaneous;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter something : ");
        scanner.useDelimiter("-");
        String token1 = scanner.next();
        String token2 = scanner.next();
        String rest = scanner.nextLine();

        System.out.println(token1);
        System.out.println(token2);
        System.out.println(rest);



    }
}
