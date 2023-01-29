package Assessment;

import java.util.Arrays;

public class BubbleSortMinFor {
    public static void main(String[] args) {
        int[] array = {1, 4, 7, 2, 4, 9, 0, 2000, -2000, -18, 60, 827,-400,1002, 5, 10, 390};
        array = sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static int[] sort(int[] nums) {

        for (int i = 0; i < nums.length-1; i++) {
            for (int j =nums.length-1; j > i; j--) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }

        }
        return nums;
    }
}
