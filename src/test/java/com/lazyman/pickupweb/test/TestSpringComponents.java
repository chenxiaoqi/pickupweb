package com.lazyman.pickupweb.test;

import org.junit.Test;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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
}
