package jdbc.modelo;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Carlos Eduardo on 29/03/2015.
 */
public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "7139");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
