package com.archsoft;

public class ChildSamePackage extends Parent {

    public void execute() {
        publicField = 10;
        packageField = 11;
        protectedField = 12;
        // Compile error: private visibility
        // privateField = 13;
    }
}
