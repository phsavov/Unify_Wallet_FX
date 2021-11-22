package Unify;

public class Transactions {

    private String fromAccountID;
    private String amount;
    private String toAccountID;

    public Transactions(String fromAccountID, String amount, String toAccountID){
        this.fromAccountID = fromAccountID;
        this.amount = amount;
        this.toAccountID = toAccountID;
    }

    public String getFromAccountID() {
        return fromAccountID;
    }

    public String getAmount() {
        return amount;
    }

    public String getToAccountID() {
        return toAccountID;
    }
}
