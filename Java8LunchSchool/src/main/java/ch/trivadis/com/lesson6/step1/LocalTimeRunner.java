package ch.trivadis.com.lesson6.step1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * Created by Andy Moncsek on 09.06.16.
 */
public class LocalTimeRunner {



    public static void main(String[] args) {
        LocalTimeRunner runner = new LocalTimeRunner();
        runner.simpleDateTimeNow();
        runner.timeOperations();
    }

    private void simpleDateTimeNow() {
        // Get the current date and time
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + currentTime);
    }

    private void timeOperations() {
        // Get the current date and time
        LocalDateTime currentTime = LocalDateTime.now();

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("local date: " + date1);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("Month: " + month +"day: " + day +"seconds: " + seconds);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        //12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        //22 hour 15 minutes
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        //parse a string
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
    }
}
