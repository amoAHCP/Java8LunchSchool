package ch.trivadis.com.lesson1.step4;

/**
 * Created by Andy Moncsek on 03.06.16.
 */
public class Experiment implements Rat,Mouse {

    public static void main(String[] args) {
        Experiment experiment = new Experiment();

        experiment.sayPeep();
        experiment.eatWaste();
        experiment.clinicalTrail();

    }


    @Override
    public void clinicalTrail() {
        Rat.super.clinicalTrail();
        Mouse.super.clinicalTrail();
    }
}

