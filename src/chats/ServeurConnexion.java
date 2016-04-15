/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chats;

import Objets.LoginPasswordSatut;
import beans.Contact;
import beans.Message;
import beans.Utilisateur;
import dao.UtilisateurDao;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ContactService;
import service.UtilisateurService;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class ServeurConnexion extends Thread{
    
    private ListeUtilisateursSocket listeUtilisateursActifs;;
    private ServerSocket serverSocket;

    public ServeurConnexion(int port) throws IOException {
        
        UtilisateurService us=new UtilisateurService();
        ContactService cs=new ContactService();
        listeUtilisateursActifs=new ListeUtilisateursSocket(new Vector<Utilisateur>(us.loadAll()), new Vector<Contact>(cs.loadAll()));
        this.serverSocket = new ServerSocket(port);                
        this.start();
    }   
    

    @Override
    public void run() {
        System.out.println("Serveur en attente des demandes sur le port : "+serverSocket.getLocalPort());
        while(true){
            try {
                Socket sc=this.serverSocket.accept();
                new NouvelleConnexion(sc, this);
                System.out.println("Demande accepté de :"+sc.getInetAddress().getHostName()+"/"+sc.getPort());
            } catch (IOException ex) {
                Logger.getLogger(ServeurConnexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
   public boolean authentifier(LoginPasswordSatut lps){
        return listeUtilisateursActifs.authentifier(lps);
    }
    
   public Vector<Utilisateur> getAmisDe(String login){
       return  listeUtilisateursActifs.getAmisDe(login);
   }
   
   public void changerStatutUtilisateur(LoginPasswordSatut lps, Socket sc, ObjectOutputStream oos, ObjectInputStream ois) throws IOException{
       listeUtilisateursActifs.changerStatutUtilisateur(lps,sc, oos, ois);
   }
   
   public void changerStatutUtilisateur(Utilisateur u, Socket sc, ObjectOutputStream oos, ObjectInputStream ois) throws IOException{
       listeUtilisateursActifs.changerStatutUtilisateur(u,sc, oos, ois);
   }
   
      public void deconnecter(Utilisateur u){
       listeUtilisateursActifs.deconnecter(u);
   }
   
   public ListeUtilisateursSocket getListeUtilisateursActifs() {
        return listeUtilisateursActifs;
   }

    public boolean envoyerMessage(Message msg){
        return listeUtilisateursActifs.envoyerMessage(msg);
    }
    
    public void actualiserListeUtilisateurs() throws IOException{
        UtilisateurService us=new UtilisateurService();
        ContactService cs=new ContactService();
        listeUtilisateursActifs=new ListeUtilisateursSocket(new Vector<Utilisateur>(us.loadAll()), new Vector<Contact>(cs.loadAll()));
    }
    
}
