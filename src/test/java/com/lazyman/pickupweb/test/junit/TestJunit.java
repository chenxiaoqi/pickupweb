package com.lazyman.pickupweb.test.junit;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assume.*;


/**
 * Author chenxiaoqi on 2018/2/9.
 */
public class TestJunit {

    @Rule
    public ExpectedException exceptionRule =  ExpectedException.none();

    @Test
    public void testAssert(){

        Assert.assertThat(Arrays.asList("121", "21", "312"), everyItem(containsString("1")));

        Assert.assertThat(Arrays.asList("124","123"), everyItem(both(containsString("1")).and(containsString("2"))));

        Assert.assertThat("12", both(containsString("1")).and(containsString("2")));

        Assert.assertThat(Arrays.asList("11", "21", "31"), hasItem("11"));

        Assert.assertThat("good",allOf(containsString("oo"),equalTo("good")));

        Assert.assertThat("good", not(is("good1")));
        Assert.assertThat("good", not(equalTo("good1")));

    }

    @Ignore("test for demonstration")
    @Test(expected = IllegalStateException.class)
    public void testException()
    {
        throw new IllegalStateException();
    }

    @Test
    public void testExceptionRule(){
        List<String> list = new ArrayList<>();
        exceptionRule.expect(IndexOutOfBoundsException.class);
        exceptionRule.expectMessage("Size");
        exceptionRule.expectCause(nullValue(IndexOutOfBoundsException.class));
        list.get(0);
    }

    @Test
    public void testAssume()
    {
        assumeThat(File.separator,is("\\"));
        Assert.assertThat(File.separator,is("/"));

    }


}
