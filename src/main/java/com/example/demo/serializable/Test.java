package com.example.demo.serializable;

import java.io.*;

public class Test implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int staticVar = 5;

    public static void main(String[] args) {
        try {
            //初始时staticVar为5
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("result.obj"));
            Test test = new Test();
            test.setName("aaaa");
            out.writeObject(test);
            out.close();

            //序列化后修改为10
//            Test.staticVar = 15;

            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
                    "result.obj"));
            Test t = (Test) oin.readObject();
            oin.close();


            System.out.println("序列化对象和反序列化对象是否相等===>" + (test == t));

            //再读取，通过t.staticVar打印新的值
            System.out.println(t.staticVar);
            System.out.println(t.name);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
