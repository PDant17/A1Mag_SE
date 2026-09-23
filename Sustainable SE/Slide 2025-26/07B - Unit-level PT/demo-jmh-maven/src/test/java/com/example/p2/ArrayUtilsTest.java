package com.example.p2;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtilsTest {
    @Test public void sumsWithStream() {
        ArrayUtils u = new ArrayUtils();
        assertEquals(10, u.sumStream(new int[]{1,2,3,4}));
    }
}
