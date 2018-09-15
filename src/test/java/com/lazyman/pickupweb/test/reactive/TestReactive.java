package com.lazyman.pickupweb.test.reactive;

import org.junit.Test;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2018/6/20]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TestReactive
{
    @Test
    public void testFlux() throws InterruptedException
    {
        Flux<Integer> flux = Flux.range(100, 100);



        Flux.create(sink -> sink.onRequest(n -> System.out.println("on request " + n))).timeout(Duration.ofMillis(80), s -> s.onNext(999)).subscribe(System.out::println).dispose();


        System.out.println("subscribe end!");
        Thread.sleep(20000);
    }

    @Test
    public void testMono()
    {
        Mono.from((Publisher<String>) s -> s.onNext("xxx"));
    }
}
