/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chats;

import beans.Utilisateur;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class ServeurDeconnexion extends Thread{
        
    private ServerSocket serverSocket;
    ServeurConnexion serveurConnexion;
    
    public ServeurDeconnexion(int port, ServeurConnexion serveurConnexion) throws IOException {
        serverSocket=new ServerSocket(port);
        this.serveurConnexion=serveurConnexion;
        this.start();
    }
    
        @Override
    public void run() {
        System.out.println("ServeurDeconnexion en attente des demandes sur le port : "+serverSocket.getLocalPort());
        while(true){
            try {
                Socket sc=this.serverSocket.accept();
                new NouvelleDeconnexion(sc, this);
            } catch (IOException ex) {
                Logger.getLogger(ServeurConnexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       }
        
        public void deconnecter(Utilisateur u){
            serveurConnexion.deconnecter(u);
            
        }
}
