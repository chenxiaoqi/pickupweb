package com.lazyman.pickupweb.test.junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.exceptions.verification.junit.ArgumentsAreDifferent;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

/**
 * Author chenxiaoqi on 2018/2/10.
 */
public class TestMockito {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testMock() {

        List mockList = mock(List.class, "mockList");
        mockList.add("one");
        mockList.clear();
        mockList.clear();

        verify(mockList).add("one");


        mockList.add("two");

        verify(mockList,times(1)).add("one");
        verify(mockList,times(2)).clear();


        try {
            verify(mockList).add("wrong");
            fail();
        } catch (ArgumentsAreDifferent e) {
            assertThat(e,is(instanceOf(ArgumentsAreDifferent.class)));
        }


        doThrow(new RuntimeException()).when(mockList).clear();

        try {
            mockList.clear();
            fail();
        } catch (RuntimeException e) {

        }


    }

    @Test
    public void testStub(){
        LinkedList mockList = mock(LinkedList.class);

        when(mockList.get(0)).thenReturn("one","two","three");
        when(mockList.get(2)).thenThrow(new RuntimeException());

        assertThat(mockList.get(0),is("one"));


        verify(mockList).get(0);

        assertThat(mockList.get(0),is("two"));

        assertThat(mockList.get(0),is("three"));


        mockList.get(0);


        verify(mockList,times(4)).get(0);

        expectedException.expect(RuntimeException.class);

        mockList.get(2);


        throw new IllegalStateException("never reach here");

    }

    @Test
    public void testArgMatch(){
        List list = mock(List.class);

        when(list.get(anyInt())).thenReturn("element");

        assertThat(list.get(6),is("element"));

        verify(list).get(anyInt());
        verify(list).get(6);

        when(list.contains(argThat((Integer argument) -> argument>3))).thenReturn(true);

        assertThat(list.contains(5),is(true));
        assertThat(list.contains(2),is(false));



    }

    @Test
    public void testOrder(){
        List list = mock(List.class);
        list.add("one");
        list.add("two");
        InOrder order = inOrder(list);
        order.verify(list).add("one");
        order.verify(list).add("two");

        reset(list);
        list.add("one");
        list.add("two");

        order = inOrder(list);

        try {
            order.verify(list).add("two");
            fail();
        } catch (AssertionError error) {
            System.out.println(error.getClass());
        }

        verify(list,times(1)).add("two");

        verify(list,never()).add("three");


        reset(list);
        verifyZeroInteractions(list);

        list.add("one");

        verify(list).add("one");

        verifyNoMoreInteractions(list);

        list.add("two");

        try {
            verifyNoMoreInteractions(list);
            fail();
        } catch (AssertionError error) {
            System.out.println(error);
        }

    }

    @Test
    public void testAnswer()
    {
        List list = mock(List.class, Mockito.RETURNS_SMART_NULLS);

        when(list.get(anyInt())).then((Answer<Object>) invocation -> {
            Integer arg = invocation.getArgument(0);
            if (arg > 5) {
                return "great than 5";
            }
            else{
                return "less or equals 5";
            }

        });
        assertThat(list.get(2),is("less or equals 5"));
        assertThat(list.get(6),is("great than 5"));

        verify(list,times(2)).get(anyInt());
        verify(list,times(1)).get(2);
        verify(list,times(1)).get(6);

    }

    @Test
    public void testDo()
    {
        List list  = mock(LinkedList.class);
        doCallRealMethod().when(list).add("one");
        doCallRealMethod().when(list).size();
        list.add("one");
        assertThat(list.size(),is(1));
    }

    private class ForSpy{
        public String hello(String name){
            String message =  "hello " + name;
            System.out.println(message);
            return message;
        }
    }

    @Test
    public void testSpy(){
        List<String> list  = new LinkedList<>();
        List<String> spy = spy(list);

        spy.add("xxxxxx");

        doReturn("foo").when(spy).get(0);
        assertThat(spy.get(0),is("foo"));

        when(spy.get(0)).thenReturn("bar");
        assertThat(spy.get(0),is("bar"));

        when(spy.add("one")).thenReturn(false);
        assertThat(spy.add("one"),is(false));


        spy.add("xxx");
        assertThat(list.size(),is(0));
    }
}
