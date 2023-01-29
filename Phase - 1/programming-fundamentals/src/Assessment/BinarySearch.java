package Assessment;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,14,20};
        System.out.println(Arrays.toString(sortedArray));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to search : ");
        int number = scanner.nextInt();
        boolean bool = find(sortedArray, number);
        System.out.println(bool);
    }

    public static boolean find(int[] sortedArray, int number) {
        int leftIndex = 0;
        int rightIndex = sortedArray.length-1;
        if (number > sortedArray[sortedArray.length-1] || number < sortedArray[0]) return false;

        while (true) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (sortedArray[middleIndex] == number) return true;
            if (sortedArray[rightIndex] == number) return true;
            if (sortedArray[middleIndex] < number) leftIndex = middleIndex+1;
            else rightIndex = middleIndex-1;
            if (leftIndex == middleIndex) return false;
        }


    }



}
