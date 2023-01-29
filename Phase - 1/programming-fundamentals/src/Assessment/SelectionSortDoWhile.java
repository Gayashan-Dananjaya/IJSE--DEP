package Assessment;

import java.util.Arrays;

public class SelectionSortDoWhile {
    public static void main(String[] args) {
        int[] array = {1, 4, 7, 2, 4, 9, 0, 2000, -2000, -18, 60, 827,-400,1002, 5, 10, 390};
        int[] sortedArray = sort(array);
        System.out.println(Arrays.toString(sortedArray));

    }

    public static int[] sort(int[] nums) {
        int i = nums.length; //to 2

        do {
            int j = 0;
            int max = nums[0];
            int maxIndex = 0;

            do {
                if (max < nums[j]) {
                    max = nums[j];
                    maxIndex = j;
                }
            } while (++j < i);

            int temp = nums[i - 1];
            nums[i - 1] = max;
            nums[maxIndex] = temp;
        } while (--i > 1);
        return nums;
    }

}
