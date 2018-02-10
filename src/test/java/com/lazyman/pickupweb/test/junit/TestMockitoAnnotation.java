package com.lazyman.pickupweb.test.junit;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Author chenxiaoqi on 2018/2/10.
 */
public class TestMockitoAnnotation {

    @Mock
    private List list;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() {
        list.add("one");
        list.add("two");

        verify(list).add("one");
        verify(list).add("two");

    }


}
