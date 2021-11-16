package BankManagementSoftware;

public class Transaction {

    private String transactionName;

    public Transaction(String transactionName){
        this.transactionName = transactionName;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }
    public String toString(){
        return transactionName;
    }
}
