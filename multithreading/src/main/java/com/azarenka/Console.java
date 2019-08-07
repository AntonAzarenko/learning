package com.azarenka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console extends Thread {

    private Command command;

    public Console() {
        command = new CommandHandler();
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String strCom = reader.readLine();
                if (strCom.equals("exit")) {
                    this.interrupt();
                    new Application().exit();
                    reader.close();
                } else {
                    command.handle(strCom);
                }
            }
        } catch (IOException e) {
            Util.showText(e.getMessage());
        }

    }
}
