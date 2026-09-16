
public class GhostCounter {
    public int value;
    //@ public ghost int ops; // counts how many operations were performed

    /*@ public normal_behavior
      @   ensures value == 0 && ops == 0;
      @*/
    public GhostCounter() {
        value = 0;
        /*@ set ops = 0; @*/
    }

    /*@ public normal_behavior
      @   requires value < Integer.MAX_VALUE && ops < Integer.MAX_VALUE;
      @   assignable value, ops;
      @   ensures value == \old(value) + 1 && ops == \old(ops) + 1;
      @*/
    public void inc() {
        value++;
        /*@ set ops = ops + 1; @*/
    }
}
