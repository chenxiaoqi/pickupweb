package com.lazyman.pickupweb.test.lombok;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2018/12/22]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class LoTest
{
    @Test
    public void test()
    {
        LoUser user1 = LoUser.of("cxq");

        user1.setPassword("cxq");

        LoUser user2 = LoUser.of("cxq");

        user2.setPassword("cxq");

        Assert.assertEquals(user1, user1);

        try
        {
            user1.test();
            Assert.fail();
        }
        catch (Exception e)
        {
            Assert.assertEquals(IllegalAccessException.class, e.getClass());
        }

        List<String> list =  new MyList();
        list.add("a");
        System.out.println(list);
    }
}
