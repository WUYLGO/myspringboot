package com.wyl.research.IDgenerate.IdGenerate.optimize;

import com.wyl.research.validUser.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/6/2
 */
@Slf4j
public class RandomIdGenerate implements LogTraceIdGenerate {

    /**
     * @Description:
     * @Date: 2020/6/2 14:47
     * @Idea: generate the random id
     * *****
     * 解决:
     * 1.方法拆分;见名知意;
     * 2.魔法数替换;
     * 3.封装为接口'
     * 4.单元测试;
     * 5.注释;
     * 6.判断空;
     * 7.把随机的,不确定的进行分离,方便对确定的代码进行单元测试;保证单元测试的稳定性;
     */
    @Override
    public String generate() {
        String hostName = getLastFieldOfHostName();
        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);
        return String.format("%s-%d-%s", hostName, currentTimeMillis, randomString);
    }

    //    @VisibleForTesting
    protected String getLastFieldOfHostName() {
        String hostName = null;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            log.error("Failed to get the host name.", e);
            throw new BusinessException("9999", "Failed to get the host name...");
        }
        String subStrHostName = getLastSubStrSplittedByDot(hostName);
        return subStrHostName;

    }

    protected String getLastSubStrSplittedByDot(String hostName) {
        if (StringUtils.isEmpty(hostName)) {
            throw new BusinessException("9999", "Host name is empty...");
        }
        String[] tokens = hostName.split("\\/");
        if (tokens.length > 0) {
            hostName = tokens[tokens.length - 1];
        }
        return hostName;
    }


    //    @VisibleForTesting
    protected String generateRandomAlphameric(int length) {

        if (length <= 0) {
            throw new BusinessException("9999", "随机数的长度必须大于1");
        }

        char[] randomChars = new char[8];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int randomAscii = random.nextInt(122);
            boolean isDigit = randomAscii > '0' && randomAscii < '9';
            boolean isUppercase = randomAscii > 'A' && randomAscii < 'Z';
            boolean isLowerCase = randomAscii > 'a' && randomAscii < 'z';
            if (isDigit || isUppercase || isLowerCase) {
                randomChars[count] = (char) (randomAscii);
                count++;
            }
        }
        return new String(randomChars);
    }


}
