
public class Counter {
    //@ spec_public
    private int count;
    //@ spec_public
    private final int id;

    public Counter(int id) {
        this.id = id;
        this.count = 0;
    }

    /** Returns the id (pure). */
    /*@ public normal_behavior
      @   ensures \result == id;
      @   assignable \nothing;
      @*/
    public /*@ pure @*/ int getId() { return id; }

    /** Returns the current count (pure). */
    /*@ public normal_behavior
      @   ensures \result == count;
      @   assignable \nothing;
      @*/
    public /*@ pure @*/ int get() { return count; }

    /** Increments the counter by 1. */
    /*@ public normal_behavior
      @   requires count < Integer.MAX_VALUE;
      @   assignable count;                   // frame condition
      @   ensures count == \old(count) + 1;   // effect
      @*/
    public void inc() { count++; }

    /** Resets the counter to zero. */
    /*@ public normal_behavior
      @   assignable count;
      @   ensures count == 0;
      @*/
    public void reset() { count = 0; }
}
