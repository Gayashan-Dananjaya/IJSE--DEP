package method;

import java.util.Scanner;

public class MethodDemo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String name = scanner.nextLine();

        int totalMarks = 0;

        for (String subject : new String[]{"PF", "DBMS", "OOP"}) {
            totalMarks += requestMarks(subject);
        }

        System.out.printf("Total marks : %s\n", totalMarks);
        System.out.printf("Average marks : %s\n", totalMarks/3.0);
    }

    public static boolean isValidMarks(String input) {

        char[] chars = input.toCharArray();
        for (char c: chars) {
            if (!Character.isDigit(c)) return false;
        }
        int marks = Integer.parseInt(input);
        return marks >= 0 && marks <= 100;
    }

    public  static int requestMarks(String subject) {

        Scanner scanner = new Scanner(System.in);
        String input;
        boolean validInput;

        do {
            System.out.printf("Enter your marks for %s : ", subject);
            input = scanner.nextLine();
            validInput = isValidMarks(input);
            if (!validInput) System.out.println("Invalid marks, try again");
        } while (!validInput);
        return Integer.parseInt(input);

    }

}
