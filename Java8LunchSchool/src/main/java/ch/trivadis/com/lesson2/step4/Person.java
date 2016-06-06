package ch.trivadis.com.lesson2.step4;

/**
 * Created by Andy Moncsek on 06.06.16.
 */
public class Person {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String street;
    private final String zip;

    private Person(String firstName, String lastName, int age, String street, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.street = street;
        this.zip = zip;
    }

    // Start your Builder always with the last member you want to add (if order matters), the last builder interface always returns the type of the Object you want to build

    interface ZipBuilder {
        Person zip(String zip);
    }

    interface StreetBuilder {
        ZipBuilder street(String street);
    }

    interface AgeBuilder {
        StreetBuilder age(int age);
    }

    interface LastNameBuilder {
        AgeBuilder lastName(String lastName);
    }


    interface FirstNameBuilder {
        LastNameBuilder firstName(String firstName);
    }


    // the static "build" method returns always with the first builder interface

    public static FirstNameBuilder build() {
        return firstName -> lastName -> age -> street -> zip -> new Person(firstName, lastName, age, street, zip);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", street='" + street + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
