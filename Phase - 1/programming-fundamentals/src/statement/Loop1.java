package statement;

public class Loop1 {
    public static void main(String[] args) {

        for (int x = 0; x != 5; x++) {      //initialization and update is optional. But the boolean expression is essential

            System.out.println("ISE");
            System.out.println(".....");
            System.out.println("DEP-10");
            System.out.println();
        }

        boolean flag = true;
        int z = 0;
        for (; flag;) {      //initialization and update is optional. But the boolean expression is essential

            System.out.println("IJSE");
            System.out.println(".....");
            System.out.println("DEP-10");
            System.out.println();
            z++;
            if (z == 5) flag=false;
        }
        System.out.println(z);

    }
}
