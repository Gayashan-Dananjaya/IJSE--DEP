package statement;

public class ContinueStatement {
    public static void main(String[] args) {

//        label1:
//        System.out.println("...........");
//        int i =0;
//        while (true) {
//            i++;
//            System.out.println(i);
//            if (i== 5) continue;
//            System.out.println("jdgfd");
//            if (i==20) break;
//        }

        mainloop:
        for (int l =0; l < 3;l++) {
            forloop:
            for (int i = 0; i < 3; i++) {
                System.out.printf("For Loop : Iteration %s start.\n",i);

                int k = 0;
                whileoop:
                while (k++ < 2) {
                    System.out.printf("While Loop : Iteration %s Start.\n",k);
                    if (true) continue mainloop;



                    System.out.printf("While Loop : Iteration %s end.\n",k);
                }

                System.out.printf("For Loop : Iteration %s end.\n",i);
            }
        }

    }
}
