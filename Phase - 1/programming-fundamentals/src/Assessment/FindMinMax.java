package Assessment;

public class FindMinMax {
    public static void main(String[] args) {
        int[] array = {1, 4, 7, 2, 4, 9, 0, -18, 60, 827,-400,1002, 5, 10, 390};
        int[] minMaxDetails = findMinMax(array);
        System.out.printf("The minimum number is %d and the maximum number is %d",minMaxDetails[0], minMaxDetails[1]);
    }

    public static int[] findMinMax(int[] nums) {
        int i = 0;
        int[] result = new int[2];
        int min= nums[0];
        int max= nums[0];
        do {
            if (min > nums[i]) min = nums[i];
            if (max < nums[i]) max = nums[i];

        } while (++i < nums.length);
        result[0] = min;
        result[1] = max;
        return result;
    }

}
