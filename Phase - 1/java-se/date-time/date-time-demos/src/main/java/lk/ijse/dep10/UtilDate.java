package lk.ijse.dep10;

import java.util.Calendar;
import java.util.Date;

public class UtilDate {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);


        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(2020,0,1,1,20);
        Date d2 = calendar.getTime();
        System.out.println(d2);

        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));
        System.out.println(calendar.get(Calendar.MILLISECOND));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
    }
}
