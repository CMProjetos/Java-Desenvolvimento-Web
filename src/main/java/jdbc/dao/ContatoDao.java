package jdbc.dao;

import jdbc.dao.conexao.ConnectionFactory;
import jdbc.exceptions.DAOException;
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

    public ContatoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Contato contato) {
        try {
            //Cria um preapredStatement
            String sql = "insert into contatos" +
                    " (nome,email,endereco,dataNascimento)" +
                    " values (?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);

            //Preenche os valores
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

            //Executa
            stmt.execute();

            //Fechando todas as conexões para liberar portas utilizadas
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    public List<Contato> getLista() {
        try {
            List<Contato> contatos = new ArrayList<Contato>();
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM contatos WHERE nome LIKE 'C%'");
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

            //Fechando todas as conexões para liberar portas utilizadas
            rs.close();
            stmt.close();
            connection.close();

            return contatos;

        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    public Contato pesquisar(Integer id) {
        try {
            Contato contato = new Contato();
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM contatos WHERE id LIKE 'posicao'".replace("posicao", id.toString()));
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                //Pegando dados da tabela contato no banco
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));

                //Montando a data através do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);
            }

            //Fechando todas as conexões para liberar portas utilizadas
            rs.close();
            stmt.close();
            connection.close();

            return contato;
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    public void altera (Contato contato) {
        try {
            String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
            stmt.setLong(5, contato.getId());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    public void remove(Contato contato) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?");
            stmt.setLong(1, contato.getId());

            stmt.execute();

            stmt.close();
            connection.close();
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

}
