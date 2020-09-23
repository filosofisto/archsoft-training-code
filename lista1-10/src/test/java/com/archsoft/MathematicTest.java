package com.archsoft;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathematicTest {

    @Test
    public void checkZero() {
        assertEquals(1, Mathematic.fat(0));
    }

    @Test
    public void checkOne() {
        assertEquals(1, Mathematic.fat(1));
    }

    @Test
    public void checkGreaterThanOne() {
        assertEquals(2, Mathematic.fat(2));
    }

    @Test
    public void checkRZero() {
        assertEquals(1, Mathematic.rfat(0));
    }

    @Test
    public void checkROne() {
        assertEquals(1, Mathematic.rfat(1));
    }

    @Test
    public void checkRGreaterThanOne() {
        assertEquals(2, Mathematic.rfat(2));
    }
}
