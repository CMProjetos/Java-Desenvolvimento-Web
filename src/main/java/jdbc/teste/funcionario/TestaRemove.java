package jdbc.teste.funcionario;

import jdbc.dao.FuncionarioDao;
import jdbc.modelo.Funcionario;

/**
 * Created by Carlos Eduardo on 03/04/2015.
 */
public class TestaRemove {

    public static void main(String args[]) {
        FuncionarioDao dao = new FuncionarioDao();
        Funcionario funcionario = new Funcionario();

        funcionario.setId(3);
        dao.remove(funcionario);
    }

}
