package com.lazyman.pickupweb.test.junit;

import org.junit.runner.RunWith;

/**
 * Author chenxiaoqi on 2018/2/10.
 */
@RunWith(org.junit.runners.Suite.class)
@org.junit.runners.Suite.SuiteClasses({TestJunit.class,TestParameterized.class,TestMockito.class})
public class Suite {
}
