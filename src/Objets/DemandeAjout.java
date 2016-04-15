/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objets;

import java.io.Serializable;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class DemandeAjout implements Serializable{
    
    int idUser;
    String login;

    public DemandeAjout() {
    }

    public DemandeAjout(int idUser, String login) {
        this.idUser = idUser;
        this.login = login;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
