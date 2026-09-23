package com.example.p2;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 2)
@Measurement(iterations = 3)
@Fork(1)
public class ArrayUtilsBenchmark {

    @State(Scope.Thread)
    public static class Data {
        @Param({"64","2048"}) int size;
        int[] a;
        ArrayUtils utils;
        @Setup public void setup() {
            utils = new ArrayUtils();
            a = new int[size];
            Random r = new Random(1);
            for (int i = 0; i < size; i++) a[i] = r.nextInt(10);
        }
    }

    @Benchmark public int sumStream(Data d) { return d.utils.sumStream(d.a); }
}
