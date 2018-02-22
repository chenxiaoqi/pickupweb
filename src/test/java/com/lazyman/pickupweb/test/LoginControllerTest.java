package com.lazyman.pickupweb.test;

import com.lazyman.pickupweb.admin.Login;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;


/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2017/7/29]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@SpringBootTest(properties = {"security.basic.enabled=false"},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class LoginControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private Login login;

    @Before
    public void before() {

    }

    @Test
    public void test() throws Exception {
        assertThat(login.login("user", "cxq"), allOf(hasEntry("name", "user"), hasEntry("password", "cxq")));

        assertThat(login.login("userx", "cxq"), hasKey("error"));

        Map<String, String> map = restTemplate.getForObject("/login?name=user&password=cxq", Map.class);

        assertThat(map, both(hasEntry("name", "user")).and(hasEntry("password", "cxq")));
    }
}
