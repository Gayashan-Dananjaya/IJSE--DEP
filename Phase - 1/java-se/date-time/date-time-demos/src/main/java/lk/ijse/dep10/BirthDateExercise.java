package lk.ijse.dep10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class BirthDateExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Date date = null;
        boolean a = true;
        boolean b = true;

        do {
            System.out.print("Enter date of birth (yyyy-mm-dd): ");
        } while ((date = parseDate(scanner.nextLine())) == null || date.after(new Date()));

        Calendar cal = Calendar.getInstance();
        Calendar calNow = Calendar.getInstance();
        cal.clear();
        cal.setTime(date);

//        calNow.clear();
//        calNow.set(2024,Calendar.MARCH,7);

        int daysNow = calNow.get(Calendar.DATE);
        int monthsNow = calNow.get(Calendar.MONTH);
        int yearsNow = calNow.get(Calendar.YEAR);
        int daysBefore = cal.get(Calendar.DATE);
        int monthsBefore = cal.get(Calendar.MONTH);
        int yearsBefore = cal.get(Calendar.YEAR);

        boolean isLeap = isLeapYear(yearsNow);
        int previousMonthDays = countDays(monthsNow, isLeap);


        if (daysNow < daysBefore) {
            daysNow += previousMonthDays;
            if (monthsNow != 0) {
                monthsNow -= 1;
            } else {
                monthsNow = 11;
                yearsNow -= 1;
            }
        }
        if (monthsNow < monthsBefore) {
            monthsNow += 12;
            yearsNow -= 1;
        }

        System.out.print("Years " + (yearsNow - yearsBefore) + " , Months " + (monthsNow - monthsBefore) + " Days " + (daysNow - daysBefore));
    }

    private static int countDays(int currentMonth, boolean isLeap) {
        if (isLeap) {
            if (currentMonth == 2) return 29;
        }
        if ((currentMonth == 0) || (currentMonth == 1) || (currentMonth == 3) || (currentMonth == 5) || (currentMonth == 7) || (currentMonth == 8) || (currentMonth == 10)) {
            return 31;
        }
        if ((currentMonth == 4) || (currentMonth == 6) || (currentMonth == 9) || (currentMonth == 11)) {
            return 30;
        }
        if (currentMonth == 2) {
            return 28;
        }
        return 0;
    }

    private static boolean isLeapYear(int year) {
        if (year%400 == 0) return true;
        if (year%100 == 0) return false;
        if (year%4 == 0) return true;
        return false;
    }

    public static Date parseDate(String input) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(input);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }
}
