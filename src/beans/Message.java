/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class Message implements Serializable{
    
    private int id;
    private int idEmetteur;
    private int idRecepteur;
    private String contenu;
    private Date date;
    private boolean lu;

    public Message() {
    }

    public Message( int idEmetteur, int idRecepteur, String contenu, Date date, boolean lu) {
        this.idEmetteur = idEmetteur;
        this.idRecepteur = idRecepteur;
        this.contenu = contenu;
        this.date = date;
        this.lu = lu;
    }

    public Message(Message msg) {
        this.id = msg.getId();
        this.idEmetteur = msg.getIdEmetteur();
        this.idRecepteur = msg.getIdRecepteur();
        this.contenu = msg.getContenu();
        this.date = msg.getDate();
        this.lu = msg.getLu();
    }

    




    public void setId(int id) {
        this.id = id;
    }

    public void setIdRecepteur(int idRecepteur) {
        this.idRecepteur = idRecepteur;
    }

    public void setIdEmetteur(int idEmetteur) {
        this.idEmetteur = idEmetteur;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLu(boolean lu) {
        this.lu = lu;
    }
    
    
    public boolean getLu(){
        return lu;
    }

    public String getContenu() {
        return contenu;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getIdEmetteur() {
        return idEmetteur;
    }

    public int getIdRecepteur() {
        return idRecepteur;
    }
    
    
    
    @Override
    public String toString() {
        return id+":"+contenu+":"+date+":"+lu;
    }
    
    
    
}
