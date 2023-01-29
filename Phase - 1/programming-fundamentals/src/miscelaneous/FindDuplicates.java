package miscelaneous;

public class FindDuplicates {
    public static void main(String[] args) {

        int[] nums = {-5, 2, 3, 22, 5, 74, 5, 2, 3, 10, 25, 71, 80,5,80,-5,80};
        printTable(nums);
    }

    public static void printTable(int[] input) {

        int[] uniqueArray = uniqueIntMethod(input);
        int[][] totalCountArray = totalCountMethod(uniqueArray, input);
        int[][] filteredArray = filterDuplicatesMethod(totalCountArray);
        String[][] stringArray = convertToStringArray(filteredArray);
        TableDemo.printTable(new String[] {"Duplicates" , "Iterations"}, stringArray);
    }

    public static int[] uniqueIntMethod(int[] input) {
        int[] array1 = {};
        loop1:
        for (int i = 0; i < input.length; i++) {
            for (int item : array1) {
                if (item == input[i]) continue loop1;
            }
            int[] array2 = new int[array1.length + 1];
            for (int j = 0; j < array1.length; j++) {
                array2[j] = array1[j];
            }
            array2[array1.length] = input[i];
            array1 = array2;
        }
        return array1;
    }

    public static int[][] totalCountMethod(int[] uniqueIntArray, int[] input) {
        int[][] totalCountArray = new int[uniqueIntArray.length][2];
        for (int i = 0; i < uniqueIntArray.length; i++) {
            int count = 0;
            for (int inputItem : input) {
                if (uniqueIntArray[i] == inputItem) count++;
            }
            totalCountArray[i][0] = uniqueIntArray[i];
            totalCountArray[i][1] = count;
        }
        return totalCountArray;
    }

    public static int[][] filterDuplicatesMethod(int[][] totalCountArray) {
        int count = 0;
        for (int[] intArray : totalCountArray) {
            if (intArray[1] > 1) count++;
        }
        int[][] filteredArray = new int[count][2];
        count =0;
        for (int i = 0; i < totalCountArray.length; i++) {
            if (totalCountArray[i][1] > 1) {
                filteredArray[count][0] = totalCountArray[i][0];
                filteredArray[count][1] = totalCountArray[i][1];
                count++;
            }
        }
        return filteredArray;
    }

    public static String[][] convertToStringArray(int[][] integerArray) {
        String[][] stringArray = new String[integerArray.length][2];
        for (int i = 0; i < integerArray.length; i++) {
            stringArray[i][0] = Integer.toString(integerArray[i][0]);
            stringArray[i][1] = Integer.toString(integerArray[i][1]);
        }
        return stringArray;
    }

}
