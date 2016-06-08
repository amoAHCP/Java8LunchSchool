package ch.trivadis.com.lesson4.step6;


import ch.trivadis.com.lesson4.Address;
import ch.trivadis.com.lesson4.Person;
import ch.trivadis.com.lesson4.Util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Andy Moncsek on 07.06.16.
 */
public class StreamRunner {


    public static void main(String[] args) {
        StreamRunner runner = new StreamRunner();
        runner.getAllAddressesDoneWrong();
        runner.simpleFlatMapExample();
        runner.extendedFlatMapExample();


    }

    private void getAllAddressesDoneWrong() {
        List<Person> persons = Util.initCollection();

        final List<List<Address>> collect = persons.
                stream().
                map(person -> person.getAddresses()).
                collect(Collectors.toList());
        //  System.out.println("all allAddresses: " + allAddresses);

    }


    private void simpleFlatMapExample() {
        List<Person> persons = Util.initCollection();

        List<Address> allAddresses = persons.
                stream().
                flatMap(person -> person.getAddresses().stream()).
                collect(Collectors.toList());
        System.out.println("all allAddresses: " + allAddresses);

    }

    private void extendedFlatMapExample() {
        List<Person> persons = Util.initCollection();

        final Map<String, List<Address>> collectByNameAndAddress = persons.
                stream().collect(Collectors.toMap(Person::getFirstName, p -> p.getAddresses()));

        List<Address> allAddresses = collectByNameAndAddress.entrySet().
                stream().
                flatMap(entry -> entry.getValue().stream()).
                collect(Collectors.toList());
        System.out.println("all allAddresses: " + allAddresses);

    }


}
