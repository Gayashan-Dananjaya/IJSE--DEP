package practice;

import java.util.Arrays;

public class BubbleSortMaxWhile {
    public static void main(String[] args) {
        int[] array = new int[] {12, 10,4,34,47,73,38, -10, 62,58,34,24,47,62,34,94,100};
        printSort(array);
    }

    public static void printSort(int[] array) {
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        int i = array.length-1;
        while (i > 0) {
            int j = 0;
            while (j < i) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                j++;
            }
            i--;
        }
    }

}
