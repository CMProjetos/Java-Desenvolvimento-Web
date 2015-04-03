package jdbc.teste.funcionario;

import jdbc.dao.FuncionarioDao;
import jdbc.modelo.Funcionario;

/**
 * Created by Carlos Eduardo on 03/04/2015.
 */
public class TestaPesquisa {

    public static void main(String args[]) {
        FuncionarioDao dao = new FuncionarioDao();
        Funcionario funcionario = dao.pesquisa(1);

        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Usuario: " + funcionario.getUsuario());
        System.out.println("Senha: " + funcionario.getSenha());
    }
}
