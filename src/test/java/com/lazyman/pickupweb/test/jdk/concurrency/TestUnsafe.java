package com.lazyman.pickupweb.test.jdk.concurrency;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2018/11/14]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TestUnsafe
{


    private int value;

    @Test
    public void test() throws Throwable
    {
        Unsafe unsafe = getUnsafe();
        long offset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("value"));

        unsafe.putOrderedInt(this,offset,2);

        System.out.println(value);

    }

    private Unsafe getUnsafe() throws Throwable {

        Class<?> unsafeClass = Unsafe.class;

        for (Field f : unsafeClass.getDeclaredFields()) {

            if ("theUnsafe".equals(f.getName())) {

                f.setAccessible(true);

                return (Unsafe) f.get(null);

            }

        }

        throw new IllegalAccessException("no declared field: theUnsafe");
    }
}
