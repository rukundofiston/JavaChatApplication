/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatc;

import Objets.AddressesPorts;
import beans.Message;
import beans.Utilisateur;
import com.sun.corba.se.impl.io.InputStreamHook;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class ThreadReception extends Thread {

    FChat fchat;
    Socket sc;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    Utilisateur u;
    boolean exit=true;

    public ThreadReception(FChat fchat, Utilisateur u) throws UnknownHostException, IOException {
        this.fchat = fchat;
        this.u = u;
        sc = new Socket(AddressesPorts.IpServeur, AddressesPorts.portServeurEnvoi);
        this.ois = new ObjectInputStream(sc.getInputStream());
        this.oos = new ObjectOutputStream(sc.getOutputStream());


        this.start();

    }
    
    public void exit(){
        exit=false;
    }

    @Override
    public void run() {
        try {
            oos.writeObject(u);
            while (exit) {
                try {
                    Message msg = (Message) ois.readObject();
                    if(!fchat.isVisible())
                        fchat.setVisible(true);
                    fchat.afficherMessage(msg);
                } catch (IOException ex) {
                    Logger.getLogger(ThreadReception.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ThreadReception.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            sc.close();
        } catch (IOException ex) {
        }

    }
}
