package lk.ijse.dep10;

import java.util.Calendar;
import java.util.Date;

public class UtilDate5 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(2023, 2, 7);
        cal.add(Calendar.MONTH, -3);
        cal.add(Calendar.DATE, 100);
        Date d1 = cal.getTime();
        System.out.println(d1);
    }
}
