package Assessment;

import java.util.Arrays;

public class ReverseIntArrayRecursion {
    public static void main(String[] args) {
        var nums = new int[]{10, 20, 30, 40, 50, 25, 35};
        reverse(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverse(int[] array) {
        recursion(array,0);
    }

    private static void recursion(int[] array, int index) {
        if (index == array.length/2) return;
        int temp = array[index];
        array[index] = array[array.length-index-1];
        array[array.length - index - 1] = temp;
        recursion(array, index + 1);
    }

}
