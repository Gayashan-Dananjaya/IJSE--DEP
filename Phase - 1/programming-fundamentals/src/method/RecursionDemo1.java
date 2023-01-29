package method;

public class RecursionDemo1 {
    public static void main(String[] args) {
//        printStars(6,6);
        printByOneMethod(5,6, null);
    }

    public static void printStars(int numberOfRows, int numberOfColumns) {
        if (numberOfRows == 0) return;
        printHorizontaly(numberOfColumns);
        System.out.print("\n");
        printStars(--numberOfRows, numberOfColumns);
    }

    public static void printHorizontaly(int numberOfColumns) {
        if (numberOfColumns == 0) return;
        System.out.print("* ");
        printHorizontaly(--numberOfColumns);
    }

    public static void printByOneMethod (int numberOfRows, int numberOfColumns, String constant) {
        if (constant == null) constant = "" + numberOfColumns;
        if (numberOfColumns != 0) {
            System.out.print("* ");
            printByOneMethod(numberOfRows, --numberOfColumns, constant);
        } else {
            if (numberOfRows == 1) return;
            System.out.print("\n");
            printByOneMethod(--numberOfRows,Integer.parseInt(constant),constant);

        }
    }

}
