package ch.trivadis.com.lesson2.step2;

/**
 * Created by Andy Moncsek on 06.06.16.
 */
@FunctionalInterface
public interface CustomTriConsumer<A,B,C> {

    void consume(A a, B b, C c);

    // functional interfaces can have any number of default methods, BUT only one abstract method
    default String convert(char ...data){
       return String.valueOf(data);
    }
}
