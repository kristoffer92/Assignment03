package WeekThreeExercisesPractice;
import java.util.Scanner;
public class Bank {
    public static void main(String[] args) {
        BankAccount bankAccOne = new BankAccount("Chris","chris@hotmail.com","0734536545","1234 1234 1234 1234",500);
        BankAccount bankAccTwo = new BankAccount("John", "john@hotmail.com", "0742132561", "4322 4442 3334 1114", 0);
        BankAccount bankAccThree = new BankAccount("Daniel", "daniel@hotmail.com", "0765132561", "7322 2442 3334 1114", 125);
        bankAccOne.information(); //bankAccTwo has 0 balance and can't withdraw
        bankAccOne.makeSwitch();
    }
}
