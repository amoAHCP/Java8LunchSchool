package ch.trivadis.com.lesson5;

import java.util.concurrent.*;

/**
 * Created by Andy Moncsek on 08.06.16.
 */
public class CompletableFutureRunner {

    Executor executor = Executors.newFixedThreadPool(5);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureRunner runner = new CompletableFutureRunner();

        runner.simpleNonBlocking();
        runner.simpleBlocking();


    }

    private void simpleNonBlocking() throws ExecutionException, InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        System.out.println("1: start ----------------");
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "finished";
        }).thenApply(myStringResponse ->
        {
            System.out.println(myStringResponse);
            return myStringResponse + " execution";
        }).thenAccept(finalValue -> {
            System.out.println(finalValue) ;
            latch.countDown();
        });

        System.out.println("1: end ----------------");
        latch.await(10,TimeUnit.SECONDS);
    }


    private void simpleBlocking() throws ExecutionException, InterruptedException {
        System.out.println("2: start ----------------");
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "finished";
        }).thenApply(myStringResponse ->
        {
            System.out.println(myStringResponse);
            return myStringResponse + " execution";
        }).thenAccept(finalValue -> {
            System.out.println(finalValue) ;
        }).get();

        System.out.println("2: end ----------------");
    }



}
