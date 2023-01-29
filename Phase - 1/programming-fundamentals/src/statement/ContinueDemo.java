package statement;

import java.util.Scanner;

public class ContinueDemo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your contact number : ");
        String contact = scanner.nextLine();
        boolean validcontact = true;

        if (contact.length() != 11 || contact.charAt(3) != '-') System.out.println("Invalid number.");
        else {
            char[] chars = contact.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (i==3) continue;
                if (!Character.isDigit(c)) validcontact = false;
            }
            System.out.println("Valid contact");
        }
    }
}
