package ch.trivadis.com.lesson4.step7;


import ch.trivadis.com.lesson4.Address;
import ch.trivadis.com.lesson4.Person;
import ch.trivadis.com.lesson4.Util;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * Created by Andy Moncsek on 07.06.16.
 */
public class StreamRunner {



    public static void main(String[] args) throws RunnerException {
        StreamRunner runner = new StreamRunner();
        runner.simpleParallelFlatMapExample();

        Options opt = new OptionsBuilder()
                .include(StreamRunner.class.getSimpleName())
                .forks(1) .warmupIterations(2).measurementIterations(4)
                .build();

        new Runner(opt).run();
    }



   @Benchmark
   @BenchmarkMode(Mode.Throughput)
    public void simpleParallelFlatMapExample() {
        List<Person> persons = Util.initCollection();

        List<Address> allAddresses = persons.
                stream().
                parallel().
                flatMap(person -> person.getAddresses().stream()).
                collect(Collectors.toList());
       // System.out.println("all allAddresses: " + allAddresses);

    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void simpleSequentialFlatMapExample() {
        List<Person> persons = Util.initCollection();

        List<Address> allAddresses = persons.
                stream().
                flatMap(person -> person.getAddresses().stream()).
                collect(Collectors.toList());
      //  System.out.println("all allAddresses: " + allAddresses);

    }

    /**
     * see: http://www.stealthcopter.com/blog/2009/09/python-calculating-pi-using-random-numbers/
     */
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void apprpximatePiByRandomNumbersSeriell() {
        int n = 999999;
        double pi = IntStream.range(0, n)
                .mapToDouble((a) -> 4.0 * 1.0 / n * (sqrt(pow(current().nextDouble(),2)+pow(current().nextDouble(),2)) <= 1 ? 1 : 0))
                .sum();
        //System.out.printf("%s delta-abs: %s",pi, PI-pi);
    }

    /**
     * se
     * see: http://www.stealthcopter.com/blog/2009/09/python-calculating-pi-using-random-numbers/
     */
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void apprpximatePiByRandomNumbersParallel() {
        int n = 999999;
        double pi = IntStream.range(0, n)
                .mapToDouble((a) -> 4.0 * 1.0 / n * (sqrt(pow(current().nextDouble(),2)+pow(current().nextDouble(),2)) <= 1 ? 1 : 0))
                .parallel()
                .sum();
        //System.out.printf("%s delta-abs: %s",pi, PI-pi);
    }




}
