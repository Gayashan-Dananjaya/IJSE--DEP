package miscelaneous;

import java.util.Scanner;

public class StandardStream2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("___________________________________________");
        System.out.println("             Student Details");
        System.out.println("___________________________________________");

        System.out.print("Enter your name \t\t\t: ");
        String name = scanner.nextLine();
        System.out.print("Enter your mobile number \t: ");
        String number = scanner.nextLine();
        System.out.print("Enter your batch number \t: ");
        int batch = scanner.nextInt();

        System.out.printf("Welcome %s - %s to batch %s.\n", name, number, batch);
//        System.out.println("Welcome " + name + " - " + number + " to batch " + batch + ".");
        System.out.println("___________________________________________");

    }
}
