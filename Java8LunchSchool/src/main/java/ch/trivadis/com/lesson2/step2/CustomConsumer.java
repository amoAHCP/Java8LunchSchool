package ch.trivadis.com.lesson2.step2;

/**
 * Created by Andy Moncsek on 06.06.16.
 */
@FunctionalInterface
public interface CustomConsumer<T> {
    void consume(T value);

   // void consumes(T value);  won't compile, because interface marked as FunctionalInterface
}
