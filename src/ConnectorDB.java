import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Anton_Shkliarov on 5/7/2015.
 */
public class ConnectorDB {

    public static Connection getConnection() throws SQLException {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
        String url = resourceBundle.getString("db.url");
        String user = resourceBundle.getString("db.user");
        String pass = resourceBundle.getString("db.password");

        return DriverManager.getConnection(url,user,pass);
    }


}
