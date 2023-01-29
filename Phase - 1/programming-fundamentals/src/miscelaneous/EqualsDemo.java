package miscelaneous;

public class EqualsDemo {
    @Override
    public boolean equals(Object obj) {
        return true;
    }

    public static void main(String[] args) {
//        miscelaneous.EqualsDemo equalsDemo1 = new miscelaneous.EqualsDemo();
//        miscelaneous.EqualsDemo equalsDemo2 = new miscelaneous.EqualsDemo();
//
//        System.out.println(equalsDemo1);
//        System.out.println(equalsDemo2);
//        System.out.println(equalsDemo1 == (equalsDemo2));
//        System.out.println(equalsDemo2.equals (equalsDemo1));

        int[] arr1 = {1,2,3};
        int[] arr2 = {1,2,3};
        System.out.println(arr1==arr2);
        System.out.println(arr1.equals(arr2));
    }
}
