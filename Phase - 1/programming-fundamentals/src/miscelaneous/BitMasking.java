package miscelaneous;

import java.util.Arrays;

public class BitMasking {
    public static void main(String[] args) {

//        int x = 13;
//        int y = 6;
//        int z = 7;
//        int result = x | y;
//        System.out.println(result);
//
//        System.out.println(result & 10);
//        System.out.println(result & y);
//        System.out.println(result & z);

        int[] array = new int[] {1,2,1,3};                      //{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 4, 2, 7, 2, 5,10,1};
        printDuplicates(array);

    }

    public static void printDuplicates(int... input) {
        int[] duplicates = {};
        for (int i = 0; i < input.length; i++) {
            int sum = 0;
            for (int j = 0; j < input.length; j++) {
                if (i==j) continue;
                sum = sum | input[j];
            }
            if ((sum & input[i]) == input[i]) duplicates = dynamicArray(duplicates,input[i]);       //System.out.println("shdjfb");
        }
        System.out.println(Arrays.toString(duplicates));
        duplicates = set(duplicates);
        System.out.println(Arrays.toString(duplicates));
    }

//    private static int[] set(int[] array, int inputNumber) {
//        for (int i : array) {
//            if (inputNumber == i) return array;
//        }
//        int[] newArray = new int[array.length + 1];
//        for (int i = 0; i < array.length; i++) {
//            newArray[i] = array[i];
//        }
//        newArray[newArray.length-1] = inputNumber;
//        array = newArray;
//        return array;
//    }

    private static int[] dynamicArray(int[] array, int inputNumber) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = inputNumber;
        return newArray;
    }

    private static int[] set(int[] array) {
        int[] newArray = new int[0];
        loop1:
        for (int i : array) {
            for (int j : newArray) {
                if (i == j) continue loop1;
            }
            newArray = dynamicArray(newArray, i);
        }
        return newArray;
    }

}
