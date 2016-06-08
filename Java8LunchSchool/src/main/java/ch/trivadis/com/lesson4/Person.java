package ch.trivadis.com.lesson4;

import java.util.List;

/**
 * Created by Andy Moncsek on 07.06.16.
 */
public class Person implements Comparable<Person> {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String street;
    private final String zip;
    private final List<Address> addresses;

    private Person(String firstName, String lastName, int age, String street, String zip, List<Address> addresses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.street = street;
        this.zip = zip;
        this.addresses = addresses;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getStreet() {
        return street;
    }

    public String getZip() {
        return zip;
    }

    public List<Address> getAddresses() {
        return addresses;
    }


    // Start your Builder always with the last member you want to add (if order matters), the last builder interface always returns the type of the Object you want to build

    public interface AddressesBuilder {
        Person addresses(List<Address> addresses);
    }

    public interface ZipBuilder {
        AddressesBuilder zip(String zip);
    }

    public interface StreetBuilder {
        ZipBuilder street(String street);
    }

    public interface AgeBuilder {
        StreetBuilder age(int age);
    }

    public interface LastNameBuilder {
        AgeBuilder lastName(String lastName);
    }


    public interface FirstNameBuilder {
        LastNameBuilder firstName(String firstName);
    }


    // the static "build" method returns always with the first builder interface

    public static FirstNameBuilder build() {
        return firstName -> lastName -> age -> street -> zip -> addresses -> new Person(firstName, lastName, age, street, zip, addresses);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", street='" + street + '\'' +
                ", zip='" + zip + '\'' +
                ", addresses=" + addresses +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return firstName.compareTo(o.firstName);
    }
}
