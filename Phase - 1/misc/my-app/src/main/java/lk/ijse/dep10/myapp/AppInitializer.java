package lk.ijse.dep10.myapp;

import java.sql.SQLOutput;
import java.util.Scanner;

public class AppInitializer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("My friend please enter your name");
        String name = scanner.nextLine();
        System.out.printf("I am sorry %s, you are hacked", name);
    }
}
