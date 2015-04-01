package jdbc.teste;

import jdbc.dao.ContatoDao;
import jdbc.modelo.Contato;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by carlos on 31/03/15.
 */
public class TestaLista {

    public static void main(String[] args) {

        ContatoDao dao = new ContatoDao();
        List<Contato> contatos = dao.getLista();

        for (Contato contato : contatos) {
            System.out.println("Nome: " + contato.getNome());
            System.out.println("Email: " + contato.getEmail());
            System.out.println("Endereço: " + contato.getEndereco());
            System.out.println("Data de Nascimento: " + new SimpleDateFormat().format(contato.getDataNascimento().getTime()) + "\n");
        }

    }

}
