package jdbc.teste;

import jdbc.dao.ContatoDao;
import jdbc.modelo.Contato;

import java.util.Calendar;

/**
 * Created by Carlos Eduardo on 29/03/2015.
 */
public class TestaInsere {

    public static void main(String[] args) {
        Contato contato = new Contato();
        contato.setNome("Carlos");
        contato.setEmail("carloseduardo@sagaranatech.com");
        contato.setEndereco("Rua IV, Casa 279");
        contato.setDataNascimento(Calendar.getInstance());

        //Iniciando conexão pelo construtor
        ContatoDao dao = new ContatoDao();

        //Adicionando dados no banco
        dao.adiciona(contato);
        System.out.println("Gravado!");

    }

}
