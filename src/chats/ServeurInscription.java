/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chats;

import beans.Utilisateur;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.UtilisateurService;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class ServeurInscription extends Thread{
    
        ServerSocket serverSocket;
        ServeurConnexion serveurConnexion;
    public ServeurInscription(int port,ServeurConnexion serveurConnexion) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.serveurConnexion=serveurConnexion;
        this.start();
    }

    @Override
    public void run() {
       System.out.println("ServeurInscription en attente des demandes sur le port : "+serverSocket.getLocalPort());
        while(true){
            try {
                Socket sc=this.serverSocket.accept();
                new NouvelleInscription(sc, this);
                System.out.println("Demande d'inscription accepté de :"+sc.getInetAddress().getHostName()+"/"+sc.getPort());
            } catch (IOException ex) {
                Logger.getLogger(ServeurConnexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    synchronized public boolean Inscrir(Utilisateur utilisateur){
        try {
            UtilisateurService utilisateurService=new UtilisateurService();
            utilisateurService.save(utilisateur);
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
