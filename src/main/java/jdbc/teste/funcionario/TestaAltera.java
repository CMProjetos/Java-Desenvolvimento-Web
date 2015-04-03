package jdbc.teste.funcionario;

import jdbc.dao.FuncionarioDao;
import jdbc.modelo.Funcionario;

/**
 * Created by Carlos Eduardo on 03/04/2015.
 */
public class TestaAltera {

    public static void main(String args[]) {

        FuncionarioDao dao = new FuncionarioDao();
        Funcionario funcionario = new Funcionario();

        funcionario.setNome("Carlos Eduardo");
        funcionario.setUsuario("carlos.eduardo");
        funcionario.setSenha("xxxxxxx");
        funcionario.setId(1);

        dao.altera(funcionario);
    }
}
