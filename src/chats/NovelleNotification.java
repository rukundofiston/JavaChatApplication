/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chats;

import Objets.LoginPasswordSatut;
import Objets.listeAmis;
import beans.Utilisateur;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class NovelleNotification extends Thread {

    Socket sc;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    ServeurNotificationStatut serveurNotificationStatut;

    public NovelleNotification(Socket sc, ServeurNotificationStatut serveurNotificationStatut) throws IOException {
        this.sc = sc;
        oos = new ObjectOutputStream(sc.getOutputStream());
        ois = new ObjectInputStream(sc.getInputStream());
        this.serveurNotificationStatut = serveurNotificationStatut;
        this.start();
    }

    @Override
    public void run() {

            try {

                Utilisateur u = (Utilisateur) ois.readObject();
                listeAmis amis = new listeAmis(serveurNotificationStatut.serveurConnexion.getAmisDe(u.getLogin()));
                oos.writeObject(amis);

            } catch (Exception ex) {
                Logger.getLogger(NovelleNotification.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(NovelleNotification.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
