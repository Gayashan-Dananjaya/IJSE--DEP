package array;

import java.util.Arrays;

public class Array3 {
    public static void main(String[] args) {
        int[][] array2d = new int[2][];
        System.out.println(array2d[0]);

        int[][] array2d2 = new int[2][4];
        System.out.println(array2d2[0]);

        var arrayInt1 = new int[]{1,2,3};
        var arrayInt2 = new int[]{4,5,6,7,8};

        array2d[0] = arrayInt1;
        array2d[1] = arrayInt2;

        System.out.println(Arrays.toString(array2d));
        System.out.println(array2d[0].length);
        System.out.println(array2d[1].length);

//##################################################################################


        int[][] arr1 = new int[2][3];
        int[] arr2 = {1,2,3};

        arr1[0] = new int[]{13,356,758};
        arr1[1] = arr2;

        System.out.println(arr1[1][0]);
        arr1[1][0] = 12;
        System.out.println(arr2[0]);







    }
}
