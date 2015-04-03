package jdbc.teste;

import jdbc.dao.ContatoDao;
import jdbc.modelo.Contato;

import java.util.Calendar;

/**
 * Created by Carlos Eduardo on 03/04/2015.
 */
public class TestaAltera {

    public static void main(String args[]) {
        ContatoDao dao = new ContatoDao();

        Contato contato = new Contato();
        contato.setNome("Bruno");
        contato.setEmail("calango@gmail.com");
        contato.setEndereco("Rua NW 8, Araturi, Caucaia");
        contato.setDataNascimento(Calendar.getInstance());
        contato.setId((long) 2);

        dao.altera(contato);
    }

}
