package com.lazyman.pickupweb.test;

import com.lazyman.pickupweb.Form;
import com.lazyman.pickupweb.GreetingController;
import org.junit.Test;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.validation.BindingResult;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

/**
 * Author chenxiaoqi on 2018/4/6.
 */
public class TestSpringComponents {

    @Test
    public void test()
    {
        String uriTemplate = "http://example.com/hotels/{hotel}";

        URI uri = UriComponentsBuilder.fromUriString(uriTemplate)
                .queryParam("q", "{q}")
                .buildAndExpand("Westin", "123")
                .encode()
                .toUri();

        System.out.println(uri);
    }

    @Test
    public void testWebClient()
    {
//        WebClient client = WebClient
    }

    @Test
    public void testNameDiscover() throws NoSuchMethodException {
        LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] names = discoverer.getParameterNames(GreetingController.class.getDeclaredMethod("validation2", Form.class, String.class, BindingResult.class));
        System.out.println(Arrays.asList(names));

    }
}
