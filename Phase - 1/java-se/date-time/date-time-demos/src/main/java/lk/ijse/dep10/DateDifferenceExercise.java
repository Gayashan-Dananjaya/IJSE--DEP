package lk.ijse.dep10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateDifferenceExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = null;
        Date d2 = null;

        String date1;
        while (true) {
            boolean valid = true;
            System.out.print("Enter Date1 (yyyy-mm-dd): ");
            date1 = scanner.nextLine();
            int i = 0;
            if (date1.length() != 10) continue;
            for (char c : date1.toCharArray()) {
                if (i == 4 || i == 7) {
                    if (c != '-') valid = false;
                } else {
                    if (!Character.isDigit(c)) valid = false;
                }
                i++;
            }
            if (valid) break;
        }

        String date2;
        while (true) {
            boolean valid = true;
            System.out.print("Enter Date2 (yyyy-mm-dd): ");
            date2 = scanner.nextLine();
            int i = 0;
            if (date2.length() != 10) continue;
            for (char c : date2.toCharArray()) {
                if (i == 4 || i == 7) {
                    if (c != '-') valid = false;
                } else {
                    if (!Character.isDigit(c)) valid = false;
                }
                i++;
            }
            if (valid) {
                try {
                    d1 = sdf.parse(date1);
                    d2 = sdf.parse(date2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (d1.after(d2)) continue;
                break;
            }
        }

        long time1 = d1.getTime();
        long time2 = d2.getTime();

        long days = (time2 - time1) / (1000 * 3600 * 24);
        System.out.print("Number of days : " + days);

    }
}
