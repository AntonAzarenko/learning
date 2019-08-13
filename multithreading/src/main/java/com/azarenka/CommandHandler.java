package com.azarenka;

import java.lang.reflect.Method;
import java.util.Map;

public class CommandHandler implements Command {

    @Override
    public boolean handle(String command) {
        boolean isExist = false;
        Map<String, Method> mapWithMethods = PropertiesLoader.allCommands;
        for(Map.Entry<String, Method> pair: mapWithMethods.entrySet()){
            if (pair.getKey().equals(command)) {
                delegateToRun(pair.getValue());
                isExist = true;
                break;
            }
        }if(!isExist){
            Util.showText("We haven't that command is " + command + ". Enter 'help' to show all accessible commands.");
        }
        return isExist;
    }

    private void delegateToRun(Method method) {
        CommandsRunner runner = new CommandsRunner(method);
        runner.start();
    }
}
