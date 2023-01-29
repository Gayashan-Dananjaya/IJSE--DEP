package statement;

import java.util.Scanner;

public class BreakStatement2 {
    public static void main(String[] args) {
        System.out.printf("Enter the day : ");
        Scanner scanner = new Scanner(System.in);
        String day = scanner.nextLine().trim().toUpperCase();

        switch (day) {
            default:
                System.out.println("You entered invalid date");
                break;
            case ("MONDAY"):
                System.out.println("You entered Monday");
                break;
            case ("TUESDAY"):
                System.out.println("You entered Tuesday");
                break;
            case ("WEDNESDAY"):
                System.out.println("You entered Wednesday");
                break;
            case ("THURSDAY"):
                System.out.println("You entered Thursday");
                break;
            case ("FRIDAY"):
                System.out.println("You entered Friday");
                break;
            case ("SATURDAY"):
                System.out.println("You entered Saturday");
                break;
            case ("SUNDAY"):
                System.out.println("You entered Sunday");
                break;
        }
    }
}
