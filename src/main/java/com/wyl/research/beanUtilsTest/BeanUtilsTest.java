package com.wyl.research.beanUtilsTest;

import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/19
 */
public class BeanUtilsTest {
    /**
     * @Description: dto拷贝到vo;
     * @Date: 2020/5/19 19:08
     * @Idea: BeanUtils的拷贝完全基于第一个类的属性值, 无论第二个对象是否有值,即使被拷贝的对象的字段值为null,对应的target的该字段值不为null,但是拷贝时依然以被拷贝对象为准;
     * <p>
     * 无论是否有嵌套的对象,拷贝都以被拷贝的对象为准;
     */
    public static void main(String[] args) {
//        UserDto userDto = new UserDto("张三", 18, new Date());
//        UserVo userVo = new UserVo("李四", 20, new Date());

        UserDto userDto = new UserDto();
        userDto.setName("张三");
//        userDto.setAge(18);
        Date date = new Date();
        System.out.println("userDto====>" + date);

        /**
         * @Description: String.format的格式化用法;
         * @Date: 2020/5/19 19:19
         * @Idea: 注意String.format的性能较低, 不如直接拼接的方式;
         */
        System.out.println(String.format("userDto====>%s,%s ", date, "aaaaa"));
        userDto.setDate(date);

//        Sub sub = new Sub();
//        sub.setHead("first");
//        userDto.setSub(sub);


        UserVo userVo = new UserVo();
        userVo.setName("李四");
        userVo.setAge(20);
        userVo.setAddress("深圳");

        Sub sub2 = new Sub();
        sub2.setHead("last");
        userVo.setSub(sub2);

        BeanUtils.copyProperties(userDto, userVo);

        System.out.println(userVo);

//        UserVo(name=张三, age=0, date=Tue May 19 19:13:39 CST 2020, address=null, sub=null)
    }


}
