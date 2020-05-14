package com.wyl.research.util.collection;

import java.util.Collections;
import java.util.List;

public class Customer {
    private String name;
    private List<String> phones;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhones() {
        return Collections.unmodifiableList(phones);
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
}
