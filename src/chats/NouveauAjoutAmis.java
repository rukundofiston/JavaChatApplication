/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chats;

import Objets.DemandeAjout;
import beans.Contact;
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
public class NouveauAjoutAmis extends Thread{
    ServeurAjoutAmis serveurAjoutAmis;
    Socket sc;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    public NouveauAjoutAmis(Socket sc, ServeurAjoutAmis  serveurAjoutAmis) throws IOException {
        this.serveurAjoutAmis=serveurAjoutAmis;
        this.sc=sc;
        this.oos=new ObjectOutputStream(sc.getOutputStream());
        this.ois=new ObjectInputStream(sc.getInputStream());
        this.start();
    }


    @Override
    public void run() {
        try {
            DemandeAjout da=(DemandeAjout)ois.readObject();
            boolean bool=serveurAjoutAmis.ajouter(da);
            if(bool){
                oos.writeObject(new String("Ajout effectué avec succé"));
                serveurAjoutAmis.actualiser();
            }
            else{
                oos.writeObject(new String("ce login n'existe pas!"));
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
