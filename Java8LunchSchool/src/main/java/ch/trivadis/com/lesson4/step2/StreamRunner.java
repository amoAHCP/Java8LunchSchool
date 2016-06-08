package ch.trivadis.com.lesson4.step2;


import ch.trivadis.com.lesson4.Person;
import ch.trivadis.com.lesson4.Util;

import java.util.List;

/**
 * Created by Andy Moncsek on 07.06.16.
 */
public class StreamRunner {



    public static void main(String[] args) {
        StreamRunner runner  = new StreamRunner();
        runner.simpleFindFirst();
        runner.simpleFindAny();

    }

    private void simpleFindFirst() {
        List<Person> persons = Util.initCollection();

        persons.
                stream().
                filter(person -> person.getFirstName().equals("Donald88")).
                findFirst().ifPresent(theDonald -> System.out.println(theDonald.toString()));

    }

    private void simpleFindAny() {
        List<Person> persons = Util.initCollection();

        persons.
                stream().
                filter(person -> person.getFirstName().equals("Donald88")).
                findAny().ifPresent(theDonald -> System.out.println(theDonald.toString()));

    }



}
