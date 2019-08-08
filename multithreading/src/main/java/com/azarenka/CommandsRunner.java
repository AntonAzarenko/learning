package com.azarenka;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CommandsRunner extends Thread implements Commands {

    private Method method;

    public CommandsRunner(Method method) {
        this.method = method;
    }

    @Override
    public void run() {
        try {
            method.invoke(this);
        } catch (IllegalAccessException | InvocationTargetException e) {
           Util.showText(e.getMessage());
        }
    }

    @Override
    public void startDev() {
        Util.showText("Starting dev....");
    }

    @Override
    public void exit() {
        new Application().exit();
    }

    @Override
    public void showCommandList() {
        Map<String, String> map = new HashMap<>();
        PropertiesLoader loader = new PropertiesLoader();
        Util.showHelp(loader.loadFile("descriptions.properties"));
    }
}
