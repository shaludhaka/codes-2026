package com.java.codes;

import com.java.codes.javaconcepts.Reflection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.InvocationTargetException;

@SpringBootApplication
public class CodesApplication {

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchFieldException {
        SpringApplication.run(CodesApplication.class, args);

        Reflection reflection = new Reflection();
        reflection.reflectionTest();
    }
}
