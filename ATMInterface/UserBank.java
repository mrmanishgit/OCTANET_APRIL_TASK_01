package ATMInterface;

import java.util.Scanner;
import java.util.Random;

public class UserBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATMinterface sbi = new ATMinterface();
        
        System.out.println("Enter Your Name: ");
        sc.nextLine(); // Reads and discards name input
        
        System.out.println("Create User ID:");
        String userId = sc.nextLine();
        System.out.println("Create Password:");
        String password = sc.nextLine();
        sbi.setCredentials(userId, password);

        if (!sbi.validateLogin(userId, password)) {
            System.out.println("Invalid Credentials");
            sc.close();
            return;
        }

        Random random = new Random();
        sbi.accountNumber = random.nextInt(900000) + 100000;
        sbi.balance = 1000;
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n-------------------------");
            System.out.println("Choose Your Option");
            System.out.println("1: Withdraw");
            System.out.println("2: Deposit");
            System.out.println("3: Check Balance");
            System.out.println("4: Transaction History");
            System.out.println("5: Exit");
            System.out.println("-------------------------");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Amount to Withdraw: ");
                    double amount = sc.nextDouble();
                    sbi.withdraw(amount);
                    break;
                case 2:
                    System.out.print("Enter Amount to Deposit: ");
                    double amountDeposit = sc.nextDouble();
                    sbi.deposit(amountDeposit);
                    break;
                case 3:
                    sbi.checkBalance();
                    break;
                case 4:
                    sbi.transHistory();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for using our ATM service!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
        sc.close();
    }
}
