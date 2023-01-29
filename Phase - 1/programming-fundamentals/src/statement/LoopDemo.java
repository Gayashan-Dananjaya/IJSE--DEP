package statement;

public class LoopDemo {
    public static void main(String[] args) throws InterruptedException {

        String something = "Hello DEP-10, How are you?";
//        System.out.println(something.substring(0,2));
//
//        for (int a = 0; a < 5; a++) {
//            System.out.println("IJSE");
//            Thread.sleep(200);
//        }


        int generalNumber = 0;
        int backSpace = 26;
        String colorCode1 = "\u001b[3";
        int coloCode = 1;
        String colorCode3 = "m";


        for (; generalNumber < 100; generalNumber++) {

            int index = 0;
            if (generalNumber >= 0 && generalNumber < 26) {
                index = generalNumber;
                System.out.printf(colorCode1 + coloCode + colorCode3 + something.charAt(index));
                coloCode++;
                Thread.sleep(400);
                if (coloCode == 9) coloCode = 0;
            } else if (generalNumber >= 26 && generalNumber < 30) {
                System.out.printf("|");
                Thread.sleep(500);
                System.out.printf("\b");
                Thread.sleep(500);
            } else if (generalNumber >= 30 && generalNumber < 57) {
                System.out.printf("\b");
                Thread.sleep(400);
            } else if (generalNumber >= 57 && generalNumber < 61) {
                System.out.printf("|");
                Thread.sleep(500);
                System.out.printf("\b");
                Thread.sleep(500);
            }else generalNumber = -1;

        }

    }
}
