package com.azarenka.serialize;

import java.io.Serializable;

public class AlienChild implements Serializable {

    private String name;

    public AlienChild() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AlienChild{" +
                "name='" + name + '\'' +
                '}';
    }
}
