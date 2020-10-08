package com.archsoft;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import static java.lang.System.out;

public class DynamicLoader {

    public CustomExecution load(String classname) {
        try {
            Class classImplementation = Class.forName(classname);

            return (CustomExecution) classImplementation.getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
