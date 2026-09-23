package com.example.p1;

import org.junit.Test;
import static org.junit.Assert.*;

public class PrimeCheckerTest {
    @Test public void primesWork() {
        PrimeChecker pc = new PrimeChecker();
        assertTrue(pc.isPrime(2));
        assertTrue(pc.isPrime(97));
        assertFalse(pc.isPrime(1));
        assertFalse(pc.isPrime(100));
    }
}
