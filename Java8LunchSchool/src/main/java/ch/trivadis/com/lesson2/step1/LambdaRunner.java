package ch.trivadis.com.lesson2.step1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by Andy Moncsek on 06.06.16.
 */
public class LambdaRunner {
    private List<String> inputList =Arrays.asList("a","b","c","d","e");

    public static void main(String[] args) {
        LambdaRunner runner = new LambdaRunner();

        // Runnable execution
        runnableExecution(runner);

        // Consumer execution
        consumerExecution(runner);

        // Supplier execution
        supplierExecution(runner);

        // Function execution
        functionExecution(runner);
    }

    private static void runnableExecution(LambdaRunner runner) {
        runner.executeRunnable(()-> System.out.println("hello runnable"));
        // same as:
        runner.executeRunnable(()-> {
            // with braces you need semicolons!!
            System.out.println("hello runnable");
        });
        // same as (old school / before Java 8)
        runner.executeRunnable(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello runnable");
            }
        });
    }

    private static void consumerExecution(LambdaRunner runner) {
        runner.executeConsumer(value -> System.out.println("hello "+value));
        // same as:
        runner.executeConsumer(value -> {
            // with braces you need semicolons!!
            System.out.println("hello "+value);
        });
        // same as (old school / before Java 8)
        runner.executeConsumer(new Consumer<String>() {
            @Override
            public void accept(String value) {
                System.out.println("hello "+value);
            }
        });
    }

    private static void supplierExecution(LambdaRunner runner) {
        String value = runner.create(()->"world");
        // same as:
        value = runner.create(()->{
            return "world";
        });
        // same as (old school / before Java 8)
        value = runner.create(new Supplier<String>() {
            @Override
            public String get() {
                return "world";
            }
        });
        System.out.println("hello "+ value+" supplier");
    }



    private static void functionExecution(LambdaRunner runner) {
        String value = runner.find(list -> {
            // old school iteration
            for(String s : list) {
               if(s.equals("a")) return s;
            }
            return "";
        });

        value = runner.find(new Function<List<String>, String>() {
            @Override
            public String apply(List<String> list) {
                // old school iteration
                for(String s : list) {
                    if(s.equals("a")) return s;
                }
                return "";
            }
        });
        System.out.println("H"+value+"llo function world");
    }





    public void executeRunnable(Runnable r) {
        r.run();
    }

    public void executeConsumer(Consumer<String> c) {
        c.accept("world");
    }

    public String create(Supplier<String> s) {
       return s.get();
    }

    public String find(Function<List<String>,String> f) {
       return f.apply(inputList);
    }
}
