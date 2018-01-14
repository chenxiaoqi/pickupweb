package com.lazyman.pickupweb.test.guava;

import com.google.common.base.Optional;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.lazyman.pickupweb.test.Foo;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

/**
 * Author chenxiaoqi on 2018/1/14.
 */
public class GuavaBaseTest {

    @Test
    public void testOptional() {
        Optional<Integer> optional = Optional.absent();

        Assert.assertFalse(optional.isPresent());

        try {
            optional.get();
            Assert.fail();
        } catch (IllegalStateException e) {

        }

        //absent do not execute function,just return itself
        Assert.assertEquals(optional, optional.transform(input -> 10));

        Assert.assertEquals(Integer.valueOf(5), optional.or(5));

        Assert.assertEquals(Integer.valueOf(10), optional.or(() -> 10));

        Assert.assertNull(optional.orNull());

        //have value
        optional = optional.or(Optional.of(11));

        Assert.assertEquals(Integer.valueOf(11), optional.get());

        Assert.assertEquals(Integer.valueOf(11), optional.or(5));

        Assert.assertEquals(Integer.valueOf(11), optional.asSet().iterator().next());


        Assert.assertNotNull(optional.orNull());

        Assert.assertEquals("great than five", optional.transform(input -> {
            if (input > 5) {
                return "great than five" ;
            } else {
                return "less than five" ;
            }
        }).get());
    }

    @Test
    public void testCompareChain() {

        Assert.assertEquals(-1, ComparisonChain.start().compare(1, 5).result());

    }

    @Test
    public void testOrdering() {

        Ordering<Foo> ordering = Ordering.natural().nullsFirst().onResultOf(Foo::getStr);
        Assert.assertEquals(0, ordering.compare(new Foo("great than five", 1), new Foo("great than five", 2)));

        Comparator<Foo> comparator = ordering.thenComparing(Comparator.comparingInt(Foo::getAnInt));

        Assert.assertEquals(1, comparator.compare(new Foo("hreat than five", 1), new Foo("great than five", 2)));
        Assert.assertEquals(-1, comparator.compare(new Foo("great than five", 1), new Foo("great than five", 2)));

        System.out.println(ordering);
    }
}
