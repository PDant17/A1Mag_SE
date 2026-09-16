
public class ArrayUtils {

    /** Count how many occurrences of v are in a. */
    /*@ public normal_behavior
      @   requires a != null;
      @   assignable \nothing;
      @   ensures \result >= 0;
      @   ensures \result <= a.length;
      @*/
    public static int count(int[] a, int v) {
        int c = 0;
        int i = 0;
        /*@ loop_invariant 0 <= i && i <= a.length;
          @ loop_invariant 0 <= c && c <= i;
          @ decreases a.length - i;
          @*/
        while (i < a.length) {
            if (a[i] == v) c++;
            i++;
        }
        return c;
    }

    /** Returns true iff all elements are non-negative. */
    /*@ public normal_behavior
      @   requires a != null;
      @   assignable \nothing;
      @   ensures \result <==> (\forall int i; 0 <= i && i < a.length; a[i] >= 0);
      @*/
    public static boolean allNonNegative(int[] a) {
        int i = 0;
        /*@ loop_invariant 0 <= i && i <= a.length;
          @ loop_invariant (\forall int k; 0 <= k && k < i; a[k] >= 0);
          @ decreases a.length - i;
          @*/
        while (i < a.length) {
            if (a[i] < 0) return false;
            i++;
        }
        return true;
    }
}
