package com.wyl.research.util.collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setName("张三");
        Customer customer2 = new Customer();
        customer2.setName("张三");

        List<String> phones = new ArrayList<>();
        customer.setPhones(phones);
        phones.add("1111111111111");
        phones.add("2222222222222");
        List<String> phones1 = customer.getPhones();
//        phones1.add("333333333333");
        /**
         * Exception in thread "main" java.lang.UnsupportedOperationException
         * 	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
         * 	at com.wyl.research.util.collection.CollectionTest.main(CollectionTest.java:15)
         */

        System.out.println(phones1);


    }
}
