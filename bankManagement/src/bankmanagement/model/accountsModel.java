package bankmanagement.model;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;
import bankmanagement.dbhelper.ConnectionGenerator;
import java.util.Locale;
import java.util.ResourceBundle;

//extends clientsModel 
public class accountsModel {

    private int AccountNumber;
    private String AccountType;
    private Date OpenDate;
    int Balance; //need it for transfer
    private boolean isActive;
    private int ClientId;

    public accountsModel() {
    }

    public accountsModel(ResultSet rs) {
        try {
            this.AccountNumber = rs.getInt("AccountNumber");
            this.AccountType = rs.getString("AccountType");
            this.OpenDate = rs.getDate("OpenDate");
            this.Balance = rs.getInt("Balance");
            this.isActive = rs.getBoolean("isActive");
        } catch (SQLException e) {
            System.out.println("Error creating clients model [" + e.getMessage() + "]");
        }
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String AccountType) {
        this.AccountType = AccountType;
    }

    public Date getOpenDate() {
        return OpenDate;
    }

    public void setOpenDate(Date OpenDate) {
        this.OpenDate = OpenDate;
    }

    public int getBalance(int AccountNumber) {
        try {
            ConnectionGenerator con = new ConnectionGenerator();
            con.getConnection();
            Statement Stmt = con.getConnection().createStatement();
            String SQL_Command = "SELECT Balance FROM Accounts WHERE AccountNumber ='"
                    + AccountNumber + "'"; // SQL query command for Balance  
            ResultSet Rslt = Stmt.executeQuery(SQL_Command);

            while (Rslt.next()) {
                Balance = Rslt.getInt(1);
            }
            Stmt.close();
            con.getConnection().close();
        } catch (java.sql.SQLException e) {
            System.out.println("SQLException: " + e);
            while (e != null) {
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("Message: " + e.getMessage());
                System.out.println("Error: " + e.getErrorCode());
                e = e.getNextException();
                System.out.println("");
            }
        } catch (java.lang.Exception e) {
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }
        return Balance;
    }

    public void setBalance(int Balance) {
        this.Balance = Balance;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int ClientId) {
        this.ClientId = ClientId;
    }

    public void displayAllAccounts() {
        try {
            ConnectionGenerator con = new ConnectionGenerator();
            con.getConnection();
            Statement Stmt = con.getConnection().createStatement();
            String query = "SELECT AccountNumber FROM Accounts;";
            ResultSet Rslt = Stmt.executeQuery(query);

            while (Rslt.next()) {
                int id = Rslt.getInt("AccountNumber");
                System.out.println(id);
            }
            Stmt.close();
        } catch (SQLException e) {
            System.out.println("Error Executing Statement [" + e + "]");
        }
    }

    // convert local date to date
    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    public void createAccount(Connection con) {
        Locale currentLocale;
        ResourceBundle messages;
        //currentLocale = new Locale("fr", "FR");
        currentLocale = new Locale("en", "EN");
        messages = ResourceBundle.getBundle("bankmanagement.I18NProperties.MessagesBundle", currentLocale);

        try {
            Scanner scanner = new Scanner(System.in);
            //System.out.print("Enter your client id: ");
            System.out.println(messages.getString("EnterClientIdForAccount"));
            int cId = scanner.nextInt();
            verifyClientId(cId);
            ClientId = cId;
            //System.out.print("Enter your account number: ");
            System.out.println(messages.getString("EnterAccountNumber"));
            AccountNumber = scanner.nextInt();
            //System.out.print("Enter your account type (saving/checking/investment): ");
            System.out.println(messages.getString("EnterAccountType"));
            AccountType = scanner.next();
            if (!AccountType.equalsIgnoreCase("saving") && !AccountType.equalsIgnoreCase("checking") && !AccountType.equalsIgnoreCase("investment")) {
                //System.out.println("Invalid Account Type!");
                System.out.println(messages.getString("AccountTypeInvalid"));
                return;
            }
            LocalDate date = LocalDate.now(); // Gets the current date
            OpenDate = convertToDateViaSqlDate(date);
            //System.out.print("Enter your balance: ");
            System.out.println(messages.getString("EnterBalance"));
            Balance = scanner.nextInt();
            if (Balance < 0) {
                //System.out.println("Balance can't be negative!");
                System.out.println(messages.getString("NegativeBalance"));
                return;
            }
            isActive = true;

            String sql = "INSERT INTO Accounts (AccountNumber, AccountType, OpenDate, Balance, isActive, ClientId) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            // set param values
            stmt.setInt(1, AccountNumber);
            stmt.setString(2, AccountType);
            stmt.setDate(3, OpenDate);
            stmt.setInt(4, Balance);
            stmt.setBoolean(5, isActive);
            stmt.setInt(6, ClientId);
            stmt.executeUpdate();
            //System.out.println("New Account Created Successfully!");
            System.out.println(messages.getString("SuccessfulAccountCreation"));

        } catch (SQLException e) {
            // System.out.println("Error Executing Statement [" + e + "]");
            System.out.println(messages.getString("SQLException"));
            System.out.print(e);
            try {
                con.rollback();
            } catch (SQLException e1) {
                //System.out.println("Error rollingback [" + e1 + "]");
                System.out.println(messages.getString("SQLExceptionRollback"));
                System.out.print(e);
            }
        }
    }

