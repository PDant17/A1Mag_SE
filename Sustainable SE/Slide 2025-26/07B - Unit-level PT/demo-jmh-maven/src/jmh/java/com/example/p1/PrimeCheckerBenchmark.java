package com.example.p1;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 2)
@Measurement(iterations = 3)
@Fork(1)
public class PrimeCheckerBenchmark {

    @State(Scope.Thread)
    public static class Input {
        @Param({"97","15485863"}) // small and large prime
        int n;
        PrimeChecker pc;
        @Setup public void setup() { pc = new PrimeChecker(); }
    }

    @Benchmark public boolean isPrime(Input i) { return i.pc.isPrime(i.n); }
}
