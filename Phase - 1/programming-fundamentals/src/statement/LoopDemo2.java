package statement;

import java.util.Scanner;

public class LoopDemo2 {
    public static void main(String[] args) throws InterruptedException {

        boolean enteredNumberType = true;
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        for (; enteredNumberType; ) {
            System.out.print("Enter a number to proceed : ");
            number = scanner.nextInt();
            if (number >= 1 && number <= 100) {
                enteredNumberType = false;
            } else System.out.println("Invalid Number!");
        }

        boolean speedType = true;
        int speed = 0;
        int delay = 0;
        for (; speedType; ) {
            System.out.print("Progress speed\n(1) Fast\n(2) Medium\n(3) Slow\nSelect the speed : ");
            speed = scanner.nextInt();
            if (speed == 1 || speed == 2 || speed == 3) speedType = false;
            else System.out.println("Enter a valid speed.");
        }
        switch (speed) {
            case 1:
                delay = 50;
                break;
            case 2:
                delay = 100;
                break;
            case 3:
                delay = 150;
                break;
        }

        int length = 0;
        for (int i = 0; i <= number; i++) {
            System.out.print("Progress: ");                         //length = 10 when completed
            int percentage = (i * 100)/number;
            System.out.printf("%s",percentage);                     //length = 3 when completed
            System.out.print("% [");                                //length = 3 when completed
            System.out.print("\u001b[42m");
            for (int j = 0; j < 25; j++) {
                System.out.print(" ");
                if (percentage/4<=(j+1)) System.out.print("\u001b[0m");
            }

            System.out.print("] ");
            System.out.printf("%s/%s",i, number);
            Thread.sleep(delay);

            if (percentage < 10) {
                length = 1 + 3 + 25 +2 + Integer.toString(i).length() + 1 + Integer.toString(number).length();
            }
            if (percentage >= 10 || percentage < 100) {
                length = 2 + 3 + 25 +2 + Integer.toString(i).length() + 1 + Integer.toString(number).length();
            }
            if (percentage == 100) {
                length = 3 + 3 + 25 +2 + Integer.toString(i).length() + 1 + Integer.toString(number).length();
            }
            System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        }
        System.out.println("Completed...!");
    }
}
