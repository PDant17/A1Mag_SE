
public class SortedArray {

    /**
     * Returns the index of v in a sorted non-decreasing array, or -1.
     */
    /*@ public normal_behavior
      @   requires a != null;
      @   requires (\forall int i; 0 <= i && i+1 < a.length; a[i] <= a[i+1]);
      @   assignable \nothing;
      @   ensures (\result == -1 ==> (\forall int k; 0 <= k && k < a.length; a[k] != v));
      @   ensures (\result != -1 ==> (0 <= \result && \result < a.length && a[\result] == v));
      @*/
    public static int binarySearch(int[] a, int v) {
        int lo = 0, hi = a.length - 1;
        /*@ loop_invariant 0 <= lo && hi < a.length || a.length == 0;
          @ // TODO: add the classic binary search invariants about the search range
          @ assignable \nothing;
          @ decreases (hi - lo >= 0 ? hi - lo : 0);
          @*/
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == v) return mid;
            if (a[mid] < v) lo = mid + 1; else hi = mid - 1;
        }
        return -1;
    }
}
