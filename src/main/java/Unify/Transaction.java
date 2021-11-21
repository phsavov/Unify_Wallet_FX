package Unify;
import java.security.PublicKey;
import java.sql.SQLException;
import java.util.ArrayList;

public class Transaction {


    public String    transactionID; //transaction hash
    public PublicKey recipient; //address for recipient
    public PublicKey sender; //address for sender
    public float     val;
    public byte[]    signature; //restricts access to only the user
    
    private TransactionDatabase transaction;

    //How many transactions have been created
    private static int transactionCount = 0;
    
    

    // Constructor that creates a new instance of the transaction database
    public Transaction() throws SQLException {
        transaction = new TransactionDatabase();
    }

    /**
     * Query the database and ...
     * @param from: User
     * @param toAddress: String
     * @param amount: double
     * @return boolean
     * @throws SQLException
     */
    public boolean processSendingTransaction(User from, String toAddress, double amount) throws SQLException {
        if (transaction.sendingCrypto(amount, toAddress, from)){
            return true;
        }
        return false;
    }

    public ArrayList<String> getHistory(User user) throws SQLException {
        return transaction.history(user);
    }

}
