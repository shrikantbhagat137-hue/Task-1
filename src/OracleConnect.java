import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnect {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "system";
        String password = "shri@2309";

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Oracle 10g successfully!");
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found, please check ojdbc.jar setup.");
        } catch (SQLException e) {
            System.out.println("Database connection failed, check URL/username/password.");
        }
    }
}
