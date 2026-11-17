import java.util.ArrayList;
import java.util.Scanner;

public class BankManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<BankAccount> accounts = new ArrayList<>();

        while (true) {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 6) {
                System.out.println("Thank You!");
                break;
            }

            // CREATE ACCOUNT
            if (choice == 1) {

                System.out.print("Enter Account Number: ");
                int number = sc.nextInt();

                boolean exists = false;

                for (BankAccount acc : accounts) {

                    if (acc.getAccountNumber() == number) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    System.out.println("Account Already Exists!");
                    continue;
                }

                System.out.print("Enter Holder Name: ");
                String name = sc.next();

                System.out.print("Enter Initial Balance: ");
                double initialBalance = sc.nextDouble();

                if (initialBalance < 0) {
                    System.out.println("Invalid Balance!");
                    continue;
                }

                BankAccount newAccount =
                        new BankAccount(number, name, initialBalance);

                accounts.add(newAccount);

                System.out.println("Account Created Successfully!");
            }

            // DISPLAY ALL ACCOUNTS
            else if (choice == 5) {

                if (accounts.isEmpty()) {
                    System.out.println("No Accounts Found!");
                }

                for (BankAccount acc : accounts) {
                    acc.display();
                    System.out.println("--------------------");
                }
            }

            // DEPOSIT, WITHDRAW OR CHECK BALANCE
            else if (choice >= 2 && choice <= 4) {

                System.out.print("Enter Account Number: ");
                int number = sc.nextInt();

                BankAccount found = null;

                for (BankAccount acc : accounts) {

                    if (acc.getAccountNumber() == number) {
                        found = acc;
                        break;
                    }
                }

                if (found == null) {
                    System.out.println("Account Not Found!");
                    continue;
                }

                // DEPOSIT
                if (choice == 2) {

                    System.out.print("Enter Deposit Amount: ");
                    double amount = sc.nextDouble();

                    found.deposit(amount);
                }

                // WITHDRAW
                else if (choice == 3) {

                    System.out.print("Enter Withdrawal Amount: ");
                    double amount = sc.nextDouble();

                    found.withdraw(amount);
                }

                // BALANCE ENQUIRY
                else if (choice == 4) {

                    found.checkBalance();
                }
            }

            else {
                System.out.println("Invalid Choice!");
            }
        }

        sc.close();
    }
}