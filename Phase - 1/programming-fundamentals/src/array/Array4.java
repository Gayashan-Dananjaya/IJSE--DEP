package array;

public class Array4 {
    public static void main(String[] args) {

        int x = 10;

        int[] num1 = new int[4];
        int[][] array2d = new int[2][];
        int[][] array2d2 = new int[3][];

        num1 = new int[] {10,20,30,40};
        array2d[1] = num1;
        array2d2[1] = array2d[1];

        array2d[0] = new int[] {70,80,90};

        array2d2[0] = new int[] {40,50,60};
        array2d2[2] = array2d2[0];

        int[][][] arr10 = new int[2][][];
        int [] arr11= new int[2];

    }
}