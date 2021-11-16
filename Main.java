package BankManagementSoftware;

import java.util.ArrayList;

public class Main {

    public static ArrayList<User> bankUsers = new ArrayList<>();

    public static void main(String[] args) {
        User userOne = new User("Dorant",1222,1111111111);
        bankUsers.add(userOne);
        User userTwo = new User("Diana",1234,1111111112);
        bankUsers.add(userTwo);
        User userThree = new User("Denis",1122,1111111110);
        bankUsers.add(userThree);

        try {
            Bank bank = new Bank("BKT", 1222, userOne);
           bank.deposit(5000);
           bank.deposit(56.4);
           bank.deposit(465.9);

           bank.moneyTransfer("BKT",1000,1111111110);
            System.out.println(userOne.getMoneyAmount());
           bank.moneyTransfer("Raifaisen",1500,1111111112);
            System.out.println(userOne.getMoneyAmount());

            bank.withDraw(3000);
            bank.getTransactionList();
        System.out.println("------------------------------------------------------------------");
        Bank bank1 = new Bank("Raiffaisen",1234,userTwo);
        bank1.deposit(55);
        bank1.deposit(1000);
        bank1.deposit(2000);
        bank1.withDraw(55);
        bank1.moneyTransfer("BKT",500,1111111110);


        bank1.getTransactionList();
            System.out.println("-----------------------------------------------------------------");
            Bank bank2 = new Bank("TEB",1122,userThree);
            System.out.println(userThree.getMoneyAmount());
            bank2.takeLoan(5000,11);




















        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
