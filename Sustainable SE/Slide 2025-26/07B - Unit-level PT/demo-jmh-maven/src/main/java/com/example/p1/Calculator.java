package com.example.p1;

public class Calculator {
    public int sumLoop(int[] a) {
        int s = 0;
        for (int v : a) s += v;
        return s;
    }
}
