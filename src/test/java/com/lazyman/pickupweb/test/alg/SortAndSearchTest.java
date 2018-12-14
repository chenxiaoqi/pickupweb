package com.lazyman.pickupweb.test.alg;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2018/9/27]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SortAndSearchTest
{
    @Test
    public void testSearch()
    {
        int[] target = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int search = 101;
        int start = 0;
        int position = -1;
        int end = target.length - 1;
        while (start <= end)
        {
            int index = (start + end) / 2;

            if (target[index] == search)
            {
                position = index;
                break;
            }
            else if (search > target[index])
            {
                start = index + 1;
            }
            else
            {
                end = index - 1;
            }
        }
        System.out.println(position);
    }

    @Test
    public void testSelect()
    {
        int[] target = Utils.random(10);

        for (int i = 0; i < target.length; i++)
        {
            for (int j = i + 1; j < target.length; j++)
            {
                if (target[j] < target[i])
                {
                    int c = target[i];
                    target[i] = target[j];
                    target[j] = c;
                }
            }
        }
        System.out.println(StringUtils.join(target, ','));
    }

    static  int counter = 0;
    @Test
    public void testQuickSearch()
    {
        int[] target = Utils.random(10000);
        List<Integer> list = new ArrayList<>();
        for (int aTarget : target)
        {
            list.add(aTarget);
        }
        System.out.println(quickSort(list));
        System.out.println(counter);
    }

    private List<Integer> quickSort(List<Integer> list)
    {
        counter ++;
        if (list.size() <= 1)
        {
            return list;
        }

        int pivot = list.get(0);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (Integer integer : list.subList(1,list.size()))
        {
            if (integer < pivot)
            {
                left.add(integer);
            }
            else
            {
                right.add(integer);
            }
        }

        List<Integer> result = new ArrayList<>(quickSort(left));
        result.add(pivot);
        result.addAll(quickSort(right));
        return result;
    }
}
