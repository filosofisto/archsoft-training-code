package com.archsoft;

@FunctionalInterface
public interface Validator<T> {

    boolean isValid(T t);
//    void someMethod();
    default void set() { }
}
