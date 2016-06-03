package ch.trivadis.com.lesson1.step4;

/**
 * Created by Andy Moncsek on 03.06.16.
 */
public interface Mouse {
    String xyz="xcvxv";

    default void sayPeep() {
        System.out.println("peep "+xyz);
    }

    default  void clinicalTrail() {
        System.out.println("remove liver");
    }

}
