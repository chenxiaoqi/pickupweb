package com.lazyman.pickupweb.test.junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Author chenxiaoqi on 2018/2/10.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestMockitoRunner {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Mock
    private List list;

    @Test
    public void test(){
        list.add("one");
        verify(list).add("one");

        exception.expect(AssertionError.class);
        verify(list).add("two");
    }
}
