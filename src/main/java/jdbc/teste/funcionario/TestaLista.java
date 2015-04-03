package jdbc.teste.funcionario;

import jdbc.dao.FuncionarioDao;
import jdbc.modelo.Funcionario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos Eduardo on 03/04/2015.
 */
public class TestaLista {

    public static void main(String args[]) {
        FuncionarioDao dao = new FuncionarioDao();
        List<Funcionario> funcionarios = dao.getFuncionarios();

        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Usuario: " + funcionario.getUsuario());
            System.out.println("Senha: " + funcionario.getSenha() + "\n");
        }
    }

}
