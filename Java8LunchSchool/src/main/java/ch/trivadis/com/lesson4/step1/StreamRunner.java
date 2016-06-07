package ch.trivadis.com.lesson4.step1;


import ch.trivadis.com.lesson4.Person;
import ch.trivadis.com.lesson4.Util;

import java.util.List;

/**
 * Created by Andy Moncsek on 07.06.16.
 */
public class StreamRunner {



    public static void main(String[] args) {
        StreamRunner runner  = new StreamRunner();
        runner.simpleTerminalOperation();
    }

    private void simpleTerminalOperation() {
        List<Person> persons = Util.initCollection();

        persons.stream().forEach(person -> System.out.println(person.toString()));

    }

}
