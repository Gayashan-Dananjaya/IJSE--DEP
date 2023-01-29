package Assessment;

import java.util.Arrays;

public class CharReversion {
    public static void main(String[] args) {
        String str = "Some text";
        int[] intArray = reverse(str);
        System.out.println(Arrays.toString(intArray));
        char[] charArray = convertToChar(intArray);
        System.out.println(Arrays.toString(charArray));

    }

    public static int[] reverse(String input) {
        char[] charArray = input.toCharArray();

        for (int i = 0; i < charArray.length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length - i - 1];
            charArray[charArray.length - i - 1] = temp;
        }

        int[] intArray = new int[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            intArray[i] = (int) charArray[i];
        }
        return intArray;
    }

    public static char[] convertToChar(int[] array) {
        char[] charArray = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            charArray[i] = (char) array[i];
        }
        return charArray;
    }


}
