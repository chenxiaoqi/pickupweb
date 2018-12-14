package com.lazyman.pickupweb.test.jdk;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2018/11/8]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TestRegex
{

    @Test
    public void testProperty()
    {
        Assert.assertTrue("AAA".matches("\\p{Upper}+"));
        Assert.assertFalse("aaa".matches("\\p{Upper}+"));

        Assert.assertTrue("!@#$%^&*()_+=-~`".matches("\\p{Punct}+"));
        Assert.assertFalse("abc".matches("\\p{Punct}+"));

        Assert.assertFalse("汉".matches("\\w+"));

        Assert.assertTrue("abcABC123!@#$%^".matches("\\p{Graph}+"));
        Assert.assertFalse("abcABC123!@#$%^ ".matches("\\p{Graph}+"));
        Assert.assertFalse("汉汉".matches("\\p{Graph}+"));

        //D:/Program Files/Java/jdk1.8.0_77/src.zip!/java/util/regex/Pattern.java:5651
        Assert.assertTrue("，；’‘".matches("\\p{P}+"));
        Assert.assertFalse("!@#$%^&*".matches("\\p{P}+"));
        Assert.assertTrue("哈哈哈12ab".matches("[^\\p{P}\\p{Punct}]+"));
        Assert.assertFalse("哈哈哈12,ab".matches("[^\\p{P}\\p{Punct}]+"));
        Assert.assertFalse("哈哈哈12，ab".matches("[^\\p{P}\\p{Punct}]+"));


        Assert.assertFalse("aaa".matches("\\p{IsPunctuation}"));


        Assert.assertTrue("汉".matches("\\p{IsHAN}"));
        Assert.assertFalse("a".matches("\\p{IsHAN}"));
        Assert.assertFalse(Pattern.compile("\\p{IsHAN}").matcher("!@#$+_<>?~;；，~~`！·#￥%……—*（）·#").find());

    }

    @Test
    public void testCharacter()
    {
        System.out.println((char)13001);
    }

}
