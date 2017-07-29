package com.lazyman.pickupweb.test;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2017/7/29]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class LoginControllerTest extends SpringTest
{
    private MockMvc mockMvc;

    private WebClient webClient;


    @Before
    public void before()
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        this.webClient = MockMvcWebClientBuilder.webAppContextSetup(wac).build();
    }

    @Test
    public void test() throws Exception
    {
//        this.mockMvc.perform(get("/login/login.action")).andExpect(status().isOk()).andExpect(forwardedUrl("login.jsp"));

        HtmlPage loginPage = webClient.getPage("http://localhost/login/login.action");
        System.out.println(loginPage);
    }
}
