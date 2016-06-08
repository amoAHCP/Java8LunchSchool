package ch.trivadis.com.lesson4.step1;


import ch.trivadis.com.lesson4.Person;
import ch.trivadis.com.lesson4.Util;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Andy Moncsek on 07.06.16.
 */
public class StreamRunner {



    public static void main(String[] args) {
        StreamRunner runner  = new StreamRunner();
        runner.simpleTerminalOperation();
        runner.simpleNonTerminalOperation();

    }

    private void simpleTerminalOperation() {
        List<Person> persons = Util.initCollection();

        persons.stream().forEach(person -> System.out.println(person.toString()));

    }

    private void simpleNonTerminalOperation() {
        List<Person> persons = Util.initCollection();
        // this won't start the output until a terminal operation will "start" the lazy stream processing
        final Stream<Person> peek = persons.stream().peek(person -> System.out.println(person.toString()));
        System.out.println("---------------------");
        // this will initiate the peek output
        peek.count();
        System.out.println("---------------------");
    }

}
