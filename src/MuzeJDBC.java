import java.sql.*;


public class MuzeJDBC {
    private static String url = "jdbc:mysql://localhost:3306/muze";    
    private static String driverName = "com.mysql.cj.jdbc.Driver";   
    private static String username = "root";   
    private static String password = "Benzema-09";
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);

            try {
                con = DriverManager.getConnection(url, username, password);
            } 
            
            catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection."); 
            }
        }

        catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }

        return con;
    }
}