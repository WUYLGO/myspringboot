package com.wyl.research;

import org.springframework.util.StringUtils;

import java.io.File;
import java.util.Properties;

public class mytest {

    public static void main(String[] args) {
        String a="aaa.xlsx";
        String filenameExtension = StringUtils.getFilenameExtension(a);
        System.out.println(filenameExtension);
        //xlsx

        String a1="cn\\wolfcode\\Hello.java";
        String unqualify1 = StringUtils.unqualify(a1, File.separatorChar);
        System.out.println(unqualify1);
        //Hello.java

        String a2="myspringboot";
        String unqualify2 = StringUtils.capitalize(a2);
        System.out.println(unqualify2);

        String[] strs=new String[]{"key:value","key2:中文"};
        Properties ps=StringUtils.splitArrayElementsIntoProperties(strs, ":");
//打印输出：{key=value, key2=中文}
        System.out.println(ps);


    }

}