package BankManagementSoftware;



public class Bank {

    private String bankName;
    //    private int pin;
    private User user;
    private double amount;


    public Bank(String bankName, int pin, User user) throws CodeException {
        this.bankName = bankName;
        this.user = user;
        if (checkPinCode(pin)) {
            System.out.print("Correct Code!,");
            System.out.println(" Welcome back " + this.user.getUserName());
        } else {
            throw new CodeException("Wrong Code");
        }
    }

    private boolean checkPinCode(int code) {
        if (code == this.user.getPinCode()) {
            return true;
        }
        return false;
    }


    public void deposit(double depositAmount) {
        double allowedAmountOfDeposit = 100000;
        if (depositAmount >= 50 && depositAmount <= allowedAmountOfDeposit) {
            amount += depositAmount;
            System.out.println("The amount of \"" + depositAmount + "\" has been deposited in your balance. ");
            Transaction transaction = new Transaction("Deposit - " + depositAmount);
            this.user.transactionList.add(transaction);
            System.out.println("Total Balance: " + amount);
            this.user.setMoneyAmount(amount);
        } else {
            System.out.println("That amount is not alowed.");
        }
    }

    public void getTransactionList() {
        System.out.println("Your Transcations: ");
        for (int i = 0; i < this.user.transactionList.size(); i++) {
            System.out.println((i + 1) + ". " + this.user.transactionList.get(i).toString());
        }
    }

    public void withDraw(double withdrawAmount) {
        double allowedAmountOfWithDraw = 3000;
        if (amount >= withdrawAmount) {
            if (withdrawAmount <= allowedAmountOfWithDraw) {
                amount -= withdrawAmount;
                System.out.println("The amount of \"" + withdrawAmount + "\" has been withdrawed from your balance. ");
                Transaction transaction = new Transaction("Withdraw - " + withdrawAmount);
                this.user.transactionList.add(transaction);
                System.out.println("Total Balance: " + amount);
                this.user.setMoneyAmount(amount);
            } else {
                System.out.println("That amount is not allowed.");
            }
        } else {
            System.out.println("No Deposit");
        }
    }

    private boolean findId(long userId){
        for (int i = 0; i < Main.bankUsers.size(); i++) {
            if (Main.bankUsers.get(i).getUserId() == userId){
                return true;
            }
        }
        return false;
    }

    public void moneyTransfer(String bankName, double moneyAmount, long userId) {
        if (this.user.getMoneyAmount() > moneyAmount) {
            if (this.bankName.equals(bankName)) {
                for (int i = 0; i < Main.bankUsers.size(); i++) {
                    if (Main.bankUsers.get(i).getUserId() == userId) {
                        double number = Main.bankUsers.get(i).getMoneyAmount() + moneyAmount;
                        Main.bankUsers.get(i).setMoneyAmount(number);
                        this.user.setMoneyAmount(amount - moneyAmount);
                        amount -= moneyAmount;
                        System.out.println("A " + moneyAmount + " transfer was made from your balance (No Fee taken)");
                        Transaction transaction = new Transaction("Transfer - " + moneyAmount + " to - " + Main.bankUsers.get(i).toString());
                        this.user.transactionList.add(transaction);
                    }
                }
                if (!findId(userId)){
                    System.out.println("ID not found");
                }
            } else {
                double extraTransactionBill = 3.4;
                for (int i = 0; i < Main.bankUsers.size(); i++) {
                    if (Main.bankUsers.get(i).getUserId() == userId) {
                        double number = Main.bankUsers.get(i).getMoneyAmount() + moneyAmount;
                        Main.bankUsers.get(i).setMoneyAmount(number);
                        this.user.setMoneyAmount(amount - moneyAmount - extraTransactionBill);
                        amount -= moneyAmount;
                        System.out.println("A " + moneyAmount + " transfer was made from your balance (3.4 Fee taken)");
                        Transaction transaction = new Transaction("Transfer + extra 3.4 Fee - " + moneyAmount + " to - " + Main.bankUsers.get(i).toString());
                        this.user.transactionList.add(transaction);
                    }

                }
                if (!findId(userId)){
                    System.out.println("ID not found");
                }

            }
        }else {
            System.out.println("You dont have enought money to transfer!");
        }
    }
    public void takeLoan(double loanAmount,int returnMonths){

        double interestAmount;
        if (returnMonths <= 5){
            double convetedValue = 5.0 / 100;
            double Y = convetedValue * loanAmount;
            System.out.println("Your interest rate is 5% for 5 or less months return.");
            System.out.println("Total interest amount to return: "+Y+" - Total: "+(loanAmount+Y));
        }else if (returnMonths <= 10){
            double convetedValue = 8.0 / 100;
            double Y = convetedValue * loanAmount;
            System.out.println("Your interest rate is 8% for 6 to 10 or  months return.");
            System.out.println("Total interest amount to return: "+Y+" - Total: "+(loanAmount+Y));
        }else {
            double convetedValue = 20.0 / 100;
            double Y = convetedValue * loanAmount;
            System.out.println("Your interest rate is 20% for 11 or more months return.");
            System.out.println("Total interest amount to return: "+Y+" - Total: "+(loanAmount+Y));
        }


    }
}