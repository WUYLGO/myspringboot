package com.example.demo.util.proxy;

public class PersonImpl implements Person {
    private String name;
    @Override
    public void goWorking() {
        System.out.println("name="+name+"去工作");
    }

    @Override
    public String getName(String name) {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }
}
