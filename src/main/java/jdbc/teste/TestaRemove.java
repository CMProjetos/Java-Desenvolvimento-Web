package jdbc.teste;

import jdbc.dao.ContatoDao;
import jdbc.modelo.Contato;

/**
 * Created by Carlos Eduardo on 03/04/2015.
 */
public class TestaRemove {

    public static void main(String args[]) {
        ContatoDao dao = new ContatoDao();
        Contato contato = new Contato();

        contato.setId((long) 5);

        //Removendo contato com id 5
        dao.remove(contato);
    }

}
