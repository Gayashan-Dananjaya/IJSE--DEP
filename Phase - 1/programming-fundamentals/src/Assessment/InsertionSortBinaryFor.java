package Assessment;

import java.util.Arrays;

public class InsertionSortBinaryFor {
    public static void main(String[] args) {
        int[] array = new int[] {12, 10,4,34,47,73,38, -10, 2000, -500, 62,58,34,24,47,62,34,94,100,-200};
        printSort(array);
    }

    public static void printSort(int[] array) {
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int indexToMove = indexSearching(array, i);
            move(array, i, indexToMove);
        }
    }

    public static int indexSearching(int[] array, int endIndex) {
        int leftIndex = 0;
        int rightIndex = endIndex;
        for (; true;) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (array[middleIndex] == array[endIndex]) return middleIndex;
            if (leftIndex == middleIndex) {
                if (array[middleIndex] > array[endIndex]) return middleIndex;
                else return rightIndex;
            }
            if (array[middleIndex] < array[endIndex]) leftIndex = middleIndex;
            else rightIndex = middleIndex;
        }
    }

    public static void move(int[] array, int endIndex, int indexToMove) {
        int indexTo = indexToMove;
        int indexFrom = endIndex;

        int temp1 = array[endIndex];
        for (int i = indexTo; i <= indexFrom ; i++) {
            int temp2 = array[i];
            array[i] = temp1;
            temp1 = temp2;
        }
    }
}
