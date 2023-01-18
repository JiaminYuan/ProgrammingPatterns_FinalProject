package bankmanagement.view;

import java.util.Scanner;
import java.sql.*;
import bankmanagement.dbhelper.ConnectionGenerator;
import java.util.Locale;
import java.util.ResourceBundle;

public class Login {
    private String Username, Password;
    boolean flag;

    public Login() {
    }

    public Login(String user, String pass) {
        user = this.Username;
        pass = this.Password;
    }

    public boolean verify() throws Exception {
        Locale currentLocale;
        ResourceBundle messages;
        //currentLocale = new Locale("fr", "FR");
        currentLocale = new Locale("en", "EN");
        messages = ResourceBundle.getBundle("bankmanagement.I18NProperties.MessagesBundle", currentLocale);
        
        ConnectionGenerator con = new ConnectionGenerator();
        con.getConnection();
        //signIn(con.getConnection());
        String query = "SELECT Username, Password FROM Login WHERE Username = 1234 AND Password = 9999";
        try ( Statement stmt = con.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String user = rs.getString("Username");
                String pass = rs.getString("Password");
                //System.out.println(user + ", " + pass + ", ");
                Scanner scanner = new Scanner(System.in);
                System.out.println("");
                //System.out.println("******* Welcome to Bank Account Management System *******");
                System.out.println(messages.getString("LoginWelcome"));
                //System.out.println("*********************************************************");
                System.out.println(messages.getString("Banner"));
                //System.out.print("Enter User: ");
                System.out.println(messages.getString("User"));
                String scUsername = scanner.next();
                //System.out.print("Enter Password: ");
                System.out.println(messages.getString("Password"));
                String scPassword = scanner.next();
                if (scUsername.equals(user) && scPassword.equals(pass)) {
                    flag = true;
                    //System.out.println("Login successful!");
                    System.out.println(messages.getString("SuccessLogin"));
                    return flag;
                } else {
                    //System.out.println("Failed to Login, please reenter!");
                    System.out.println(messages.getString("FailLogin"));
                    return false;
                }
            }
        } catch (SQLException e) {
            //System.out.println("Error Executing Statement [" + e + "]");
            System.out.println(messages.getString("SQLException"));
            System.out.print(e);
        }
        return true;
    }
    
    
}
