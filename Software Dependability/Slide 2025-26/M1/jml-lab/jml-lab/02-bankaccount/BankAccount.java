
public class BankAccount {
    //@ spec_public
    private int balance;

    /** Class invariant: the balance cannot be negative. */
    //@ public invariant balance >= 0; // TODO: keep / discuss

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
      @   // TODO: add a precondition that amount is non-negative
      @   // TODO: add an assignable clause
      @   // TODO: add a postcondition describing how balance changes
      @*/
    public void deposit(int amount) {
        if (amount < 0) throw new IllegalArgumentException("amount < 0");
        balance += amount;
    }

    /** Withdraw an amount not exceeding balance. */
    /*@ public normal_behavior
      @   // TODO: preconditions on amount and sufficient funds
      @   // TODO: assignable clause
      @   // TODO: postcondition describing how balance changes
      @*/
    public void withdraw(int amount) {
        if (amount < 0 || amount > balance) throw new IllegalArgumentException("bad withdraw");
        balance -= amount;
    }
}
