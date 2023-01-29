package statement;

import java.util.Arrays;

public class LoopDemo4 {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int length = nums.length;
        int[] nums2 = new int[length];
        int i = length -1;
        int k = 0;
        while (i >= 0){
            nums2[k] = nums[i];
            i--;
            k++;
        }
        int j =0;
        while (j < length) {
            nums[j] = nums2[j];
            j++;
        }
        System.out.println(Arrays.toString(nums));
    }
}
