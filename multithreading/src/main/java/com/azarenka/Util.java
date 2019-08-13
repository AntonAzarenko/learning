package com.azarenka;

import java.util.Map;

public class Util {

    public static void showText(String message){
        System.out.println("-----------------------------------------");
        System.out.println(message);
    }

    public static void showHelp(Map<String, String> helpsMap) {
        System.out.println("-----------------------------------------");
        helpsMap.forEach((command, description) -> {
            System.out.println("-- " + command + " <" + description + ">");
        });
        System.out.println("-----------------------------------------");
    }

    public static void showLoad(){
        System.out.print("Loading");
    }
}
