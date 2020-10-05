package com.archsoft.other;

import com.archsoft.Parent;

public class ChildDifferentPackage extends Parent {

    public void execute() {
        publicField = 10;
        protectedField = 12;

        // Compile error: package visibility
        // packageField = 11;

        // Compile error: private visibility
        // privateField = 13;
    }
}
