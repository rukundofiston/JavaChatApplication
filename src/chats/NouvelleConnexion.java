/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chats;

import Objets.LoginPasswordSatut;
import Objets.listeAmis;
import com.sun.corba.se.pept.encoding.InputObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.UtilisateurService;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class NouvelleConnexion extends Thread {

    Socket sc;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    ServeurConnexion serveurConnexion;

    public NouvelleConnexion(Socket sc, ServeurConnexion serveurChat) throws IOException {
        this.sc = sc;
        oos = new ObjectOutputStream(sc.getOutputStream());
        ois = new ObjectInputStream(sc.getInputStream());
        this.serveurConnexion = serveurChat;
        this.start();
    }

    @Override
    public void run() {
        try {
            LoginPasswordSatut lp = (LoginPasswordSatut) ois.readObject();
            System.out.println(lp.getLogin() + "/" + lp.getPassword() + "/" + lp.getStatut());

            boolean b = serveurConnexion.authentifier(lp);
            System.out.println(b);

            if (b) {
                listeAmis amis = new listeAmis(serveurConnexion.getAmisDe(lp.getLogin()));
                oos.writeObject(amis);
                oos.flush();
                System.out.println(amis);
                serveurConnexion.changerStatutUtilisateur(lp, sc, oos, ois);

            } else {
                oos.writeObject(new String("Mot de passe ou login invalide."));
                System.out.println("Mot de passe ou login invalide");
            }

        } catch (Exception ex) {
        }

    }
    

}
