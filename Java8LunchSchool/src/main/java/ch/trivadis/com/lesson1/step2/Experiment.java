package ch.trivadis.com.lesson1.step2;

/**
 * Created by Andy Moncsek on 03.06.16.
 */
public class Experiment extends MouseExperiment implements Mouse {

    public static void main(String[] args) {
        Experiment experiment = new Experiment();
        experiment.run();
        experiment.sayPeep();
        System.out.println(Mouse.xyz);
    }

    @Override
    public void run() {
        System.out.println("run for you life");
    }
}
