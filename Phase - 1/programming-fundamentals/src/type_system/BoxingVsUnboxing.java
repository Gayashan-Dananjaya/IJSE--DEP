package type_system;

import java.util.ArrayList;

public class BoxingVsUnboxing {
    public static void main(String[] args) {
        Integer myInt = new Integer(10); // Boxing
        int x = 10;
        myInt = new Integer(x);

        Integer myInt2 = 20; /*Auto boxing*/

        int y = myInt2.intValue(); //Unboxing
        int z = myInt2; // auto-unboxing
        Byte zz = 10;

    }
}
