package com.azarenka;

public class Application {

    private Console console;

    public static void main(String[] args) {
        new Application().start();
    }

    private void start() {
        console = new Console();
        Util.showText("Loading...");
        PropertiesLoader loader = new PropertiesLoader();
        loader.loadCommands();
        Util.showText("Starting program Console...");
        console.run();
    }

    public void exit() {
        Util.showText("Program will be close...");
        System.exit(0);
    }
}
