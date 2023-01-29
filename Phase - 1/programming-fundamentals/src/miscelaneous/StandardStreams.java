package miscelaneous;

import java.util.Scanner;

public class StandardStreams {

    public static void main(String[] args) {
        System.err.println("IJSE");
        System.out.println("IJSE");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String input = scanner.nextLine();
        System.out.print("Good morning " + input + " !");
    }

}
