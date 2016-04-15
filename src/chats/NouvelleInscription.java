/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chats;

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
public class NouvelleInscription extends Thread{
    
    ServeurInscription serveurInscription;
    Socket sc;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    public NouvelleInscription(Socket sc, ServeurInscription  serveurInscription) throws IOException {
        this.serveurInscription=serveurInscription;
        this.sc=sc;
        this.oos=new ObjectOutputStream(sc.getOutputStream());
        this.ois=new ObjectInputStream(sc.getInputStream());
        this.start();
    }

    @Override
    public void run() {
        try {
            Utilisateur utilisateur=(Utilisateur)ois.readObject();
            boolean bool=serveurInscription.Inscrir(utilisateur);
            if(bool){
                oos.writeObject(new String("Inscription effectuée avec succé"));
                serveurInscription.actualiser();
            }
            else{
                oos.writeObject(new String("ce login est déja utilisé!"));
            }
        } catch (IOException ex) {
            Logger.getLogger(NouvelleInscription.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NouvelleInscription.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(NouvelleInscription.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
}
