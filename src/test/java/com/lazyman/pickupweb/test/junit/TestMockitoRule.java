package com.lazyman.pickupweb.test.junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.internal.junit.JUnitRule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * Author chenxiaoqi on 2018/2/10.
 */
public class TestMockitoRule {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Mock
    private List list;

    @Test
    public void test(){
        list.add("one");
        verify(list).add("one");
        verify(list).add("one");

        exception.expect(AssertionError.class);
        verify(list).add("two");
    }
}
