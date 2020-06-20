package com.wyl.research;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Description: Bcrypt加密:每次加密的都是随机盐,因此能够保证及时相同的密码加密出来的结果依然不同,并且是单向多次hash,能够保证即使得到加密后的字符串也无法解出真正的密码;另外一点是加的随机盐,即使;两个人的密码是一样的,
 * 加密后的字符串依然不一样,因此避免了撞库的可能性;
 * 在匹配的时候,可以从加密后的字符串中解出真正的盐值,并且根据盐值和密码进行同样的算法加密得到hash值与原来的hash相比较是否相同,相同则匹配;
 * @auther: wuyunlong
 * @date: 2020/6/10
 */
public class BcryptTest {
    public static void main(String[] args) {

        //用户密码
        String password = "123456";
        //密码加密
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String newPassword = passwordEncoder.encode(password);//加密
        System.out.println("加密密码为：" + newPassword);
        //对比这两个密码是否是同一个密码
        // true 两个密码一致 false反之
        boolean matches = passwordEncoder.matches(password, newPassword);
        System.out.println("matches==>" + matches);

        //加密密码为：$2a$10$XhERlTuaYy3R/ISpAzqz3uoBliv/AY573fHbBj/KOz6sj4PhgMrIS
        //matches==>true
    }
}
