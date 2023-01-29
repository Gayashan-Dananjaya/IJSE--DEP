package lk.ijse.dep10;

import javax.swing.*;
import java.io.DataInput;
import java.util.Scanner;

public class HelloOOP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyClass myClass = new MyClass(10);

        JFrame myFrame = new JFrame("My Frame");

        myFrame.setSize(500, 500);
        myFrame.setVisible(true);
        myFrame.setLocationRelativeTo(null);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}

