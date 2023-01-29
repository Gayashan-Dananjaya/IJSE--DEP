package statement;

import java.util.Arrays;

public class LoopDemo7 {
    public static void main(String[] args) {

        int[] nums = new int[] { 10,40,-85,5,20,30,0,-35,-4,15,20};

//            Sort by selecting maximum
//        both for and while

        int firstIteration = nums.length-1;
        int secondIteration;
        int swap;
        while (firstIteration > 0) {
            secondIteration = firstIteration-1;
            while (secondIteration >= 0) {
                if (nums[firstIteration] < nums[secondIteration]) {
                    swap = nums[firstIteration];
                    nums[firstIteration] = nums[secondIteration];;
                    nums[secondIteration] = swap;
                }
                secondIteration--;
            }
            firstIteration--;
        }
        System.out.println("While Loop");
        System.out.println(Arrays.toString(nums)); // [-25,-4,8,10,15,20,25,30]


        nums = new int[] {10,40,-85,5,20,30,0,-35,-4,15,20};
        for (firstIteration = nums.length-1; firstIteration > 0; firstIteration--) {
            for (secondIteration = firstIteration-1; secondIteration >= 0; secondIteration--) {
                if (nums[firstIteration] < nums[secondIteration]) {
                    swap = nums[firstIteration];
                    nums[firstIteration] = nums[secondIteration];
                    nums[secondIteration] = swap;
                }
            }
        }
        System.out.println("For Loop");
        System.out.println(Arrays.toString(nums));

    }
}
