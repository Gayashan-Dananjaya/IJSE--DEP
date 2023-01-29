package miscelaneous;

import java.util.Scanner;

public strictfp class  StandardStream3 {
    public static  void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("_______________________________________");
        System.out.println("               Mark Sheet");
        System.out.println("_______________________________________");

        System.out.print("Enter your name\t\t\t\t: ");
        String name = scanner.nextLine();
        System.out.print("Enter your marks for PL\t\t: ");
        int pl = scanner.nextInt();
        System.out.print("Enter your marks for DBMS\t: ");
        int dbms = scanner.nextInt();
        System.out.print("Enter your marks for OOP\t: ");
        int oop = scanner.nextInt();
        System.out.print("Enter your Networking\t\t: ");
        int networking = scanner.nextInt();

        int total = pl+dbms+oop+networking;
        System.out.printf("%s's total marks\t\t: %s\n",name, total);


        Double avg = (double) total/ (double) 4;
        System.out.printf("%s's average \t\t\t: %s\n", name, avg);

        System.out.println("_______________________________________");

    }
}
