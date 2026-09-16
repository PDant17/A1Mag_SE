
public class BankAccount {
    //@ spec_public
    private int balance;

    /** Class invariant: the balance cannot be negative. */
    //@ public invariant balance >= 0;

    public BankAccount() {
        this.balance = 0;
    }

    /** Current balance (pure). */
    /*@ public normal_behavior
      @   ensures \result == balance;
      @   assignable \nothing;
      @*/
    public /*@ pure @*/ int getBalance() {
        return balance;
    }

    /** Deposit a non-negative amount. */
    /*@ public normal_behavior
      @   requires amount >= 0;
      @   requires balance <= Integer.MAX_VALUE - amount;
      @   assignable balance;
      @   ensures balance == \old(balance) + amount;
      @*/
    public void deposit(int amount) {
        balance += amount;
    }

    /** Withdraw an amount not exceeding balance. */
    /*@ public normal_behavior
      @   requires amount >= 0 && amount <= balance;
      @   assignable balance;
      @   ensures balance == \old(balance) - amount;
      @*/
    public void withdraw(int amount) {
        balance -= amount;
    }
}
