package com.azarenka;

@Service(name = "superSimple", lazyLoad = true)
public class SimpleService {

    @Init()
    public void simpleInit(){
        System.out.println("simpleInit");
    }

    public void print(){
        System.out.println("lazy class");
    }
}
