package com.lazyman.pickupweb.test.guava;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Author chenxiaoqi on 2018/1/13.
 */
public class RateLimiterTest {

    @Ignore
    @Test
    public void test() throws InterruptedException {

        RateLimiter limiter = RateLimiter.create(0.5);
        long start = System.currentTimeMillis();
        Thread.sleep(500);
        for (int i = 0; i < 20; i++) {
            limiter.acquire();
            long curr = System.currentTimeMillis();
            System.out.println( curr -start );
            start = curr;
        }



    }

}
