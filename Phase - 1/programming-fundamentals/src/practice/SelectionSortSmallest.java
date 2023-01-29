package practice;

import java.util.Arrays;

public class SelectionSortSmallest {
    public static void main(String[] args) {
        int[] inputArray = {24, 578, 2, 46, 2364, 5, 42, 78, -784, -47, 0, 4, 7, 2, 6, -35, 8756};
        sort(inputArray);
        System.out.println(Arrays.toString(inputArray));
    }

    public static void sort(int[] inputArray) {
        int temp = 0;
        int index =0;
        for (int i = 0; i < inputArray.length - 1; i++) {
            int assumedMin = inputArray[i];
            for (int j = i; j < inputArray.length; j++) {
                if (inputArray[j] < assumedMin) {
                    assumedMin = inputArray[j];
                    index = j;
                }
            }
            if (assumedMin < inputArray[i]) {
                temp = inputArray[i];
                inputArray[i] = assumedMin;
                inputArray[index] = temp;
            }
        }
    }

}
