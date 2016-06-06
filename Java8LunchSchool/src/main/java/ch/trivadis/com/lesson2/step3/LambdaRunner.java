package ch.trivadis.com.lesson2.step3;

import java.util.function.Function;

/**
 * Created by Andy Moncsek on 06.06.16.
 */
public class LambdaRunner {


    // structural equality problem
    public static void main(String[] args) {
         r1 = ()->System.out.println("Hallo 1");
         r2 = ()->System.out.println("Hello 2");
         r1.run();
         // BUT
         r2.dryRun();

         f1 = (a) -> {
             if(String.class.isAssignableFrom(a.getClass())) System.out.println("it's a String");
             return 1+1;
         };

        f2 = (a) -> {
            if(String.class.isAssignableFrom(a.getClass())) System.out.println("it's a String");
            return 1+1;
        };

    }






























    static Runnable r1;
    static CustomRunnable r2;
    static Function<String, Integer> f1;
    static Function<Integer, Integer> f2;
}
