package com.lazyman.pickupweb.test.lombok;

import lombok.ToString;
import lombok.experimental.Delegate;

import java.util.ArrayList;
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
@ToString
public class MyList implements List<String>
{
    @Delegate
    private List<String> list = new ArrayList<>();


}
