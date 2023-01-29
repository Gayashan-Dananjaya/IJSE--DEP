package statement;

import java.util.Arrays;

public class Loop4 {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50};
        int[] nums2 = new int[nums.length];

        int index = 0;

        while (index<nums.length) {
            nums2[index] = nums [index];
            index++;
        }

        System.out.println(Arrays.toString(nums2));

    }
}
