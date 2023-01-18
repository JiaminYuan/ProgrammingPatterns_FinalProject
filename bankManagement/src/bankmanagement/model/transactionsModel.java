package bankmanagement.model;

import bankmanagement.dbhelper.ConnectionGenerator;
import java.sql.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class transactionsModel {

    private int TransactionId;
    private int ToAccountNumber;
    private int FromAccountNumber;
    private String TransactionDetail;
    private int Value;

    public transactionsModel() {
    }

    public transactionsModel(ResultSet rs) {
        try {
            this.TransactionId = rs.getInt("TransactionId");
            this.ToAccountNumber = rs.getInt("ToAccountNumber");
            this.FromAccountNumber = rs.getInt("FromAccountNumber");
            this.TransactionDetail = rs.getString("TransactionDetail");
            this.Value = rs.getInt("Value");
        } catch (SQLException e) {
            System.out.println("Error creating transactions model [" + e.getMessage() + "]");
        }
    }

    public int getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(int TransactionId) {
        this.TransactionId = TransactionId;
    }

    public int getToAccountNumber() {
        return ToAccountNumber;
    }

    public void setToAccountNumber(int ToAccountNumber) {
        this.ToAccountNumber = ToAccountNumber;
    }

    public int getFromAccountNumber() {
        return FromAccountNumber;
    }

    public void setFromAccountNumber(int FromAccountNumber) {
        this.FromAccountNumber = FromAccountNumber;
    }

    public String getTransactionDetail() {
        return TransactionDetail;
    }

    public void setTransactionDetail(String TransactionDetail) {
        this.TransactionDetail = TransactionDetail;
    }

    public int getValue() {
        return Value;
    }

    public void setValue(int Value) {
        this.Value = Value;
    }

    public void createTransaction(Connection con) {
        Locale currentLocale;
        ResourceBundle messages;
        //currentLocale = new Locale("fr", "FR");
        currentLocale = new Locale("en", "EN");
        messages = ResourceBundle.getBundle("bankmanagement.I18NProperties.MessagesBundle", currentLocale);
        
        try {
            Scanner scanner = new Scanner(System.in);
            //System.out.print("From Account Number: ");
            System.out.println(messages.getString("TransactionFromAccountNumber"));
            int from = scanner.nextInt();
            verifyAccountNum(from);
            FromAccountNumber = from;
            //System.out.print("To Account Number: ");
            System.out.println(messages.getString("TransactionToAccountNumber"));
            int to = scanner.nextInt();
            verifyAccountNum(to);
            ToAccountNumber = to;
            //System.out.print("Enter your transaction id: ");
            System.out.println(messages.getString("TransactionEnterId"));
            TransactionId = scanner.nextInt();
            // System.out.print("Transaction Detail: ");
            System.out.println(messages.getString("TransactionEnterDetail"));
            TransactionDetail = scanner.next();
            //System.out.print("Transaction amount: ");
            System.out.println(messages.getString("TransactionAmount"));
            Value = scanner.nextInt();
            if (Value < 0) {
                //System.out.println("Amount can't be negative");
                System.out.println(messages.getString("NegativeAmount"));
                return;
            }
            String sql = "INSERT INTO Transactions (TransactionId, ToAccountNumber, FromAccountNumber, TransactionDetail, Value) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            // set param values
            stmt.setInt(1, TransactionId);
            stmt.setInt(2, FromAccountNumber);
            stmt.setInt(3, ToAccountNumber);
            stmt.setString(4, TransactionDetail);
            stmt.setInt(5, Value);
            stmt.executeUpdate();
            makeTransaction(from, to, Value);
            //System.out.println("New Transaction Created Successfully!");
            System.out.println(messages.getString("TransactionSuccessfulCreation"));

        } catch (SQLException e) {
            //System.out.println("Error Executing Statement [" + e + "]");
            System.out.println(messages.getString("SQLException"));
            System.out.print(e);
            try {
                con.rollback();
            } catch (SQLException e1) {
                // System.out.println("Error rollingback [" + e1 + "]");
                System.out.println(messages.getString("SQLExceptionRollback"));
                System.out.print(e);
            }
        }
    }

    public void verifyAccountNum(int acc) {
        Locale currentLocale;
        ResourceBundle messages;
        //currentLocale = new Locale("fr", "FR");
        currentLocale = new Locale("en", "EN");
        messages = ResourceBundle.getBundle("bankmanagement.I18NProperties.MessagesBundle", currentLocale);

        ConnectionGenerator con = new ConnectionGenerator();
        con.getConnection();
        String query = "SELECT AccountNumber FROM Accounts WHERE AccountNumber ='" + acc + "'";
        try ( Statement stmt = con.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                //System.out.println("Success");
                System.out.println(messages.getString("TransactionVerifySuccess"));
            } else {
                //System.out.println("Account doesn't exist!");
                System.out.println(messages.getString("TransactionVerifyNoAccount"));
                System.exit(0);

            }
        } catch (SQLException e) {
            //System.out.println("Error Executing Statement [" + e + "]");
            System.out.println(messages.getString("SQLException"));
            System.out.println(e);
        }

    }

    public void makeTransaction(int fromAcc, int toAcc, int amt) {
        accountsModel tran = new accountsModel();
        int toAccNewBal = tran.getBalance(toAcc) + amt;
        int fromAccNewBal = tran.getBalance(fromAcc) - amt;
        deposit(toAccNewBal, toAcc);
        withdraw(fromAccNewBal, fromAcc);
    }

    public void deposit(int newBal, int accNum) {
        Locale currentLocale;
        ResourceBundle messages;
        //currentLocale = new Locale("fr", "FR");
        currentLocale = new Locale("en", "EN");
        messages = ResourceBundle.getBundle("bankmanagement.I18NProperties.MessagesBundle", currentLocale);

        try {
            ConnectionGenerator con = new ConnectionGenerator();
            con.getConnection();
            PreparedStatement stm = con.getConnection().prepareStatement("UPDATE Accounts SET Balance = ? WHERE AccountNumber = ?");
            stm.setInt(1, newBal);
            stm.setInt(2, accNum);
            stm.executeUpdate();
            //System.out.println("Amount deposited Successfully");
            System.out.println(messages.getString("TransactionSuccessfulDeposit"));
            //System.out.println("Total Balance: " + newBal);
            System.out.println(messages.getString("TransactionTotalDepositBalance"));
            System.out.print(newBal);
        } catch (SQLException e) {
            //System.out.println("Error Executing Statement [" + e + "]");
            System.out.println(messages.getString("SQLException"));
            System.out.print(e);
        }

    }

    public void withdraw(int newBal, int accNum) {
        Locale currentLocale;
        ResourceBundle messages;
        //currentLocale = new Locale("fr", "FR");
        currentLocale = new Locale("en", "EN");
        messages = ResourceBundle.getBundle("bankmanagement.I18NProperties.MessagesBundle", currentLocale);

        try {
            ConnectionGenerator con = new ConnectionGenerator();
            con.getConnection();
            PreparedStatement stm = con.getConnection().prepareStatement("UPDATE Accounts SET Balance = ? WHERE AccountNumber = ?");
            stm.setInt(1, newBal);
            stm.setInt(2, accNum);
            stm.executeUpdate();
            //System.out.println("Amount withdrew Successfully");
            System.out.println(messages.getString("TransactionSuccessfulWithdraw"));
            //System.out.println("Total Balance: " + newBal);
            System.out.println(messages.getString("TransactionTotalWithdrawBalance"));
            System.out.print(newBal);
        } catch (SQLException e) {
            //System.out.println("Error Executing Statement [" + e + "]");
            System.out.println(messages.getString("SQLException"));
            System.out.print(e);
        }

    }

}
