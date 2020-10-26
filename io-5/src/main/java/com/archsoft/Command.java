package com.archsoft;

@FunctionalInterface
public interface Command {

    String execute(String input);
}
