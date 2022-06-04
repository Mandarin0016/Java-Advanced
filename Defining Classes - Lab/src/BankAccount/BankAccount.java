package BankAccount;

public class BankAccount {
    private static int bankAccountCount = 1;
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;

    private double balance;
    private int id;

    public BankAccount(){
        this.id = bankAccountCount++;
    }
    public int getAccountId() {
        return this.id;
    }
    static void setInterestRate(double interest){
        BankAccount.interestRate = interest;
    }
    public double getInterest(int years){
        return BankAccount.interestRate * years * this.balance;
    }
    public void deposit(double amount){
        this.balance += amount;
    }
}
