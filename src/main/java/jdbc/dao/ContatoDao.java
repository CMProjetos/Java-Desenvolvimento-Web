package jdbc.dao;

import jdbc.modelo.ConnectionFactory;
import jdbc.modelo.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

            //Fecha a conex�o
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Contato> getLista() {
        try {

            List<Contato> contatos = new ArrayList<Contato>();
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM contatos");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                //Criando objeto contato
                Contato contato = new Contato();

                //Pegando dados da tabela contato no banco
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));

                //Montando a data através do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);

                //Adicionando o objeto a lista
                contatos.add(contato);
            }

            rs.close();
            stmt.close();
            return contatos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
