package lk.ijse.dep10.regexp;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String contact;
        do {
            System.out.print("Enter a contact : ");
            contact = scanner.nextLine().strip();
        } while (!isValidContact(contact));
        System.out.println("Valid contact");

    }

    private static boolean isValidContact(String input) {
        return input.matches("([+](94)|0)\\d{2}-\\d{7}");
//        if (input.startsWith("+94")) input = input.substring(3);
//        else if (input.startsWith("0")) input = input.substring(1);
//        else return false;
//        if (input.length() != 10 || input.charAt(2) != '-') return false;
//        input = input.substring(0, 2) + input.substring(3);
//        for (char c : input.toCharArray()) {
//            if (!Character.isDigit(c)) return false;
//        }
//        return true;
    }

}
