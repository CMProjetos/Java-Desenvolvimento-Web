package teste;

import jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Carlos Eduardo on 28/03/2015.
 */
public class JDBCExemplo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Class.forName("com.mysql.jdbc.Driver"); //Pode ser utilizado para achar o Driver do MySQL
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //Pode ser utilizado para achar o Driver do MySQL
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection conexao = connectionFactory.getConnection();
        System.out.println("Conectado!");
        conexao.close();
    }
}
