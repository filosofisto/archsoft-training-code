package com.archsoft;

public class SamePackage {

    public void execute() {
        Parent p = new Parent();

        p.publicField = 12; // public visibility
        p.protectedField = 11; // same package
        p.packageField = 10; // same package

        // Compile error: private visibility
        // p.privateField = 13;
    }
}
