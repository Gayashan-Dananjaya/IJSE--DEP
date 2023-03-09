package lk.ijse.dep10.regexp;

import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dob;
        do {
            System.out.print("Enter a DOB (yyyy-mm-dd) : ");
            dob = scanner.nextLine().strip();
        } while (!isValidDOB(dob));
        System.out.println("Valid dob");


    }

    private static boolean isValidDOB(String input) {
        return input.matches("(19\\d{2}|2\\d{3})-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[0-1])");
//        if (input.length() != 10 || input.charAt(4) != '-' || input.charAt(7) != '-') return false;
//        int year = 0;
//        int month = 0;
//        int date = 0;
//        try {
//            year = Integer.parseInt(input.substring(0, 4));
//            month = Integer.parseInt(input.substring(5, 7));
//            date = Integer.parseInt(input.substring(8));
//        } catch (Exception e) {
//            return false;
//        }
//        if (year < 1900 || month < 1 || month > 12 || date < 1 || date > 31) return false;
//        return true;
    }

}
