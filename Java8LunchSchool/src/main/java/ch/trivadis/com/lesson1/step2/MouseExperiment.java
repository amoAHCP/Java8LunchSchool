package ch.trivadis.com.lesson1.step2;

/**
 * Created by Andy Moncsek on 03.06.16.
 */
public abstract class MouseExperiment implements Mouse {
    @Override
    public void sayPeep() {
        System.out.println("wuff wuff");
    }
}
