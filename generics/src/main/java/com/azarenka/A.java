package com.azarenka;

import java.util.ArrayList;
import java.util.List;

public class A {

    public static void main(String[] args) {
        A a = new A();

        Container<Product> container = new Container<>();
        Container<Camera> container2 = new Container<>();
        Container<Phone> container3 = new Container<>();
        //Container<String> container4 = new Container<>();

        List<Integer> list = new ArrayList<>();
        list.add(1);

        List<Camera> cameras = new ArrayList<>();
        a.findOne(cameras, new Camera());
        a.findOne(cameras, new Phone());

        a.findTwo(cameras, new Camera());
        a.findTwo(cameras, new Phone());


        Camera camera1 = new Camera();
        Camera camera2 = new Camera();

        //camera1.compareTo(camera2);
        //camera1.compareTo(new Phone());
        List<Product> product = new ArrayList<>();
        product.add(camera1);
        product.add(new Phone());
    }

    public void findOne(List<? extends Product> list, Product p) {

    }

    private <T extends Product> boolean findTwo(List<? extends Product> list, Product t) {
        return false;
    }

    private void copy(List<Camera> src, List<? super Product> temp) {
        for (Product p : src) {
            temp.add(p);
        }
    }
}
