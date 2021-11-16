package BankManagementSoftware;

import java.util.ArrayList;

public class User {

    private String userName;
    private int pinCode;
    private double moneyAmount;
    private long userId;
    public ArrayList<Transaction> transactionList;


    public User(String userName, int pinCode,long id){
        this.pinCode = pinCode;
        this.userName = userName;
        this.userId = id;
        this.transactionList = new ArrayList<>();
    }
    public String toString(){
        return userName + " with id: "+userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public long getUserId() {
        return userId;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}
