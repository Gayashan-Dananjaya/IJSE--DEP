package lk.ijse.dep10;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;

public class Conversion4 {
    public static void main(String[] args) {
        Date sqlDate = Date.valueOf("2020-10-01");
        Time sqlTime = Time.valueOf("12:15:10");
        Timestamp sqlTimeStamp = Timestamp.valueOf("2020-10-02 12:15:10");

        /*java.sql.Date -> java.time.LocalDate*/
        LocalDate localDate = sqlDate.toLocalDate();

        /*java.sql.Time -> java.time.LocalTime*/
        LocalTime localTime = sqlTime.toLocalTime();

        /*java.sql.TimeStamp -> java.time.LocalDateTime*/
        LocalDateTime localDateTime = sqlTimeStamp.toLocalDateTime();

        /*java.time.LocalDate -> java.sql.Date*/
        Date sqlDate2 = Date.valueOf(localDate);

        /*java.time.LocalTime -> java.sql.Time*/
        Time sqlTime2 = Time.valueOf(localTime);

        /*java.time.LocalDateTime -> java.sql.TimeStamp*/
        Timestamp sqlTimeStamp2 = Timestamp.valueOf(localDateTime);


    }
}
