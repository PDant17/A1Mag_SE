package com.example.p2;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class StringJoinerUtilTest {
    @Test public void joinsWithPlus() {
        StringJoinerUtil u = new StringJoinerUtil();
        assertEquals("a+b+c", u.joinWithPlus(Arrays.asList("a","b","c")));
    }
}
