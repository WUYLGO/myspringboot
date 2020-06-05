package com.wyl.research.IDgenerate.IdGenerate.optimize;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/6/2
 */
public class RandomIdGenerateTest {

    @Test
    public void testGetLastFieldOfHostName() {
        RandomIdGenerate randomIdGenerate = new RandomIdGenerate();
        String subStrHostName = randomIdGenerate.getLastSubStrSplittedByDot("asdsadsadssdsadsadas/192.168.1.1");
        Assert.assertEquals("192.168.1.1", subStrHostName);
    }


    /**
     * @Description: null或者空字符串的校验
     * @Date: 2020/6/2 14:36
     * @Idea:
     */
    @Test
    public void testGetLastFieldOfHostName_nullOrEmpty() {
        RandomIdGenerate randomIdGenerate = new RandomIdGenerate();
        String subStrHostName = randomIdGenerate.getLastSubStrSplittedByDot(null);
        Assert.assertNotNull(subStrHostName);

        String lastSubStrSplittedByDot = randomIdGenerate.getLastSubStrSplittedByDot("");
        Assert.assertEquals("", lastSubStrSplittedByDot);

    }

    @Test
    public void testGenerateRandomAlphameric() {
        RandomIdGenerate randomIdGenerate = new RandomIdGenerate();
        String generateRandomAlphameric = randomIdGenerate.generateRandomAlphameric(8);

        Assert.assertNotNull(generateRandomAlphameric);
        Assert.assertEquals(6, generateRandomAlphameric.length());
        for (char c : generateRandomAlphameric.toCharArray()) {
            Assert.assertTrue(('0' < c && c < '9') || 'A' < c && c < 'Z' || 'a' < c && c < 'z');
        }
    }

    @Test
    public void testGenerateRandomAlphameric_lengthEqualsOrLessThanZero() {
        RandomIdGenerate idGenerator = new RandomIdGenerate();
        String actualRandomString = idGenerator.generateRandomAlphameric(0);
        Assert.assertEquals("", actualRandomString);
        actualRandomString = idGenerator.generateRandomAlphameric(-1);
        Assert.assertNull(actualRandomString);
    }
}
