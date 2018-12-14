package com.lazyman.pickupweb.test.guava;

import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2018/10/30]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TestListenableFuture
{
    @Test
    public void test() throws Exception
    {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

        ListenableFuture<Integer> listenableFuture = executorService.submit(() -> 1);
        ListenableFuture<Integer> failedListenableFuture = executorService.submit(() -> {
            throw new IllegalStateException();
        });

        ListenableFuture<Boolean> booleanListenableFuture = Futures.transform(listenableFuture, input -> true,executorService);
        System.out.println(booleanListenableFuture.get());


        System.out.println(Futures.getChecked(listenableFuture, Exception.class));


        try
        {
            ListenableFuture<List<Integer>> listListenableFuture = Futures.allAsList(listenableFuture, failedListenableFuture);
            System.out.println(listListenableFuture.get());
            Assert.fail();
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }

        Futures.addCallback(listenableFuture, new FutureCallback<Integer>()
        {
            @Override
            public void onSuccess(@Nullable Integer integer)
            {

            }

            @Override
            public void onFailure(Throwable throwable)
            {

            }
        },executorService);




        System.out.println(Futures.catching(failedListenableFuture,IllegalStateException.class,(e)->10000,executorService).get());


        System.out.println(Futures.catchingAsync(failedListenableFuture, RuntimeException.class, input -> executorService.submit(() -> 9999),executorService).get());



        Thread.sleep(5000);

    }
}
