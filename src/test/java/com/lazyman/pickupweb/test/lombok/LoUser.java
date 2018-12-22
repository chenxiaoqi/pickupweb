package com.lazyman.pickupweb.test.lombok;

import lombok.Data;
import lombok.SneakyThrows;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2018/12/22]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Data(staticConstructor = "of")
public class LoUser
{
    private final String name;

    private String password;

    @SneakyThrows
    public void test()
    {
        throw new IllegalAccessException();
    }


}
