package com.wyl.research.IDgenerate.IdGenerate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @Description: ID生成器存在的问题
 * @Date: 2020/6/2 10:21
 * @Idea: ***
 * <p>
 * 1.单一类, 无需考虑设计模式;
 * 2.应该定义为接口,方便以后的扩展;
 * 3.缺少单元测试;
 * 4.没有注释;
 * 5.没有判空,没有处理异常;
 * 6.函数没有进行封装合并;
 * 7.有很多魔法数;
 * ******************************************
 * 解决:
 * 1.方法拆分;见名知意;
 * 2.魔法数替换;
 * 3.封装为接口'
 * 4.单元测试;
 * 5.注释;
 * 6.判断空;
 * 7.把随机的,不确定的进行分离,方便对确定的代码进行单元测试;保证单元测试的稳定性;
 */


public class IdGenerator {
    private static final Logger logger = LoggerFactory.getLogger(IdGenerator.class);

    public static String generate() {
        String id = "";
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            String[] tokens = hostName.split("\\.");
            if (tokens.length > 0) {
                hostName = tokens[tokens.length - 1];
            }
            char[] randomChars = new char[8];
            int count = 0;
            Random random = new Random();
            while (count < 8) {
                int randomAscii = random.nextInt(122);
                if (randomAscii >= 48 && randomAscii <= 57) {
                    randomChars[count] = (char) ('0' + (randomAscii - 48));
                    count++;
                } else if (randomAscii >= 65 && randomAscii <= 90) {
                    randomChars[count] = (char) ('A' + (randomAscii - 65));
                    count++;
                } else if (randomAscii >= 97 && randomAscii <= 122) {
                    randomChars[count] = (char) ('a' + (randomAscii - 97));
                    count++;
                }
            }
            id = String.format("%s-%d-%s", hostName,
                    System.currentTimeMillis(), new String(randomChars));
        } catch (UnknownHostException e) {
            logger.warn("Failed to get the host name.", e);
        }
        return id;
    }
}
