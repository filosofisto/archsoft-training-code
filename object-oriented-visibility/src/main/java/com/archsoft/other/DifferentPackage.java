package com.archsoft.other;

import com.archsoft.Parent;

public class DifferentPackage {

    public void execute() {
        Parent p = new Parent();
        p.publicField = 10;

        // Compile error - different package
        // p.packageField = 11;

        // Compile error - no child
        // p.protectedField = 12;

        // Compile error: private visibility
        // privateField = 13;
    }
}
