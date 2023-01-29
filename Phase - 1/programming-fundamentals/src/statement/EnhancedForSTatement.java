package statement;

public class EnhancedForSTatement {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50};
        int[][] nums2 = {{10, 20}, {30, 40}, {50, 60}};

//        for (int i: nums) {
//            System.out.println(i);
//        }

        for (int[] i:nums2) {
            for (int j: i) {
                System.out.println(j);
            }
        }

        int sum2 =0 ;

        for (int i:nums) {
            sum2=i;
        }
        System.out.println(sum2);



        int j;

        j = 0;
    }
}
