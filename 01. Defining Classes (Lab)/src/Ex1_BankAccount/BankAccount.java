package Ex1_BankAccount;

public class BankAccount {
    private int id;
    private double balance;

    public BankAccount(int id) {
        this.id = id;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("Account ID%s, balance %.2f", this.id, this.balance);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
