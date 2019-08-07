package com.azarenka.serialize;

import java.io.*;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.ser(buildChild());
        Child child = (Child) application.deser();
        System.out.println(child.toString());
    }

    public Object deser(){
        Object o = new Object();
        File file = new File("c:/object.txt");
        try {
            FileInputStream inputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            o = objectInputStream.readObject();
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }

    public boolean ser(Object o){
        File file = new File("c:/object.txt");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(o);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    private static Child buildChild() {
        AlienChild alienChild = new AlienChild();
        alienChild.setName("alien");
        Child child = new Child();
        child.setName("child");
        child.setAlienChild(alienChild);
        return child;
    }
}
