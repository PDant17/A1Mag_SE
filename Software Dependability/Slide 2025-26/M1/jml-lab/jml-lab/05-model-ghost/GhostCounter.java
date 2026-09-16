
public class GhostCounter {
    public int value;
    //@ public ghost int ops; // counts how many operations were performed

    /*@ public normal_behavior
      @   ensures value == 0; // TODO: also set and specify ops
      @*/
    public GhostCounter() {
        value = 0;
        /*@ // TODO: initialize ghost field
          @*/
    }

    /*@ public normal_behavior
      @   // TODO: assignable clause for both concrete and ghost state
      @   // TODO: ensure both value and ops increase appropriately
      @*/
    public void inc() {
        value++;
        /*@ // TODO: update ghost field with a set statement
          @*/
    }
}
