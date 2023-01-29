package statement;

public class LoopDemo6 {
    public static void main(String[] args) {

        int[] nums = new int[] { 10,20,30,0,-35,-4,15,20};
        int min = 0;
        int minIndex = 0;
        int max = 0;
        int maxIndex = 0;

//do with while and for loops

        int index = 1;
        min = nums[0];
        max = nums[0];
        while (index < nums.length) {
            if (min > nums[index]) {
                min = nums[index];
                minIndex = index;
            }
            index++;
        }
        index = 1;
        while (index < nums.length) {
            if (max < nums[index]) {
                max = nums[index];
                maxIndex = index;
            }
            index++;
        }
        System.out.println("WHILE LOOP");
        System.out.printf("Min value: %s, Min value index: %s \n", min, minIndex);
        System.out.printf("Max value: %s, Max value index: %s \n", max, maxIndex);


        min = 0;
        minIndex = 0;
        max = 0;
        maxIndex = 0;

        min = nums[0];
        max = nums[0];
        for ( index = 1; index < nums.length; index++) {
            if (min > nums[index]) {
                min = nums[index];
                minIndex = index;
            }
        }
        for (index = 1; index < nums.length; index++) {
            if (max < nums[index]) {
                max = nums[index];
                maxIndex = index;
            }
        }
        System.out.println("FOR LOOP");
        System.out.printf("Min value: %s, Min value index: %s \n", min, minIndex);
        System.out.printf("Max value: %s, Max value index: %s \n", max, maxIndex);

    }
}
