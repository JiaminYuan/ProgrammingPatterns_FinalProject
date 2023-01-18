
package bankmanagement.dbhelper;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionGenerator {

    private Connection con;

    public Connection getConnection() {
        if (con == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                //con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ea_Em\\Documents\\NetBeansProjects\\bankManagement\\bankManagement.db");
                con = DriverManager.getConnection("jdbc:sqlite:bankManagement.db");
            } catch (ClassNotFoundException e) {
                System.out.println("SQL Driver not found [" + e + "]");
            } catch (SQLException e) {
                System.out.println("SQL Exception [" + e + "]");
            }
        }
        return con;
    }

}
