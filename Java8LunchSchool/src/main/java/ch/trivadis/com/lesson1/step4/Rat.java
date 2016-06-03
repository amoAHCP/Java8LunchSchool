package ch.trivadis.com.lesson1.step4;

/**
 * Created by Andy Moncsek on 03.06.16.
 */
public interface Rat {
    default void eatWaste() {
        System.out.println("yummy");
    }

    default  void clinicalTrail() {
        System.out.println("remove kidney");
    }
}
