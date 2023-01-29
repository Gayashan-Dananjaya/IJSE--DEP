package Assessment;

public class FindPalindrome {
    public static void main(String[] args) {
        int number = 949;
        boolean variable = isPalindrome(number);
        System.out.println(variable);

    }

    public static boolean isPalindrome(int number) {
        int nextThousand = findNextThousand(number);
        int[] array = findIntArray(number, nextThousand);
        int[] reversedArray = reverseArray(array);
        boolean isSimilar = isSimilar(array, reversedArray);
        return isSimilar;

    }

    public static int findNextThousand(int num) {
        int base = 10;
        while (true) {
            if (num < base) return base;
            base = base * 10;
        }
    }

    public static int[] findIntArray(int number, int thousand) {
        int base = 10;
        int remainder1 = 0;
        int remainder2 = 0;
        int remainder3 = 0;
        int[] intArray = {};
        while (true) {
            remainder1 = number % base;
            remainder3 = remainder1 - remainder2;
            intArray = dynamicArray(intArray, (remainder3*10)/base);
            if (base > number) break;
            base = base * 10;
            remainder2 = remainder1;

        }
        return intArray;

    }

    public static int[] dynamicArray(int[] array, int number) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = number;
        return newArray;
    }

    public static int[] reverseArray(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[array.length - i - 1] = array[i];
        }
        return newArray;

    }

    public static boolean isSimilar(int[] array1, int[] array2) {
        boolean variable = true;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) variable = false;
        }
        return variable;
    }




}
