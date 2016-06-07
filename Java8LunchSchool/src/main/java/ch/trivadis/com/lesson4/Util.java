package ch.trivadis.com.lesson4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Andy Moncsek on 07.06.16.
 */
public class Util {


    public static List<Person> initCollection() {
        return IntStream.range(0,100).boxed().map(number ->
                Person.build().
                        firstName("Donald"+number).
                        lastName("Duck"+number).
                        age(number).
                        street("Hollywood Road"+number).
                        zip("3534"+number).
                        addresses(Arrays.asList(
                                Address.
                                        build().
                                        city("Los Alamos"+number).
                                        street("Hollywood Road"+number).
                                        addressType(Address.AddressType.PRIVATE),
                                Address.
                                        build().
                                        city("New York"+number).
                                        street("Ghetto Road"+number).
                                        addressType(Address.AddressType.WORK)

                        ))).collect(Collectors.toList());
    }
}
