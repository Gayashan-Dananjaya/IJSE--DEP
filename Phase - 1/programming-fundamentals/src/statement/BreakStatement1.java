package statement;

public class BreakStatement1 {
    public static void main(String[] args) {

        for (int i = 0; i <= 5; i++) {
            System.out.printf("This is %s iteration.\n", i);

            if (i==3) break;

            System.out.printf("Iteration %s end.\n",i);
        }

    }
}
