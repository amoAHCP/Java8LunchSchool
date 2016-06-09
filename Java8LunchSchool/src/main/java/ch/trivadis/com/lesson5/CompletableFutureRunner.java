package ch.trivadis.com.lesson5;

import java.util.concurrent.*;
import java.util.function.Function;

import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Created by Andy Moncsek on 08.06.16.
 */
public class CompletableFutureRunner {

    Executor executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureRunner runner = new CompletableFutureRunner();

        runner.basicExecutionTypes();
        runner.simpleNonBlocking();
        runner.simpleNonBlockingWithCustomExecutor();
        runner.simpleBlocking();
        runner.basicContextSwitching();
        runner.errorHandling();


    }

    private void basicExecutionTypes() {
        CompletableFuture.supplyAsync(() -> {
            // takes a supplier (and returns a value)
            return "xy";
        }).thenApply(value -> {
            // takes a function, get the value from previous supplier (or function) and returns a new value
            return "xyz";
        }).thenAccept(value2 -> {
            // takes a consumer, get the value from previous supplier or function and returns nothing
            System.out.println(value2);
        }).thenRun(() -> {
            // takes a Runnable, gets no value and returns no value... simply execute
        });
    }


    private void simpleNonBlocking() throws ExecutionException, InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        System.out.println("1: start non-blocking ----------------");
        supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "1: finished";
        }).thenApply(myStringResponse ->
        {
            System.out.println(myStringResponse);
            return myStringResponse + " non-blocking execution";
        }).thenAccept(finalValue -> {
            System.out.println(finalValue);
            latch.countDown();
        });

        System.out.println("1: end non-blocking----------------");
        latch.await(10, TimeUnit.SECONDS);
    }

    private void simpleNonBlockingWithCustomExecutor() throws ExecutionException, InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        System.out.println("1.1: start non-blocking----------------");
        supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "1.1: finished";
        }, executor).thenApply(myStringResponse ->
        {
            System.out.println(myStringResponse);
            return myStringResponse + " non-blocking execution";
        }).thenAccept(finalValue -> {
            System.out.println(finalValue);
            latch.countDown();
        });

        System.out.println("1.1: end non-blocking----------------");
        latch.await(10, TimeUnit.SECONDS);
    }


    private void simpleBlocking() throws ExecutionException, InterruptedException {
        System.out.println("2: start blocking ----------------");
        supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "2: finished";
        }).thenApply(myStringResponse ->
        {
            System.out.println(myStringResponse);
            return myStringResponse + " blocking execution";
        }).thenAccept(finalValue -> {
            System.out.println(finalValue);
        }).get();

        System.out.println("2: end blocking ----------------");
    }

    private void basicContextSwitching() throws ExecutionException, InterruptedException {
        System.out.println("current thread: " + Thread.currentThread());
        CountDownLatch latch = new CountDownLatch(1);
        System.out.println("1: start non-blocking ----------------");
        supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("current thread in supplyAsync: " + Thread.currentThread());
            return "1: finished";
        }).thenApply(myStringResponse ->
        {
            System.out.println(myStringResponse);
            System.out.println("current thread in thenApply (NOT async): " + Thread.currentThread());
            return myStringResponse + " non-blocking execution";
        }).thenAcceptAsync(finalValue -> {
            System.out.println(finalValue);
            System.out.println("current thread in thenAcceptAsync: " + Thread.currentThread());
            latch.countDown();
        });

        System.out.println("current thread: " + Thread.currentThread());
        latch.await(10, TimeUnit.SECONDS);
    }


    private void errorHandling() throws ExecutionException, InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        System.out.println("3: start non-blocking----------------");

        CompletableFuture.
                supplyAsync(() -> {
            throw new NullPointerException("error in xyz ");
        }).
                thenApply(myStringResponse ->
                        myStringResponse + " non-blocking execution").
                thenAccept(finalValue -> System.out.println(finalValue)).
                exceptionally((Function<Throwable, Void>) error -> {

                    System.err.println("3: Exception was thrown: ");
                    error.printStackTrace();
                    latch.countDown();
                    return null;
                });
        System.out.println("3: end non-blocking----------------");
        latch.await(10, TimeUnit.SECONDS);
    }


}
