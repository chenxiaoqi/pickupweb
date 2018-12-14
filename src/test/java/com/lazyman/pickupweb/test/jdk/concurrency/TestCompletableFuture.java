package com.lazyman.pickupweb.test.jdk.concurrency;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2018/10/31]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TestCompletableFuture
{
    @Test
    public void test() throws ExecutionException, InterruptedException
    {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

        Thread thread = new Thread(() -> {
            try
            {
                Thread.sleep(2000);
                completableFuture.complete(2);
            }
            catch (InterruptedException e)
            {
                completableFuture.completeExceptionally(e);
                e.printStackTrace();
            }
        });

        thread.start();

        System.out.println(completableFuture.get());


        CompletableFuture.supplyAsync(()-> "hello").runAfterEither(CompletableFuture.supplyAsync(()-> "wold"),()-> System.out.println("haha")).join();

        Thread.sleep(2000);

    }

    @Test
    public void testVoid()
    {

    }

    @Test
    public void testException() throws ExecutionException, InterruptedException
    {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

        Thread thread = new Thread(() -> completableFuture.completeExceptionally(new IllegalStateException()));
        thread.start();

        Thread.sleep(100);

        if (completableFuture.isCompletedExceptionally())
        {
            System.out.println("complete with exception.");
        }

        try
        {
            completableFuture.get();
            Assert.fail();
        }
        catch (InterruptedException | ExecutionException e)
        {

        }


    }


    @Test
    public void testPromiseStyle()
    {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<String> list = new ArrayList<>();
        CompletableFuture[] cfs = Stream.of(1, 2, 3, 4).map(i -> CompletableFuture.supplyAsync(
                () -> {
                    try
                    {
                        Thread.sleep(i * 1000);
                        return i;
                    }
                    catch (InterruptedException e)
                    {
                        throw new IllegalStateException(e);
                    }
                }, executorService)
                .thenApply(String::valueOf)
                .whenComplete((s, e) -> {
                    list.add(s);
                    System.out.println(s);
                })
        ).toArray(CompletableFuture[]::new);


        System.out.println(CompletableFuture.allOf(cfs).join());
        System.out.println(list);
    }
}
