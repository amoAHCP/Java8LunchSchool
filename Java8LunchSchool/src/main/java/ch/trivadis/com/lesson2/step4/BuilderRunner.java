package ch.trivadis.com.lesson2.step4;

/**
 * Created by Andy Moncsek on 06.06.16.
 */
public class BuilderRunner {

    public static void main(String[] args) {
        Person donald = Person.build().firstName("Donald").lastName("Duck").age(82).street("Hollywood Road").zip("3534");
        System.out.printf("Is this Donald Trump ?:"+donald.toString());
    }
}
