package jdbc.dao;

import jdbc.dao.conexao.ConnectionFactory;
import jdbc.exceptions.DAOException;
import jdbc.modelo.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos Eduardo on 03/04/2015.
 */
public class FuncionarioDao {

    private Connection connection;

    public FuncionarioDao() {
        connection = new ConnectionFactory().getConnection();
    }

    public void adicionar(Funcionario funcionario) {

        try {
            //Comando SQL para inserir dados na tabela funcionarios
            String sql = "insert into funcionarios" +
                    " (nome, usuario, senha)" +
                    " values (?,?,?)";

            //Classe responsável por receber comandos SQL,
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getUsuario());
            stmt.setString(3, funcionario.getSenha());

            stmt.execute();

            stmt.close();
            connection.close();
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    public List<Funcionario> getFuncionarios() {
        try {
            List<Funcionario> funcionarios = new ArrayList<Funcionario>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM funcionarios");

            //Método executeQuery executa um comando SQL e retorna um ResultSet
            ResultSet rs = stmt.executeQuery();

            //Método next ler todas as linhas resultantes do comando SQL
            while(rs.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setNome(rs.getString("nome"));
                funcionario.setUsuario(rs.getString("usuario"));
                funcionario.setSenha(rs.getString("senha"));

                funcionarios.add(funcionario);
            }

            //Fechando conexões para liberar portas utilizadas
            rs.close();
            stmt.close();
            connection.close();

            return funcionarios;
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    public Funcionario pesquisa(Integer id) {
        try {
            Funcionario funcionario = new Funcionario();
            PreparedStatement stmt = connection.prepareStatement
                    (("SELECT * FROM funcionarios WHERE id LIKE 'posicao'").replace("posicao", id.toString()));
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                funcionario.setNome(rs.getString("nome"));
                funcionario.setUsuario(rs.getString("usuario"));
                funcionario.setSenha(rs.getString("senha"));
            }

            rs.close();
            stmt.close();
            connection.close();

            return funcionario;

        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    public void altera(Funcionario funcionario) {
        try {
            PreparedStatement stmt = connection.prepareStatement("update funcionarios set nome=?, usuario=?, senha=? where id=?");

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getUsuario());
            stmt.setString(3, funcionario.getSenha());
            stmt.setLong(4, funcionario.getId());

            stmt.execute();

            stmt.close();
            connection.close();
        } catch (SQLException e) {
            throw new DAOException();
        }
    }

    public void remove(Funcionario funcionario) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete FROM funcionarios WHERE id=?");

            stmt.setLong(1, funcionario.getId());

            stmt.execute();

            stmt.close();
            connection.close();

        } catch (SQLException e) {
            throw new DAOException();
        }
    }
}
