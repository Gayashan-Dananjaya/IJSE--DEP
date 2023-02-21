package lk.ijse.dep10.se;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
        double d1 = 0.3;
        double d2 = 0.2;
        double result = d1 - d2;
        System.out.println(result);

        BigDecimal bg = BigDecimal.valueOf(d1);

        BigDecimal bd1 = new BigDecimal("0.3");
        BigDecimal bd2 = new BigDecimal("0.2");
        BigDecimal result2 = bd1.subtract(bd2);
        System.out.println(result2);
    }
}
