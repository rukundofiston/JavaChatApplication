/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chats;

import beans.Message;
import beans.Utilisateur;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MessageService;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class NouvelleDeconnexion extends Thread{

    Socket sc;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    ServeurDeconnexion serveurDeconnexion;
    
    NouvelleDeconnexion(Socket sc, ServeurDeconnexion serveurDeconnexion) throws IOException {
        this.sc = sc;
        oos = new ObjectOutputStream(sc.getOutputStream());
        ois = new ObjectInputStream(sc.getInputStream());
        this.serveurDeconnexion = serveurDeconnexion;
        this.start();
    }

    @Override
    public void run() {
            try {

                Utilisateur u = (Utilisateur) ois.readObject();
                serveurDeconnexion.deconnecter(u);

            } catch (Exception ex) {
                Logger.getLogger(NovelleNotification.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    
}
