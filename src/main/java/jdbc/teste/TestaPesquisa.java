package jdbc.teste;

import jdbc.dao.ContatoDao;
import jdbc.modelo.Contato;

import java.text.SimpleDateFormat;

/**
 * Created by Carlos Eduardo on 03/04/2015.
 */
public class TestaPesquisa {

    public static void main(String args[]) {
        //int x = 2;
        //String y = "teste %f",(x);
        ContatoDao dao = new ContatoDao();
        Contato contato = dao.pesquisar(1);

        System.out.println("Nome: " + contato.getNome());
        System.out.println("Email: " + contato.getEmail());
        System.out.println("Endereco: " + contato.getEndereco());
        System.out.println("Data de Nascimento: " + new SimpleDateFormat().format(contato.getDataNascimento().getTime()));

    }

}
