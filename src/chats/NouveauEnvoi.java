/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chats;

import beans.Message;
import beans.Utilisateur;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MessageService;
import service.UtilisateurService;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
class NouveauEnvoi extends Thread {

    Socket sc;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    ServeurEnvoi serveurEnvoi;

    public NouveauEnvoi(Socket sc, ServeurEnvoi serveurEnvoi) throws IOException {
        this.sc = sc;
        oos = new ObjectOutputStream(sc.getOutputStream());
        ois = new ObjectInputStream(sc.getInputStream());
        this.serveurEnvoi = serveurEnvoi;
        this.start();
    }

    @Override
    public void run() {
        try {
            Utilisateur utilisateur = (Utilisateur) ois.readObject();
            while (true) {
                    UtilisateurService us = new UtilisateurService();
                    MessageService ms = new MessageService();
                    List<Message> messages = ms.loadNonLu(utilisateur);

                    Vector<Message> msgs = new Vector<Message>(messages);

                    for (Message m : msgs) {
                        oos.flush();
                        oos.writeObject(m);
                        m.setLu(true);
                        ms.update(m);
                    }
                    
                    sleep(2000);

            }
        } catch (Exception ex) {
        }

    }
}
