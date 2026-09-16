
public class MaxUtils {

    /**
     * Return the maximum of two integers.
     */
    /*@ public normal_behavior
      @   requires true;                 // TODO: keep as is
      @   ensures (\result == a) || (\result == b);
      @   ensures \result >= a && \result >= b;
      @*/
    public static int max(int a, int b) {
        return (a >= b) ? a : b;
    }

    /**
     * Safe integer division.
     */
    /*@ public normal_behavior
      @   requires b != 0;              // TODO: why is this needed?
      @   requires !(a == Integer.MIN_VALUE && b == -1);
      @   ensures \result == a / b;
      @   assignable \nothing;         // pure function
      @*/
    public static int safeDiv(int a, int b) {
        return a / b;
    }

    /**
     * Absolute value.
     */
    /*@ public normal_behavior
      @   requires a != Integer.MIN_VALUE;
      @   ensures \result >= 0;
      @   ensures (a >= 0 ==> \result == a) && (a < 0 ==> \result == -a);
      @   assignable \nothing;
      @*/
    public static int abs(int a) {
        return (a >= 0) ? a : -a;
    }
}
