package annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AnnotationProcessor {

    static Map<String, Object> maps = new HashMap<>();

    public static void main(String[] args) {

        inspectService("annotations.LazyService");
        inspectService("annotations.SimpleService");


    }

    public static void inspectService(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            if (clazz.isAnnotationPresent(Service.class)) {
                Object obj = clazz.newInstance();
                maps.put(className, obj);
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(Init.class)) {
                        try {
                            if (clazz.getAnnotation(Service.class).lazyLoad()) {
                                System.out.println(method.getName() + " lazyLoad");
                            } else {
                                method.setAccessible(true);
                                method.invoke(obj);
                            }
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }

}
