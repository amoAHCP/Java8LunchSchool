package ch.trivadis.com.lesson1.step2;

/**
 * Created by Andy Moncsek on 03.06.16.
 */
public interface Mouse {

    String xyz="peep";

    default void sayPeep() {
        System.out.println("peep "+xyz);
    }

    void run();
}
