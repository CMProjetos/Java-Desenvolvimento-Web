package jdbc.teste.funcionario;

import jdbc.dao.FuncionarioDao;
import jdbc.modelo.Funcionario;

/**
 * Created by Carlos Eduardo on 03/04/2015.
 */
public class TestaInsere {

    public static void main(String args[]) {
        FuncionarioDao dao = new FuncionarioDao();
        Funcionario funcionario = new Funcionario();

        funcionario.setNome("Antonio Filho");
        funcionario.setUsuario("antonio.filho");
        funcionario.setSenha("xxxxxxx");

        dao.adicionar(funcionario);
        System.out.println("Gravado!");
    }
}
