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
        contato.setNome("Antonio Filho");
        contato.setEmail("antoniofilho@sagaranatech.com");
        contato.setEndereco("Ruan General Sampaio, Marina Park Hotel, Quarto 502");
        contato.setDataNascimento(Calendar.getInstance());

        //Iniciando conex�o pelo construtor
        ContatoDao dao = new ContatoDao();

        //Adicionando dados no banco
        dao.adiciona(contato);
        System.out.println("Gravado!");

    }

}
