package com.example.p2;

import org.openjdk.jmh.annotations.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 2)
@Measurement(iterations = 3)
@Fork(1)
public class StringJoinerBenchmark {

    @State(Scope.Thread)
    public static class Data {
        @Param({"10","100"}) int n;
        List<String> list;
        StringJoinerUtil util;
        @Setup public void setup() {
            util = new StringJoinerUtil();
            list = new ArrayList<>();
            for (int i = 0; i < n; i++) list.add("x" + i);
        }
    }

    @Benchmark public String join(Data d) { return d.util.joinWithPlus(d.list); }
}
