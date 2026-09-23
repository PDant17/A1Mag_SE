package com.example.p1;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test public void sumsCorrectly() {
        Calculator c = new Calculator();
        assertEquals(6, c.sumLoop(new int[]{1,2,3}));
    }
}
