import java.util.Random;
import java.util.Scanner;

public class ATM {
    private static final int PIN_LENGTH = 4;
    private static final Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    public void simulateATMOperations() {
        Account account = createAccount();
        System.out.println("Account created. Account Number: " + account.getAccountNumber() + ", PIN: " + account.getPin());

        System.out.print("Enter PIN to access account: ");
        String inputPin = scanner.nextLine();

        if (account.verifyPin(inputPin)) {
            System.out.println("PIN verified. Access granted.");
            showMenu(account);
        } else {
            System.out.println("Incorrect PIN. Access denied.");
        }
    }

    public Account createAccount() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your mobile number: ");
        String mobileNumber = scanner.nextLine();

        String accountNumber = generateAccountNumber();
        String pin = generatePin();
        
        return new Account(name, email, mobileNumber, accountNumber, pin);
    }

    private String generateAccountNumber() {
        return String.format("%08d", random.nextInt(100000000));
    }

    private String generatePin() {
        StringBuilder pin = new StringBuilder();
        for (int i = 0; i < PIN_LENGTH; i++) {
            pin.append(random.nextInt(10));
        }
        return pin.toString();
    }

    private void showMenu(Account account) {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Current Balance: Rs." + account.getBalance());
                    break;
                case 2:
                    depositMoney(account);
                    break;
                case 3:
                    withdrawMoney(account);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void depositMoney(Account account) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            account.credit(amount);
            System.out.println("Deposited: Rs." + amount);
            System.out.println("New Balance: Rs." + account.getBalance());
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
    }

    private void withdrawMoney(Account account) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && account.getBalance() >= amount) {
            account.debit(amount);
            System.out.println("Withdrawn: Rs." + amount);
            System.out.println("New Balance: Rs." + account.getBalance());
        } else {
            System.out.println("Invalid amount or insufficient balance. Please try again.");
        }
    }
}

