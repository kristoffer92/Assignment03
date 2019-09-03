package WeekThreeExercisesPractice;
import java.util.Scanner;


public class BankAccount {
    private String customerName;
    private String email;
    private String phoneNumber;
    private String accountNumber;
    private double balance;

    public BankAccount(String customerName, String email, String phoneNumber, String accountNumber, double balance) {
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void information() {
        System.out.println("Name: " + customerName + "\nEmail: " + email + "\nPhoneNumber: " + phoneNumber + "\nAccountNumber: " + accountNumber + "\nBalance: " + balance);
    }

    public void setCustumerName(String custumerName) {
        this.customerName = custumerName; }
    public String getCustumerName()
    {
        return customerName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public double resultDeposit() {
        System.out.println("----------------------------------------");
        Scanner scanner = new Scanner(System.in);
        int value;
        System.out.println("How much do you wanna deposit: ");
        value = scanner.nextInt();
        double result = value + balance;
        System.out.println("Your balance is now: " + result);
        return result;
    }
    public double resultWithdraw() {
        System.out.println("----------------------------------------");
        Scanner scanner = new Scanner(System.in);
        int value;
        System.out.println("How much do you wanna deposit: ");
        value = scanner.nextInt();
        double result = balance - value;
        if (balance == 0){//Can't withdraw
            System.out.println("You can't Withdraw, your balance is "+balance);
            return 0;
        }
        System.out.println("Your balance is now: " + result);
        return result;
    }
    public double makeSwitch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Make your choice: ");
        System.out.println("1. Deposit\n2. Withdraw\n3. Quit");
        int looping =-1;
        looping=scanner.nextInt();
        boolean loop =true;
        while (loop) {
            switch (looping) {
                case 1:
                    resultDeposit();
                    break;
                case 2:
                    resultWithdraw();
                    break;
                case 3:
                    loop = false;
                    System.out.println("You decided to leave");
                    break;
                default:
                    System.out.println("Error");
            }return balance;
        }return balance;
    }
}

