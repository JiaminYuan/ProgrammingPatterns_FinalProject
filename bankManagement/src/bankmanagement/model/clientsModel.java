package bankmanagement.model;

import bankmanagement.dbhelper.ConnectionGenerator;
import java.sql.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class clientsModel {

    private int ClientId;
    private String FirstName;
    private String LastName;
    private String Identification;
    private String Address;

    public clientsModel() {
    }

    public clientsModel(ResultSet rs) {
        try {
            this.ClientId = rs.getInt("ClientId");
            this.FirstName = rs.getString("FirstName");
            this.LastName = rs.getString("LastName");
            this.Identification = rs.getString("Identification");
            this.Address = rs.getString("Address");

        } catch (SQLException e) {
            Locale currentLocale;
            ResourceBundle messages;
            //currentLocale = new Locale("fr", "FR");
            currentLocale = new Locale("en", "EN");
            messages = ResourceBundle.getBundle("bankmanagement.I18NProperties.MessagesBundle", currentLocale);

            //System.out.println("Error creating clients model [" + e.getMessage() + "]");
            System.out.println(messages.getString("SQLExceptionClientCreation"));
            System.out.println(e.getMessage());
        }
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int ClientId) {
        this.ClientId = ClientId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getIdentification() {
        return Identification;
    }

    public void setIdentification(String Identification) {
        this.Identification = Identification;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void displayAllClients() {
        try {
            ConnectionGenerator con = new ConnectionGenerator();
            con.getConnection();
            Statement Stmt = con.getConnection().createStatement();
            String query = "SELECT ClientId FROM Clients;";
            ResultSet Rslt = Stmt.executeQuery(query);

            while (Rslt.next()) {
                int id = Rslt.getInt("ClientId");
                System.out.println(id);
            }
            Stmt.close();
        } catch (SQLException e) {
            System.out.println("Error Executing Statement [" + e + "]");
        }
    }

    public void createClient(Connection con) {
        Locale currentLocale;
        ResourceBundle messages;
        //currentLocale = new Locale("fr", "FR");
        currentLocale = new Locale("en", "EN");
        messages = ResourceBundle.getBundle("bankmanagement.I18NProperties.MessagesBundle", currentLocale);

        try {
            Scanner scanner = new Scanner(System.in);
            //System.out.print("Enter your Id: ");
            System.out.println(messages.getString("EnterClientId"));
            ClientId = scanner.nextInt();
            //System.out.print("Enter your first name: ");
            System.out.println(messages.getString("EnterFName"));
            FirstName = scanner.next();
            //System.out.print("Enter your last name: ");
            System.out.println(messages.getString("EnterLName"));
            LastName = scanner.next();
            //System.out.print("Enter your identification: ");
            System.out.println(messages.getString("EnterIden"));
            Identification = scanner.next();
            //System.out.print("Enter your address: ");
            System.out.println(messages.getString("EnterAddress"));
            Address = scanner.next();

            String sql = "INSERT INTO Clients (ClientId, FirstName, LastName, Identification, Address) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            // set param values
            stmt.setInt(1, ClientId);
            stmt.setString(2, FirstName);
            stmt.setString(3, LastName);
            stmt.setString(4, Identification);
            stmt.setString(5, Address);

            stmt.executeUpdate();
            //System.out.println("New Client Created Successfully!");
            System.out.println(messages.getString("SuccessfulClientCreation"));

        } catch (SQLException e) {
            //System.out.println("Error Executing Statement [" + e + "]");
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

    public void updateClientInfo(String fname, String lname, String identification, String address, int clientId) {
        Locale currentLocale;
        ResourceBundle messages;
        //currentLocale = new Locale("fr", "FR");
        currentLocale = new Locale("en", "EN");
        messages = ResourceBundle.getBundle("bankmanagement.I18NProperties.MessagesBundle", currentLocale);

        try {
            ConnectionGenerator con = new ConnectionGenerator();
            con.getConnection();
            PreparedStatement stm = con.getConnection().prepareStatement("UPDATE Clients SET FirstName = ?, LastName = ?, Identification = ?, Address = ? WHERE ClientId = ?");
            stm.setString(1, fname);
            stm.setString(2, lname);
            stm.setString(3, identification);
            stm.setString(4, address);
            stm.setInt(5, clientId);
            stm.executeUpdate();
            //System.out.println("Client info updated Successfully!");
            System.out.println(messages.getString("ClientInfoSuccess"));
        } catch (SQLException e) {
            //System.out.println("Error Executing Statement [" + e + "]");
            System.out.println(messages.getString("SQLException"));
            System.out.print(e);
        }

    }

}
