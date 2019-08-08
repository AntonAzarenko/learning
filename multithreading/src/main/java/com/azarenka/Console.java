package com.azarenka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Console {

    private Command command;

    Console() {
        command = new CommandHandler();
    }

    void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String strCom = reader.readLine();
                command.handle(strCom);
            }
        } catch (IOException e) {
            Util.showText(e.getMessage());
        }

    }
}
