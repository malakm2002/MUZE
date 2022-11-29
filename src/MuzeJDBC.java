import java.sql.*;

//create a class called JDBC, everytime we need to establish a connection we create an instance of this class.
public class MuzeJDBC {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/muzedb";
        String user = "root";
    	String password = "Benzema-09";
        String sql = null;
        
		try (Connection connection = DriverManager.getConnection(url, user, password);) {
		}
		catch (SQLException ex) {
	      	throw new RuntimeException("Error executing sql:\n" + sql, ex);
		}
        return null;
    }
}