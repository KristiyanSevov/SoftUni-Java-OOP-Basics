package Ex2_ConstructorsAndStatics;

public class BankAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.02;

    private static int bankAccountCount;
    private static double interestRate = DEFAULT_INTEREST_RATE;

    private int id;
    private double balance;

    public BankAccount() {
        this.id = ++bankAccountCount;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getInterest(int years) {
        return this.balance * interestRate * years;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }
}
