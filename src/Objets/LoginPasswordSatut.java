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
public class LoginPasswordSatut implements Serializable{
    String login;
    String password;
    Statut statut;

    public LoginPasswordSatut(String login, String password, Statut statut) {
        this.login = login;
        this.password = password;
        this.statut = statut;
    }   

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Statut getStatut() {
        return statut;
    }
    
    
    
    
}
