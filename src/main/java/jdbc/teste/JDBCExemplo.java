package jdbc.teste;

import jdbc.dao.conexao.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * Created by Carlos Eduardo on 28/03/2015.
 */
public class JDBCExemplo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Class.forName("com.mysql.jdbc.Driver"); //Pode ser utilizado para achar o Driver do MySQL
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //Pode ser utilizado para achar o Driver do MySQL
        Connection conexao = null;

        //Conectando
        try {
            conexao = new ConnectionFactory().getConnection();
            System.out.println("Conectado!");

            //Cria um preapredStatement
            String sql = "insert into contatos" +
                    " (nome,email,endereco,dataNascimento)" +
                    " values (?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);

            //Preenche os valores
            stmt.setString(1, "Carlos");
            stmt.setString(2, "carlosmito2013@gmail.com");
            stmt.setString(3, "Bloco 80, Rua NW 9, Araturi, Caucaia");
            stmt.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));

            //Executa
            stmt.execute();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            conexao.close();
        }
    }
}
