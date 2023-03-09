package lk.ijse.dep10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDate2 {
    public static void main(String[] args) {
        String date = "2021-03-08 10:35";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm");
        try {
            Date utilDate = sdf.parse(date);
            System.out.println(utilDate);
        } catch (ParseException e) {
            System.err.println("Failed to convert to n=the util date");
            e.printStackTrace();
        }

    }
}
