package statement;

import java.util.Objects;
import java.util.Scanner;

public class IfVsSwitch {
    public static void main(String[] args) {
        String mystr1 = "IJSE";
        String mystr2 = "IJSE";

        System.out.println(mystr1 == mystr2);

        Scanner scanner = new Scanner(System.in);

        System.out.printf("is scanner instance of SCANNER : %s\n",scanner instanceof Scanner);
        String input = scanner.nextLine();

        System.out.println(mystr1.equals(input));
    }
}
