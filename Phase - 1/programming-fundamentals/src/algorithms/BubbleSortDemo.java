package algorithms;

import java.util.Arrays;

public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] array = {3, 2, -1, 0, 5, 3, 7, 6};

        System.out.println(Arrays.toString(array));
        printSortedArray(array);
//        System.out.println(Arrays.toString(bubbleSortIndexArray(copyArray)));
    }

    public static void printSortedArray(int[] inputArray) {
        int[] sortedArray = bubbleSortMethod(inputArray);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] bubbleSortMethod(int[] inputArray) {
        int swap = 0;
        for (int i = inputArray.length-1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (inputArray[j] > inputArray[j+1]) {
                    swap = inputArray[j];
                    inputArray[j] = inputArray[j+1];
                    inputArray[j+1] = swap;
                }
            }
        }
        return inputArray;
    }

    public static int[] bubbleSortIndexArray(int[] inputArray) {

        int[] copyArray = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            copyArray[i] = inputArray[i];
        }

        int swap = 0;
        int indexSwap = 0;
        int[] indexArray = new int[copyArray.length];
        for (int i = 0; i < copyArray.length; i++) {
            indexArray[i] = i;
        }
        for (int i = copyArray.length-1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (copyArray[j] > copyArray[j+1]) {
                    swap = copyArray[j];
                    indexSwap = indexArray[j];
                    copyArray[j] = copyArray[j+1];
                    indexArray[j] = indexArray [j+1];
                    copyArray[j+1] = swap;
                    indexArray[j+1] = indexSwap;
                }
            }
        }
        return indexArray;
    }

}
