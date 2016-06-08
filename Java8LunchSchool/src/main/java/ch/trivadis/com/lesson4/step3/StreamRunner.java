package ch.trivadis.com.lesson4.step3;


import ch.trivadis.com.lesson4.Address;
import ch.trivadis.com.lesson4.Person;
import ch.trivadis.com.lesson4.Util;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Andy Moncsek on 07.06.16.
 */
public class StreamRunner {



    public static void main(String[] args) {
        StreamRunner runner  = new StreamRunner();
        runner.simpleCollectToList();
        runner.convertListToSet();
        runner.convertListToSetWithCustomCollector();
        runner.simpleCollectToMapByName();
        runner.simpleCollectToMapByNameAndAddress();

    }

    private void simpleCollectToList() {
        List<Person> persons = Util.initCollection();

        List<Person> over60 = persons.
                stream().
                filter(person -> person.getAge()>60).
                collect(Collectors.toList());
        over60.stream().forEach(p-> System.out.println(p.toString()));

    }

    private void convertListToSet() {
        List<Person> persons = Util.initCollection();

        Set<Person> over60 = persons.
                stream().
                filter(person -> person.getAge()>60).
                collect(Collectors.toCollection(TreeSet::new));
        over60.stream().forEach(p-> System.out.println(p.toString()));

    }

    private void convertListToSetWithCustomCollector() {
        List<Person> persons = Util.initCollection();
        Collector<Person,?,TreeSet<Person>> customCollector =Collector.of(TreeSet::new, TreeSet::add,
                (left, right) -> {
                    left.addAll(right);
                    return left;
                });

        Set<Person> over60 = persons.
                stream().
                filter(person -> person.getAge()>60).
                collect(customCollector);
        over60.stream().forEach(p-> System.out.println(p.toString()));

    }

    private void simpleCollectToMapByName() {
        List<Person> persons = Util.initCollection();

        final Map<String, Person> collectByName = persons.
                stream().collect(Collectors.toMap(Person::getFirstName, Function.identity()));

        collectByName.entrySet().stream().forEach(entry -> System.out.println("first name:"+ entry.getKey()+"  person:"+entry.getValue()));

    }

    private void simpleCollectToMapByNameAndAddress() {
        List<Person> persons = Util.initCollection();

        final Map<String, List<Address>> collectByNameAndAddress = persons.
                stream().collect(Collectors.toMap(Person::getFirstName, p -> p.getAddresses()));

        collectByNameAndAddress.entrySet().stream().forEach(entry -> System.out.println("first name:"+ entry.getKey()+"  addresses:"+entry.getValue()));

    }





}
