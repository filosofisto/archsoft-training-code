package com.archsoft;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import static java.lang.System.out;

public class DynamicLoader {

    public CustomExecution load(String jarFilePath, String classname) {
        try {
            File file = new File(jarFilePath);
            ClassLoader loader = URLClassLoader.newInstance(
                    new URL[] { file.toURI().toURL() },
                    getClass().getClassLoader()
            );
            Class classImplementation = Class.forName(classname, true, loader);

            return (CustomExecution) classImplementation.getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
