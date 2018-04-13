package com.lazyman.pickupweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Author chenxiaoqi on 2018/4/13.
 */
@Component
public class SessionListener implements HttpSessionListener {

    private static final Logger LOG = LoggerFactory.getLogger(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        LOG.info("session created {}",se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        LOG.info("session destroyed {}",se.getSession().getId());
    }
}
