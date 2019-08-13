package com.azarenka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class PropertiesLoader {

    public static final Map<String, Method> allCommands = new HashMap<>();
    private final String FILE_NAME = "commands.properties";

    void loadCommands() {
        Map<String, Method> mapWithMethods = new HashMap<>();
        Properties properties = new Properties();
        InputStream inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream(FILE_NAME);
        try {
            properties.load(inputStream);
            Map<String, String> file = loadFile(FILE_NAME);
            file.forEach((commands, methodName) -> {
                Method method = getMethod(methodName);
                mapWithMethods.put(commands, method);
            });
            Objects.requireNonNull(inputStream).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        allCommands.putAll(mapWithMethods);
    }

     Map<String, String> loadFile(String fileName) {
        InputStream inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream(fileName);
        Map<String, String> lines = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)));
            while ((reader.ready())) {
                String line = reader.readLine();
                String[] splitLine = line.split("=");
                lines.put(splitLine[0], splitLine[1]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            //todo
        }
        return lines;
    }

    private Method getMethod(String methodName) {
        Method method = null;
        try {
            Class<?> clazz = Class.forName("com.azarenka.CommandsRunner");
            Method[] methods = clazz.getMethods();
            for (Method current : methods) {
                if (methodName.equals(current.getName())) {
                    method = current;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return method;
    }
}
