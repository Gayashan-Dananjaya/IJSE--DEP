package array;

import java.util.Arrays;
import java.util.SplittableRandom;

public class Array {
    public static void main(String[] args) {

        var x = 12;
        int[] list1 = {1134,23425,357853};
        list1[0] = 111;
        System.out.println(list1[0]);

        String[] names = {"kasun", "Nuwan" , "Ruwan", "Sampath"};
        System.out.println(names.length);
        System.out.println(names[1]);

        String[] names2 = {};
        System.out.println(names2.length);
        System.out.println(names);
        System.out.println(names2);

        names2 = names;
        System.out.println(names.length);
         names2=null;

        System.out.println(names);
        System.out.println(names2);
    }
}
