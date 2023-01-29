package statement;

import java.util.Arrays;

public class LoopDemo5 {
    public static void main(String[] args) {
//Sorting the array
        int[] nums = {12, 234, 536, 467,345,8745,-7835,738,76,254,-756,0,-54,45,0,-45};
        int length = nums.length;   //10
        int iterations = 0;
        int secondIterations = 0;
        int swap;
        while (iterations < length-1) {
            secondIterations = iterations+1;
            while (secondIterations < length) {
                int smallestNumber = nums[iterations];
                if (smallestNumber > nums[secondIterations]) {
                    swap = nums[iterations];
                    nums[iterations] = nums[secondIterations];
                    nums[secondIterations] = swap;
                }
                secondIterations++;
            }
            iterations++;
        }
        System.out.println(Arrays.toString(nums));
    }
}
