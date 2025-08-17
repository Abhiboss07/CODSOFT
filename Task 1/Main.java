import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Successfully withdrew: $" + amount);
                return true;
            } else {
                System.out.println("Insufficient balance for this withdrawal.");
                return false;
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        if (scanner.hasNextDouble()) {
                            double depositAmount = scanner.nextDouble();
                            deposit(depositAmount);
                        } else {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.next();
                        }
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                         if (scanner.hasNextDouble()) {
                            double withdrawAmount = scanner.nextDouble();
                            withdraw(withdrawAmount);
                        } else {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.next();
                        }
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next();
            }
        }
        scanner.close();
    }

    public void checkBalance() {
        System.out.printf("Your current balance is: $%.2f\n", userAccount.getBalance());
    }

    public void deposit(double amount) {
        userAccount.deposit(amount);
    }

    public void withdraw(double amount) {
        userAccount.withdraw(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00);
        ATM atm = new ATM(account);
        atm.showMenu();
    }
}
