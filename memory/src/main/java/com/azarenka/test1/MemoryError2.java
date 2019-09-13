package com.azarenka.test1;

public class MemoryError2 {

    public static void main(String[] args) {
       long arr[] = new long[100000000];
       ClassLoader loader = new ClassLoader() {
           @Override
           public Class<?> loadClass(String name) throws ClassNotFoundException {
               return super.loadClass(name);
           }
       }
    }
}
