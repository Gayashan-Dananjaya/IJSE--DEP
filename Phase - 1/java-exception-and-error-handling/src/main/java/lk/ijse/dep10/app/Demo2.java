package lk.ijse.dep10.app;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your NIC : ");
        String input = scanner.nextLine();

        if (input.length() != 10) {
            System.out.println("Invalid NIC");
            return;
        }

        String first9Chars = input.substring(0, input.length() - 1);
        if (isInteger(first9Chars) && (input.endsWith("V") || input.endsWith("v"))) System.out.println("valid NIC");
        else System.out.println("Invalid NIC");
    }

    public static boolean isInteger(String input) {
//        for (char c : input.toCharArray()) {
//            if (!Character.isDigit(c)) return false;
//        }
//        return true;
        try {
            Integer.parseInt(input);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }

    }
}
