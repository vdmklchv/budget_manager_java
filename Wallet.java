package budget;

public class Wallet {

    private double balance;

    public Wallet() {
        this.balance = 0;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    void addIncome(double sum) {
        this.balance += sum;
        System.out.println("Income was added!");
        System.out.println();
    }

    void addExpense(double sum) {
        this.balance -= sum;
        if (this.balance < 0) {
            this.balance = 0;
        }
    }
}