    public void viewAccountsTable() {
        String query = "SELECT AccountNumber, AccountType, OpenDate, Balance, isActive FROM Accounts";
        ConnectionGenerator con = new ConnectionGenerator();
        con.getConnection();
        try ( Statement stmt = con.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int accN = rs.getInt("AccountNumber");
                String accT = rs.getString("AccountType");
                Date od = rs.getDate("OpenDate");
                int bal = rs.getInt("Balance");
                boolean act = rs.getBoolean("isActive");
                System.out.println("Account Number: " + accN + ",  Account Type: " + accT + ",  OpenDate: " + od + ",  Balance: " + bal + ",  isActive: " + act);
            }
        } catch (SQLException e) {
            System.out.println("Error Executing Statement [" + e + "]");
        }
    }

    public void deactivateAccount() {
        Locale currentLocale;
        ResourceBundle messages;
        //currentLocale = new Locale("fr", "FR");
        currentLocale = new Locale("en", "EN");
        messages = ResourceBundle.getBundle("bankmanagement.I18NProperties.MessagesBundle", currentLocale);

        try {
            ConnectionGenerator con = new ConnectionGenerator();
            con.getConnection();
            PreparedStatement stm = con.getConnection().prepareStatement("UPDATE Accounts SET IsActive = false WHERE Balance == 0");
            int rowsUpdated = stm.executeUpdate();
            if (rowsUpdated > 0) {
                //System.out.println("Accounts with zero balance has been deactivate!");
                System.out.println(messages.getString("DeactivateAccountsSuccess"));

            }
        } catch (SQLException e) {
            //System.out.println("Error Executing Statement [" + e + "]");
            System.out.println(messages.getString("SQLException"));
            System.out.println(e);
        }
    }

    /* public int userInput() {
        Scanner sc = new Scanner(System.in);
        int damt;
        damt = sc.nextInt();
        if (damt < 0) {
            InvalidBankTransaction depErro = new InvalidBankTransaction("Invalid Deposit Amount");
            System.out.println(depErro.getErro());
            userInput();
        } else {
            return damt;
        }
        return damt;
    }*/
    public int userInput() {
        Locale currentLocale;
        ResourceBundle messages;
        //currentLocale = new Locale("fr", "FR");
        currentLocale = new Locale("en", "EN");
        
        messages = ResourceBundle.getBundle("bankmanagement.I18NProperties.MessagesBundle", currentLocale);
        Scanner sc = new Scanner(System.in);
        int damt;
        damt = sc.nextInt();
        if (damt < 0) {
            System.out.println(messages.getString("UserInputInvalidAmount"));
            System.exit(0);
        } else {
            return damt;
        }
        return damt;
    }

    public void verifyClientId(int cliId) {
        Locale currentLocale;
        ResourceBundle messages;
        //currentLocale = new Locale("fr", "FR");
        currentLocale = new Locale("en", "EN");
        messages = ResourceBundle.getBundle("bankmanagement.I18NProperties.MessagesBundle", currentLocale);

        ConnectionGenerator con = new ConnectionGenerator();
        con.getConnection();
        String query = "SELECT ClientId FROM Clients WHERE ClientId ='" + cliId + "'";
        try ( Statement stmt = con.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                //System.out.println("Success");
                System.out.println(messages.getString("AccountVerifySuccess"));
            } else {
                //System.out.println("Account doesn't exist!");
                System.out.println(messages.getString("AccountVerifyNoClient"));
                System.exit(0);

            }
        } catch (SQLException e) {
            //System.out.println("Error Executing Statement [" + e + "]");
            System.out.println(messages.getString("SQLException"));
            System.out.println(e);
        }
    }

}
