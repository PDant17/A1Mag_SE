package com.example.p2;

import java.util.Arrays;

public class ArrayUtils {
    public int sumStream(int[] a) {
        return Arrays.stream(a).sum();
    }
}
