/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chats;

import Objets.DemandeAjout;
import beans.Contact;
import beans.Utilisateur;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ContactService;
import service.UtilisateurService;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class ServeurAjoutAmis extends Thread{
    
        
        ServerSocket serverSocket;
        ServeurConnexion serveurConnexion;
    public ServeurAjoutAmis(int port,ServeurConnexion serveurConnexion) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.serveurConnexion=serveurConnexion;
        this.start();
    }

    @Override
    public void run() {
       System.out.println("ServeurAjoutAmis en attente des demandes sur le port : "+serverSocket.getLocalPort());
        while(true){
            try {
                Socket sc=this.serverSocket.accept();
                new NouveauAjoutAmis(sc, this);
            } catch (IOException ex) {
                Logger.getLogger(ServeurConnexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    synchronized public boolean ajouter(DemandeAjout da){
        try {
            UtilisateurService us=new UtilisateurService();
            Utilisateur u=us.loadByLogin(da.getLogin());
            if(u==null){
                return false;
            }
            Contact c1=new Contact(da.getIdUser(), u.getId(), null);
            Contact c2=new Contact(u.getId(),da.getIdUser(), null);
            ContactService cs=new ContactService();
            cs.save(c1);
            cs.save(c2);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ServeurInscription.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void actualiser() throws IOException{
       serveurConnexion.actualiserListeUtilisateurs();
    }
    
}
