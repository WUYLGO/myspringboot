package com.wyl.research.util;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("aaaa");
        list.add("bbbb");
        list.add("cccc");
        list.add("dddd");
        list.add("eeee");

        String s = list.get(3);
        System.out.println(s);
        System.out.println(list.size());

        list.remove("dddd");
        System.out.println(list.size());
        String s1 = list.get(3);
        System.out.println(s1);
        System.out.println(list);

    }


}
