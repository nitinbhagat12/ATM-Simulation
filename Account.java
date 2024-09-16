public class Account {
    private String name;
    private String email;
    private String mobileNumber;
    private String accountNumber;
    private String pin;
    private double balance;

    public Account(String name, String email, String mobileNumber, String accountNumber, String pin) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = 0.0;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public boolean verifyPin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public void credit(double amount) {
        balance += amount;
    }

    public void debit(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }
}
