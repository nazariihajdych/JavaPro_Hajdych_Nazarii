package com.hillel.hajdych.homeworks.hw19;

import com.hillel.hajdych.homeworks.hw19.MyAnnotation.AfterSuite;
import com.hillel.hajdych.homeworks.hw19.MyAnnotation.BeforeSuite;
import com.hillel.hajdych.homeworks.hw19.MyAnnotation.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestRunner {
    public static void start(Class<?> testClass){
        try {
            Object testObject = testClass.getConstructor().newInstance();

            Method[] declaredMethods = testClass.getDeclaredMethods();
            List<Method> beforeSuiteMethods = new ArrayList<>();
            List<Method> afterSuiteMethods = new ArrayList<>();
            List<Method> testMethods = new ArrayList<>();

            for (Method method: declaredMethods) {
                if (method.isAnnotationPresent(BeforeSuite.class)){
                    if (!beforeSuiteMethods.isEmpty()){
                        throw new RuntimeException("Знайдено більше одного @BeforeSuit анотованих методів!");
                    }
                    beforeSuiteMethods.add(method);
                } else if (method.isAnnotationPresent(Test.class)) {
                    testMethods.add(method);
                } else if (method.isAnnotationPresent(AfterSuite.class)) {
                    if (!afterSuiteMethods.isEmpty()){
                        throw new RuntimeException("Знайдено більше одного @AfterSuit анотованих методів!");
                    }
                    afterSuiteMethods.add(method);
                }
            }

            if (!beforeSuiteMethods.isEmpty()) {
                beforeSuiteMethods.get(0).invoke(testObject);
            }

            testMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(Test.class).value()));

            if (!testMethods.isEmpty()) {
                for (Method method : testMethods) {
                    method.invoke(testObject);
                }
            }

            if (!afterSuiteMethods.isEmpty()) {
                afterSuiteMethods.get(0).invoke(testObject);
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}

