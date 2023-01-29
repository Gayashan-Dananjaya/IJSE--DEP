package Assessment;

public class FindNumberRecursion {
    public static void main(String[] args) {
        int[] array = {1, 4, 7, 2, 4, 9, 0, -18, 60, 827,-400,1002, 5, 10, 390};
        printNumber(array,390);
    }

    public static void printNumber(int[] array,int number) {
        int result = recursion(array, number, 0);
        if (result == -1) System.out.println("Not found");
        else System.out.printf("Number found at index : %d", result);
    }

    private static int recursion(int[] array, int number, int index) {
        if (index == array.length) return -1;
        if (array[index] == number) return index;
        return recursion(array, number, index + 1);
    }
}
