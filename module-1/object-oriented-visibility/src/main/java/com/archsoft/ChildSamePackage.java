package com.archsoft;

public class ChildSamePackage extends Parent {

    public void execute() {
        publicField = 10;
        packageField = 11;
        protectedField = 12;
        // Compile error: private visibility
        // privateField = 13;

        Parent p = new Parent();
        p.publicField = 10;
        p.packageField = 11;
        p.protectedField = 12;
        // Compile error: private visibility
        // p.privateField = 13;
    }
}
