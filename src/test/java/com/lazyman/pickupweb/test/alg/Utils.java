package com.lazyman.pickupweb.test.alg;

import java.util.Random;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2018/9/27]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Utils
{
    static int[] random(int length)
    {
        int[] result =  new int[length];
        Random random = new Random();
        for (int i = 0; i < result.length; i++)
        {
            result[i] = random.nextInt(length);
        }
        return result;
    }
}
