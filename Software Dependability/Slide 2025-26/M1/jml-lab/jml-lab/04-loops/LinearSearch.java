
public class LinearSearch {

    /**
     * Returns the index of v in a, or -1 if not found.
     */
    /*@ public normal_behavior
      @   requires a != null;
      @   assignable \nothing;
      @   ensures (\result == -1 ==> (\forall int k; 0 <= k && k < a.length; a[k] != v));
      @   ensures (\result != -1 ==> (0 <= \result && \result < a.length && a[\result] == v));
      @*/
    public static int indexOf(int[] a, int v) {
        int i = 0;
        /*@ loop_invariant 0 <= i && i <= a.length;
          @ // TODO: add the main content invariant expressing that v was not seen yet
          @ decreases a.length - i;
          @ assignable \nothing;
          @*/
        while (i < a.length) {
            if (a[i] == v) return i;
            i++;
        }
        return -1;
    }
}
