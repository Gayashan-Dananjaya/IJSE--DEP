package statement;

import java.util.Scanner;

public class IfStatement2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter student age : ");
        int age = scanner.nextInt();
        if (age < 18) System.out.println("Invalid age");
        else if (age >= 40) System.out.println("Invalid age");
        else System.out.println("Valid age");

        switch (age) {
            case  10:
                System.out.println("sjfgsg");
        }
        }
    }
