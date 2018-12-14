package com.lazyman.pickupweb;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2018/12/14]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Controller
public class HttpDump
{
    @RequestMapping(path = "/dump")
    public void dump(HttpServletRequest request) throws IOException
    {
        Enumeration<String> enumeration = request.getHeaderNames();
        System.out.println("===============================");
        while (enumeration.hasMoreElements())
        {
            String name = enumeration.nextElement();
            System.out.println(name + "=" + request.getHeader(name));
        }

        System.out.println();
        System.out.println();

        System.out.println(IOUtils.toString(request.getInputStream(),StandardCharsets.UTF_8));
    }
}
