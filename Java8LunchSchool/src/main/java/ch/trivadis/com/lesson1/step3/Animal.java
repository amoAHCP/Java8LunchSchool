package ch.trivadis.com.lesson1.step3;

/**
 * Created by Andy Moncsek on 03.06.16.
 */
public interface Animal {

    default  void clinicalTrail() {
        System.out.println("remove all");
    }
}
