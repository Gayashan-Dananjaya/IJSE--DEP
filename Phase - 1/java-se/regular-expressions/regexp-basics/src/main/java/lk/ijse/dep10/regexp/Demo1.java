package lk.ijse.dep10.regexp;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nic;
        do {
            System.out.print("Enter a nic : ");
            nic = scanner.nextLine().strip();
        } while (!isValidNic(nic));
        System.out.println("Valid NIC");

    }

    private static boolean isValidNic(String input) {
        return input.toUpperCase().matches("\\d{9}V");
//        if (input.length() != 10 || !(input.charAt(9) == 'v' || input.charAt(9) == 'V')) return false;
//        for (char c : input.substring(0,9).toCharArray()) {
//            if (!Character.isDigit(c)) return false;
//        }
//        return true;
    }

}
