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

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class UtilisateurSocket {

    private Utilisateur utilisateur;
    private Socket sc;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public UtilisateurSocket(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
        this.sc = null;
        this.oos = null;
        this.ois = null;
    }

    public void setSc(Socket sc) throws IOException {
        this.sc = sc;
        this.oos=new ObjectOutputStream(sc.getOutputStream());
        this.ois=new ObjectInputStream(sc.getInputStream());
    }

    public ObjectInputStream getOis() {
        return ois;
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

    public Socket getSc() {
        return sc;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    
    
    
    
    
    
}
