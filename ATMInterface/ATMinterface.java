package ATMInterface;

import java.util.LinkedList;

interface ATM {
    double withdraw(double amount);
    double deposit(double amount);
    void checkBalance();
    void transHistory();
    boolean validateLogin(String userId, String password);
    void setCredentials(String userId, String password);
}

public class ATMinterface implements ATM {
    double balance;
    int accountNumber;
    String userId;
    String password;
    LinkedList<Double> accSheet = new LinkedList<>();

    @Override
    public double withdraw(double amount) {
        if (balance >= amount) {
            System.out.println("\nRs." + amount + " has been withdrawn from Your Bank Account " + accountNumber);
            balance -= amount;
            accSheet.add(-amount);
            return balance;
        } else {
            System.out.println("Insufficient Balance");
            return balance;
        }
    }

    @Override
    public double deposit(double amount) {
        balance += amount;
        System.out.println("\nRs." + amount + " has Successfully Deposited in Your Bank Account " + accountNumber);
        accSheet.add(amount);
        return balance;
    }

    @Override
    public void checkBalance() {
        System.out.println("Your Bank Account " + accountNumber + " has a balance of Rs." + balance);
    }

    @Override
    public void transHistory() {
        for (double transaction : accSheet) {
            if (transaction > 0) {
                System.out.println(transaction + " has been Deposited in your Account " + accountNumber);
            } else {
                System.out.println(-transaction + " has been Withdrawn from your Account " + accountNumber);
            }
        }
    }

    @Override
    public boolean validateLogin(String userId, String password) {
        return this.userId.equals(userId) && this.password.equals(password);
    }

    @Override
    public void setCredentials(String userId, String password) {
        this.userId = userId;
        this.password = password;
    } 

    
}


