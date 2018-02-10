package com.lazyman.pickupweb.test.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Author chenxiaoqi on 2018/2/10.
 */

@RunWith(Parameterized.class)

public class TestParameterized {

    @Parameterized.Parameters
    public static Collection<Object> data(){
        return Arrays.asList(new Object[][]{{1,1},{3,3}});
    }

    @Parameterized.Parameter(0)
    public int input;

    @Parameterized.Parameter(1)
    public int expect;

//    public TestParameterized(int input,int expect){
//        this.input = input;
//        this.expect = expect;
//    }

    @Test
    public void test()
    {
        Assert.assertEquals(input,expect);
    }
}
