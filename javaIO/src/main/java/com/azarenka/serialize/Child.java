package com.azarenka.serialize;

import java.io.Serializable;

public class Child extends Parent implements Serializable {
    private String name;
    private  AlienChild alienChild;

    public Child() {
        System.out.println("Child::constructor");
    }

    public AlienChild getAlienChild() {
        return alienChild;
    }

    public void setAlienChild(AlienChild alienChild) {
        this.alienChild = alienChild;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", alienChild=" + alienChild +
                '}';
    }
}
