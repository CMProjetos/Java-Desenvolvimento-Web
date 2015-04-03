package jdbc.teste.contato;

import jdbc.dao.ContatoDao;
import jdbc.modelo.Contato;

import java.util.Calendar;

/**
 * Created by Carlos Eduardo on 29/03/2015.
 */
public class TestaInsere {

    public static void main(String[] args) {
        Contato contato = new Contato();
        contato.setNome("Isaac");
        contato.setEmail("isaac@sagaranatech.com");
        contato.setEndereco("Av. Engenheiro Luiz Vieira, 920, Sala 111");
        contato.setDataNascimento(Calendar.getInstance());

        //Iniciando conex�o pelo construtor
        ContatoDao dao = new ContatoDao();

        //Adicionando dados no banco
        dao.adiciona(contato);
        System.out.println("Gravado!");

    }

}
