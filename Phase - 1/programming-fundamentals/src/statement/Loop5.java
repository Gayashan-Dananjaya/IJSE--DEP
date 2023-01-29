package statement;

import java.util.Arrays;
import java.util.Scanner;

public class Loop5 {
    public static void main(String[] args) {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        String newItem;
        int total = 0;
        int[] array1 = new int[0];
        int[] array2;
        while (!quit) {
            System.out.print("Enter number : ");
            newItem = scanner.nextLine();
            if (Character.isDigit(newItem.charAt(0)) ) {
                total++;
                array2 = new int[total];
                int i = 0;
                while (i < array1.length) {
                    array2[i] = array1[i];
                    i++;
                }
                array2[total] = Integer.parseInt(newItem);
                array1 = array2;

            } else if (newItem.substring(0,1).toLowerCase().equals("q"))  quit=true;

        }
        System.out.println(Arrays.toString(array1));

    }
}
