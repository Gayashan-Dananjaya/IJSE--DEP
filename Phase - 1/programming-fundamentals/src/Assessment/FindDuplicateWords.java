package Assessment;

import java.util.Arrays;
import java.util.Scanner;

public class FindDuplicateWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter anything : ");
        String input = (scanner.nextLine()).toLowerCase();
        print(input);
    }

    public static void print(String input) {
        String[] array = input.split(" ");
        String[] uniqueWords = uniqueWords(array);
        String[][] totalCount = totalCount(array, uniqueWords);
        String[][] filteredArray = filter(totalCount);
        System.out.println(Arrays.deepToString(filteredArray));

    }

    public static String[] uniqueWords(String[] array) {
        String[] newArray = {};
        loop1:
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < newArray.length; j++) {
                if (array[i].equals(newArray[j])) continue loop1;
            }
            newArray = dynamicArray(newArray, array[i]);
        }
        return newArray;
    }

    public static String[][] totalCount(String[] array, String[] uniqueWords) {
        String[][] totalCount = new String[uniqueWords.length][2];
        for (int i = 0; i < uniqueWords.length; i++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (uniqueWords[i].equals(array[j])) count++;
            }
            totalCount[i][0] = uniqueWords[i];
            totalCount[i][1] = Integer.toString(count);
        }
        return totalCount;
    }

    public static String[][] filter(String[][] totalCount) {
        int count =0;
        for (int i = 0; i < totalCount.length; i++) {
            if (!(totalCount[i][1].equals("1"))) count++;
        }
        String[][] newArray = new String[count][2];

        int index = 0;
        for (int i = 0; i < totalCount.length; i++) {
            if (!(totalCount[i][1].equals("1"))) {
                newArray[index] = totalCount[i];
                index++;
            }
        }
        return newArray;
    }



    public static String[] dynamicArray(String[] array, String word) {
        String[] newArray = new String[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = word;
        return newArray;
    }



}
