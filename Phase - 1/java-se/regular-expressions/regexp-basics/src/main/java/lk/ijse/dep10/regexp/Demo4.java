package lk.ijse.dep10.regexp;

import java.util.Arrays;
import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {
        String someText = "Here is my nic: 123456789v";
        System.out.println(isValidNic(someText));
        someText = someText.replaceFirst("\\d{9}[vV]", "xxx xxx xxx");
        System.out.println(someText);
        String[] split = someText.split("\\b");
        System.out.println(Arrays.toString(split));
    }

    private static boolean isValidNic(String input) {
        return input.toUpperCase().matches("\\d{9}V");
    }

}
