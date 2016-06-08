package ch.trivadis.com.lesson4.step5;


import ch.trivadis.com.lesson4.Address;
import ch.trivadis.com.lesson4.Person;
import ch.trivadis.com.lesson4.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Andy Moncsek on 07.06.16.
 */
public class StreamRunner {


    public static void main(String[] args) {
        StreamRunner runner = new StreamRunner();
        runner.simpleMapReduceAge();
        runner.simpleMapReduceName();
        runner.simpleMapReduceToList();


    }

    private void simpleMapReduceAge() {
        List<Person> persons = Util.initCollection();

        int totalAgeOfDonaldsMultiplePersonality = persons.
                stream().
                map(person -> person.getAge()).
                reduce((left, right) -> left + right).
                orElse(1000);
        System.out.println("total age: " + totalAgeOfDonaldsMultiplePersonality);

    }


    private void simpleMapReduceName() {
        List<Person> persons = Util.initCollection();

        String totalAgeOfDonaldsMultiplePersonality = persons.
                stream().
                map(person -> person.getFirstName()).
                reduce((left, right) -> left + right).
                orElse("way too long");
        System.out.println("total name: " + totalAgeOfDonaldsMultiplePersonality);

    }

    private void simpleMapReduceToList() {
        // be careful... this is not to most elegant way to get all Addresses
        List<Person> persons = Util.initCollection();

       List<Address> addresses =persons.
                stream().
                map(person -> person.getAddresses()).
                reduce((left, right) -> Stream.concat(left.stream(),right.stream()).collect(Collectors.toList())).
                orElse(new ArrayList<>());
        System.out.println("all addresses " + addresses);

    }



}
