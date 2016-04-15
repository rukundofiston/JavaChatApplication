/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chats;

import Objets.LoginPasswordSatut;
import Objets.Statut;
import beans.Contact;
import beans.Message;
import beans.Utilisateur;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MessageService;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class ListeUtilisateursSocket {

    Vector<UtilisateurSocket> utilisateurSockets;
    Vector<Contact> contacts;

    public ListeUtilisateursSocket(Vector<Utilisateur> utilisateurs, Vector<Contact> contacts) throws IOException {

        this.utilisateurSockets = new Vector<UtilisateurSocket>();
        this.contacts = new Vector<Contact>();

        for (Utilisateur u : utilisateurs) {
            this.utilisateurSockets.add(new UtilisateurSocket(u));
        }

        for (Contact contact : contacts) {
            this.contacts.add(contact);
        }
    }

    public boolean authentifier(LoginPasswordSatut lps) {

        for (UtilisateurSocket us : utilisateurSockets) {
            if (us.getUtilisateur().getLogin().equals(lps.getLogin()) && us.getUtilisateur().getPassword().equals(lps.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public Vector<Utilisateur> getAmisDe(String login) {

        Utilisateur utilisateur = findUtilisateurByLogin(login);
        Vector<Utilisateur> amis = new Vector<Utilisateur>();
        for (Contact c : contacts) {
            if (c.getIdUtilisateur1() == utilisateur.getId()) {
                for (UtilisateurSocket us : utilisateurSockets) {
                    if (us.getUtilisateur().getId() == c.getIdUtilisateur2()) {
                        amis.add(us.getUtilisateur());
                    }
                }
            }
        }
        amis.add(utilisateur);
        return amis;
    }

    public Utilisateur findUtilisateurByLogin(String login) {

        for (UtilisateurSocket us : utilisateurSockets) {
            if (us.getUtilisateur().getLogin().equals(login)) {
                return us.getUtilisateur();
            }
        }
        return null;
    }

    public Utilisateur findUtilisateurById(int id) {

        for (UtilisateurSocket us : utilisateurSockets) {
            if (us.getUtilisateur().getId() == id) {
                return us.getUtilisateur();
            }
        }
        return null;
    }

    public UtilisateurSocket findUtilisateurSocketByLogin(String login) {

        for (UtilisateurSocket us : utilisateurSockets) {
            if (us.getUtilisateur().getLogin().equals(login)) {
                return us;
            }
        }
        return null;
    }

    public void changerStatutUtilisateur(LoginPasswordSatut lps, Socket sc, ObjectOutputStream oos, ObjectInputStream ois) throws IOException {

        Utilisateur utilisateur = findUtilisateurByLogin(lps.getLogin());
        utilisateur.setStatut(lps.getStatut());

        UtilisateurSocket utilisateurSocket = findUtilisateurSocketByLogin(lps.getLogin());
        utilisateurSocket.setSc(sc);

    }

    public boolean envoyerMessage(Message msg) {

        try{
        MessageService ms = new MessageService();
        ms.save(msg);
        return true;
        }catch(Exception e){
            return false;
        }
    }

    void changerStatutUtilisateur(Utilisateur u, Socket sc, ObjectOutputStream oos, ObjectInputStream ois) throws IOException {
        Utilisateur utilisateur = findUtilisateurByLogin(u.getLogin());
        utilisateur.setStatut(u.getStatut());
        UtilisateurSocket utilisateurSocket = findUtilisateurSocketByLogin(u.getLogin());
        utilisateurSocket.setSc(sc);
    }
    
     void deconnecter(Utilisateur u){
        Utilisateur utilisateur = findUtilisateurByLogin(u.getLogin());
        utilisateur.setStatut(u.getStatut());
    }
}
