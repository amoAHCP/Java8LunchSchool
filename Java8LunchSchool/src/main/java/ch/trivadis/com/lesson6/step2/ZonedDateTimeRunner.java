package ch.trivadis.com.lesson6.step2;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by Andy Moncsek on 09.06.16.
 */
public class ZonedDateTimeRunner {

    public static void main(String[] args) {
        ZonedDateTimeRunner runner = new ZonedDateTimeRunner();
        runner.testZonedDateTime();
    }

    private void testZonedDateTime(){

        // Get the current date and time
        ZonedDateTime date1 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
        System.out.println("date1: " + date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("CurrentZone: " + currentZone);
    }
}
