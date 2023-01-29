package practice;

import java.util.Arrays;

public class SelectionSortSmallestWhile {
    public static void main(String[] args) {
        int[] inputArray = {24, 578, 2, 46, 2364, 5, 42, 78, -784, -47, 0, 4, 7, 2, 6, -35, 8756};
        int[] sortedArray = sort(inputArray);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] sort(int[] inputArray) {
        int[] array = copy(inputArray);
        int i = 0;
        int index = 0;
        int assumedMin;
        int temp;
        while (i < array.length - 1) {
            assumedMin = array[i];
            int j = i;
            while (j < array.length) {
                if (assumedMin < array[j]){
                    j++;
                    continue;
                }
                assumedMin = array[j];
                index = j++;
            }
            if (assumedMin == array[i] ) {
                i++;
                continue;
            }
            temp = array[i];
            array[i] = assumedMin;
            array[index] = temp;
            i++;
        }
        return array;
    }

    private static int[] copy(int[] array) {
        int i = 0;
        int[] copyArray = new int[array.length];
        while (i < array.length) {
            copyArray[i] = array[i];
            i++;
        }
        return copyArray;
    }
}
