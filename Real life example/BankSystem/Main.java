// Parent class
class Account {
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    // Constructor
    public Account(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter methods
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal!");
        }
    }

    // toString method
    @Override
    public String toString() {
        return "Account Holder: " + accountHolderName +
                "\nAccount Number: " + accountNumber +
                "\nBalance: " + balance;
    }
}

// CurrentAccount class
class CurrentAccount extends Account {
    private double dailyTransactionLimit;

    // Constructor
    public CurrentAccount(String accountHolderName, String accountNumber, double balance, double dailyTransactionLimit) {
        super(accountHolderName, accountNumber, balance);
        this.dailyTransactionLimit = dailyTransactionLimit;
    }

    // Getter for daily transaction limit
    public double getDailyTransactionLimit() {
        return dailyTransactionLimit;
    }

    // Override toString method
    @Override
    public String toString() {
        return super.toString() +
                "\nAccount Type: Current Account" +
                "\nDaily Transaction Limit: " + dailyTransactionLimit +
                "\nChequebook Facility: Available" +
                "\nInterest: Not Applicable";
    }
}

// SavingsAccount class
class SavingsAccount extends Account {
    private double yearlyInterestRate;

    // Constructor
    public SavingsAccount(String accountHolderName, String accountNumber, double balance, double yearlyInterestRate) {
        super(accountHolderName, accountNumber, balance);
        this.yearlyInterestRate = yearlyInterestRate;
    }

    // Method to calculate yearly interest
    public double calculateYearlyInterest() {
        return getBalance() * (yearlyInterestRate / 100);
    }

    // Getter for yearly interest rate
    public double getYearlyInterestRate() {
        return yearlyInterestRate;
    }

    // Override toString method
    @Override
    public String toString() {
        return super.toString() +
                "\nAccount Type: Savings Account" +
                "\nYearly Interest Rate: " + yearlyInterestRate + "%" +
                "\nChequebook Facility: Not Available" +
                "\nYearly Interest: " + calculateYearlyInterest();
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create CurrentAccount object
        CurrentAccount currentAccount = new CurrentAccount("Alice Smith", "CA123456", 5000.00, 20000.00);
        System.out.println(currentAccount);

        System.out.println();

        // Create SavingsAccount object
        SavingsAccount savingsAccount = new SavingsAccount("Bob Johnson", "SA987654", 10000.00, 3.5);
        System.out.println(savingsAccount);

        System.out.println();

        // Perform some transactions
        currentAccount.deposit(2000.00);
        currentAccount.withdraw(1000.00);
        System.out.println("\nAfter transactions:");
        System.out.println(currentAccount);

        System.out.println();

        savingsAccount.deposit(500.00);
        savingsAccount.withdraw(2000.00);
        System.out.println("\nAfter transactions:");
        System.out.println(savingsAccount);
    }
}
