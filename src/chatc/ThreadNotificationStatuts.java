/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatc;

import Objets.AddressesPorts;
import Objets.listeAmis;
import beans.Utilisateur;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class ThreadNotificationStatuts extends Thread{
    
    private FLisetAmis fLisetAmis;
    Socket sc;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    Utilisateur utilisateur;

    public ThreadNotificationStatuts(FLisetAmis fLisetAmis,Utilisateur u) throws UnknownHostException, IOException {
        this.fLisetAmis=fLisetAmis;
        utilisateur=u;
        this.start();
    }

    @Override
    public void run() {
            
        while(true){
            try {
                
                try {
                    sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadNotificationStatuts.class.getName()).log(Level.SEVERE, null, ex);
                }
                sc=new Socket(AddressesPorts.IpServeur,AddressesPorts.portServeurNotification);
                oos=new ObjectOutputStream(sc.getOutputStream());
                ois=new ObjectInputStream(sc.getInputStream());
                oos.writeObject(utilisateur);
                listeAmis amis=(listeAmis) ois.readObject();
                fLisetAmis.setListeAmis(amis);
                
            } catch (IOException ex) {
                Logger.getLogger(ThreadNotificationStatuts.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThreadNotificationStatuts.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    
    
    
    
}
