package method;

public class RecursionDemo2 {
    public static void main(String[] args) {
        printStars(6,5);
    }

    public static void printStars(int number, int number2) {
        if (number == 0) return;
        printHorizontally(number2);
        System.out.print("\n");
        printStars(--number,number2);
    }

    public static void printHorizontally (int columns) {
        if (columns == 0) return;
        System.out.print("* ");
        printHorizontally(--columns);
    }
}
