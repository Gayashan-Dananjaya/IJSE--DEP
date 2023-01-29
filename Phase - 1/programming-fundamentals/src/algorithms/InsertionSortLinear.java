package algorithms;

import java.util.Arrays;

public class InsertionSortLinear {
    public static void main(String[] args) {

        int[] input = {-7, -25, -19, 40, 30, 5, 20, 2};
        printArray(input);
    }

    public static void printArray(int[] input) {

        for (int i = 1; i < input.length; i++) {
            int temp = 0;
            int insertIndex = 0;
            if (input[i-1] > input[i]) {
                temp = input[i];
                insertIndex = findIndex(input, temp);
                moveArrayPart(input, insertIndex, i-1);
                input[insertIndex] = temp;
            }
        }
        System.out.println(Arrays.toString(input));
    }

    private static int findIndex(int[] input, int number) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] > number) return i;
        }
        return 0;
    }

    private static int[] moveArrayPart(int[] input, int startIndex, int endIndex) {
        for (int i = endIndex; i >= startIndex ; i--) {
            input[i + 1] = input[i];
        }
        return input;
    }

}
