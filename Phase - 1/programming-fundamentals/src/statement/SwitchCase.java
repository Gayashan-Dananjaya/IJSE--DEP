package statement;

import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your grade : ");
        char grade = scanner.nextLine().charAt(0);

//        if (grade == 'a' || grade == 'A') System.out.println("Pass A!");
//        else if (grade == 'b' || grade == 'B') System.out.println("Pass B");
//        else if (grade == 'b' || grade == 'B') System.out.println("Pass C");


        switch (grade) {
            case 'a':
            case 'A':
                System.out.println("Pass A");
                break;
            case 'B':
            case 'b':
                System.out.println("Pass B");
                break;
            case 'C':
            case 'c':
                System.out.println("Pass C");
                break;
      }


    }
}
