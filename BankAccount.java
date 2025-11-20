import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Account {
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        this.transactionHistory.add("Initial balance: $" + initialBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            this.transactionHistory.add("Deposited: $" + amount);
            System.out.println("Deposited $" + amount + " successfully.");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            this.transactionHistory.add("Withdrew: $" + amount);
            System.out.println("Withdrew $" + amount + " successfully.");
        } else if (amount > this.balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public void displayTransactionHistory() {
        System.out.println("\n--- Transaction History for Account " + this.accountNumber + " ---");
        for (String transaction : this.transactionHistory) {
            System.out.println(transaction);
        }
        System.out.println("Current Balance: $" + this.balance);
        System.out.println("--------------------------------------------------");
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    
    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest); 
        System.out.println("Interest of $" + interest + " applied.");
    }
}
public class BankAccount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     
        System.out.println("Creating a new basic checking account (12345) with $1000 initial balance.");
        Account checking = new Account("12345", 1000.0);

        
        checking.deposit(200.0);
        checking.withdraw(50.0);
        checking.withdraw(1500.0); 
        checking.displayTransactionHistory();

        
        System.out.println("\nCreating a new savings account (67890) with $500 initial balance and 5% interest rate.");
        SavingsAccount savings = new SavingsAccount("67890", 500.0, 0.05);
        
        
        savings.deposit(100.0);
        savings.applyInterest();
        savings.displayTransactionHistory();

        scanner.close();
    }
}