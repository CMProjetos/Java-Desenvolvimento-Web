package jdbc.dao;

import jdbc.modelo.ConnectionFactory;
import jdbc.modelo.Contato;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Carlos Eduardo on 29/03/2015.
 */
public class ContatoDao {

    private Connection connection;
    //Cria um preapredStatement
    String sql = "insert into contatos" +
            " (nome,email,endereco,dataNascimento)" +
            " values (?,?,?,?)";

    public ContatoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Contato contato) {
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            //Preenche os valores
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

            //Executa
            stmt.execute();

            //Fecha a conexão
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
