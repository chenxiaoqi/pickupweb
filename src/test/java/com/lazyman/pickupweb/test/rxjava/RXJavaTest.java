package com.lazyman.pickupweb.test.rxjava;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Author chenxiaoqi on 2017/10/14.
 */
public class RXJavaTest {

    @Ignore
    @Test
    public void test()
    {
        Observable<Integer>  observable = Observable.create(observableEmitter -> {
            observableEmitter.onNext(1);
            observableEmitter.onNext(2);
            observableEmitter.onError(new IllegalStateException());
            observableEmitter.onComplete();
            observableEmitter.tryOnError(new Exception());
        });

        observable = observable.cache();




        observable.subscribe(System.out::println);
        observable.subscribe(System.out::println);


        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {

                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext " + integer);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }
}
