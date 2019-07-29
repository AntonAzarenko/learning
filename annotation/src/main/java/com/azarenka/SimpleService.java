package com.azarenka;

@Service(name = "superSimple")
public class SimpleService {

    @Init()
    public void simpleInit(){
        System.out.println("simpleInit");
    }

    public void print(){
        System.out.println("lazy class");
    }
}
