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

    Map<String, Method> loadCommands(String fileName) {
        Map<String, Method> mapWithMethods = new HashMap<>();
        Properties properties = new Properties();
        InputStream inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream(fileName);
        try {
            properties.load(inputStream);
            Map<String, String> file = loadFile(fileName);
            file.forEach((commands, methodName) -> {
                Method method = getMethod(methodName);
                mapWithMethods.put(commands, method);
            });
            Objects.requireNonNull(inputStream).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapWithMethods;
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

    public static void main(String[] args) {
        Map<String, Method> str = new PropertiesLoader().loadCommands("commands.properties");
        str.forEach((key, value) -> System.out.println(key + " = " + value.toString()));
    }
}
